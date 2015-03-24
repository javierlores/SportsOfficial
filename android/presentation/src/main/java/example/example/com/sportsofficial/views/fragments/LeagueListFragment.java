package example.example.com.sportsofficial.views.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import dagger.ObjectGraph;
import example.example.com.sportsofficial.R;
import example.example.com.sportsofficial.models.League;
import example.example.com.sportsofficial.presenters.LeagueListModule;
import example.example.com.sportsofficial.presenters.LeagueListPresenter;
import example.example.com.sportsofficial.views.Injector;
import example.example.com.sportsofficial.views.LeagueListView;
import example.example.com.sportsofficial.views.dialogs.CreateLeagueDialogFragment;

public class LeagueListFragment extends Fragment implements LeagueListView, CreateLeagueDialogFragment.DialogClickListener {
    public final static SportTabsFragment.TabFactory TAB_FACTORY = new SportTabsFragment.TabFactory() {
        @Override
        public Fragment newInstance() {
            return new LeagueListFragment();
        }
    };

    @Inject
    LeagueListPresenter mPresenter;
    private ObjectGraph mObjectGraph;
    private boolean mIsFirstAttach = true;

    private Handler mHandler;
    private ListView mListView;
    private ImageButton mImageButton;
    private LeagueListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get handler
        mHandler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view_fab, container, false);

        mListView = (ListView) view.findViewById(R.id.list);
        mImageButton = (ImageButton) view.findViewById(R.id.fab_image_button);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onAddLeagueClicked();
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                           final View view, final int position, long id) {
                removeRow(view, position);
                return true;
            }
        });


        mPresenter.onCreate();
        return view;
    }

    private void removeRow(final View row, final int position) {
        final int initialHeight = row.getHeight();
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime,
                                               Transformation t) {
                super.applyTransformation(interpolatedTime, t);
                int newHeight = (int) (initialHeight * (1 - interpolatedTime));
                if (newHeight > 0) {
                    row.getLayoutParams().height = newHeight;
                    row.requestLayout();
                }
            }
        };
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                row.getLayoutParams().height = initialHeight;
                row.requestLayout();
                mPresenter.onRemoveLeagueClicked(position);
            }
        });
        animation.setDuration(300);
        row.startAnimation(animation);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Setup the dagger graph
        List<Object> modules = Arrays.<Object>asList(new LeagueListModule(this));

        FragmentManager manager = getActivity().getSupportFragmentManager();
        Injector injector = (Injector) manager.findFragmentByTag("TabFragment");

        mObjectGraph = injector.getObjectGraph().plus(modules.toArray());

        // Ensure this is the first time creating the graph
        if (mIsFirstAttach) {
            mObjectGraph.inject(this);
            mIsFirstAttach = false;
        }
    }

    @Override
    public void onDestroy() {
        mObjectGraph = null;
        super.onDestroy();
    }

    /**
     *
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showAddLeagueDialog() {
        DialogFragment dialog = new CreateLeagueDialogFragment();
        dialog.setTargetFragment(this, 0);
        dialog.show(getActivity().getSupportFragmentManager(), "CreateLeagueDialogFragment");
    }

    /**
     *
     * @param leagueList
     */
    @Override
    public void setLeagueList(List<League> leagueList) {
        mAdapter = new LeagueListAdapter(getActivity(), R.layout.league_row_layout, leagueList);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onPositiveClick(String name, String country, String city, String address) {
        mPresenter.onAddLeagueCreateClicked(name, country, city, address);
    }

    @Override
    public void onNegativeClick() {

    }

    /**
     *
     */
    private class LeagueListAdapter extends ArrayAdapter<League> {
        private Activity mContext;
        private List<League> mLeaguesList;

        public LeagueListAdapter (Activity context, int resource, List<League> leaguesList) {
            super(context, resource, leaguesList);
            mContext = context;
            mLeaguesList = leaguesList;
        }

        private class ViewHolder {
            TextView name;
            TextView location;
        }

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {
            // If the row has not been instantiated, inflate the view and setup the view holder
            if (rowView == null) {
                LayoutInflater inflater = mContext.getLayoutInflater();
                rowView = inflater.inflate(R.layout.league_row_layout, null);

                ViewHolder viewHolder = new ViewHolder();
                viewHolder.name = (TextView) rowView.findViewById(R.id.name);
                viewHolder.location = (TextView) rowView.findViewById(R.id.location);

                rowView.setTag(viewHolder);
            }

            // If there is a league at the requested location
            if (mLeaguesList.get(position) != null) {
                ViewHolder holder = (ViewHolder) rowView.getTag();

                holder.name.setText(mLeaguesList.get(position).getName());
                holder.location.setText(mLeaguesList.get(position).getLocation().toString());
            }

            return rowView;
        }
    }
}
