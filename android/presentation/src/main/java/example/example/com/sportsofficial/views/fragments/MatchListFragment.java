package example.example.com.sportsofficial.views.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import dagger.ObjectGraph;
import example.example.com.sportsofficial.R;
import example.example.com.sportsofficial.models.Match;
import example.example.com.sportsofficial.presenters.MatchListModule;
import example.example.com.sportsofficial.presenters.MatchListPresenter;
import example.example.com.sportsofficial.views.Injector;
import example.example.com.sportsofficial.views.MatchListView;

public class MatchListFragment extends Fragment implements MatchListView {
    public final static SportTabsFragment.TabFactory TAB_FACTORY = new SportTabsFragment.TabFactory() {
        @Override
        public Fragment newInstance() {
            return new MatchListFragment();
        }
    };

    @Inject
    MatchListPresenter mPresenter;
    private ObjectGraph mObjectGraph;
    private boolean mIsFirstAttach = true;

    private Handler mHandler;
    private ListView mListView;
    private MatchListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get handler
        mHandler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view, container, false);
        mListView = (ListView) view.findViewById(R.id.list);

        mPresenter.onCreate();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Setup the dagger graph
        List<Object> modules = Arrays.<Object>asList(new MatchListModule(this));

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
     * @param matchList
     */
    @Override
    public void setMatchList(List<Match> matchList) {
        mAdapter = new MatchListAdapter(getActivity(), R.layout.match_row_layout, matchList);
        mListView.setAdapter(mAdapter);
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

    public void passMatch(String homeTeam, String awayTeam, String league, String tournament,
                          Integer homeScore, Integer awayScore) {
        mPresenter.addMatch(homeTeam, awayTeam, league, tournament, homeScore, awayScore);
    }

    /**
     *
     */
    private class MatchListAdapter extends ArrayAdapter<Match> {
        private Activity mContext;
        private List<Match> mMatchList;

        public MatchListAdapter (Activity context, int resource, List<Match> matchList) {
            super(context, resource, matchList);
            mContext = context;
            mMatchList = matchList;
        }

        private class ViewHolder {
            TextView game;
            TextView date;
            TextView time;
        }

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {
            // If the row has not been instantiated, inflate the view and setup the view holder
            if (rowView == null) {
                LayoutInflater inflater = mContext.getLayoutInflater();
                rowView = inflater.inflate(R.layout.match_row_layout, null);

                ViewHolder viewHolder = new ViewHolder();
                viewHolder.game = (TextView) rowView.findViewById(R.id.game);
                viewHolder.date = (TextView) rowView.findViewById(R.id.date);
                viewHolder.time = (TextView) rowView.findViewById(R.id.time);

                rowView.setTag(viewHolder);
            }

            // If there is a match at the requested location
            if (mMatchList.get(position) != null) {
                ViewHolder holder = (ViewHolder) rowView.getTag();

                holder.game.setText(mMatchList.get(position).toString());
                holder.date.setText(mMatchList.get(position).getDate().toString());
                holder.time.setText(mMatchList.get(position).getTime().toString());
            }

            return rowView;
        }
    }
}
