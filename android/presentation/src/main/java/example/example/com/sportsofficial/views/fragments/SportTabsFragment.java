package example.example.com.sportsofficial.views.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import example.example.com.sportsofficial.R;
import example.example.com.sportsofficial.models.Sport;
import example.example.com.sportsofficial.presenters.SportModule;
import example.example.com.sportsofficial.views.Injector;
import example.example.com.sportsofficial.views.ViewTabs;

public class SportTabsFragment extends Fragment implements Injector {
    public  interface TabFactory<T extends Fragment> {
        public T newInstance();
    }

    private ViewPager mViewPager;
    private ViewTabs mViewTabs;
    private List<Tab> mTabs;

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the arguments
        Bundle args = getArguments();
        Sport sport = (Sport) args.getParcelable(getString(R.string.sport));

        // Setup the dagger graph
        List<Object> modules = Arrays.<Object>asList(new SportModule(sport));
        mObjectGraph = ((Injector) getActivity()).getObjectGraph().plus(modules.toArray());
        mObjectGraph.inject(this);

        // Creates tabs
        mTabs = new ArrayList<>();

        if (sport.hasLeagues()) {
            mTabs.add(new Tab(LeagueListFragment.TAB_FACTORY, getString(R.string.leagues)));
        }

        if (sport.hasTournaments()) {
            mTabs.add(new Tab(TournamentListFragment.TAB_FACTORY, getString(R.string.tournaments)));
        }

        if (sport.hasMatches()) {
            mTabs.add(new Tab(MatchListFragment.TAB_FACTORY, getString(R.string.matches)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tabs, container, false);
    }

    @Override
    public void onDestroy() {
        // Clear object graph reference to allow garbage collector to clean it up
        mObjectGraph = null;
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Set up the view pager
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        // Set up the tabs
        mViewTabs = (ViewTabs) view.findViewById(R.id.view_tabs);
        mViewTabs.setTitleColor(Color.BLACK);
        mViewTabs.setFittingChildren(true);
        mViewTabs.setTabType(ViewTabs.TabType.TEXT);
        mViewTabs.setViewPager(mViewPager);
    }

    /**
     * Gets this Fragments's object graph.
     *
     * @return the object graph
     */
    @Override
    public final ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
    /**
     * Injects a target object using this Fragment's object graph.
     *
     * @param object the target object
     */
    @Override
    public void inject(Object object) {
        mObjectGraph.inject(object);
    }

    public Fragment getCurrentFragment() {
        return mTabs.get(mViewPager.getCurrentItem()).getFragment();
    }

    public static class Tab {
        private final TabFactory mTabFactory;
        private final CharSequence mTitle;
        private Fragment mFragment;

        Tab(TabFactory tabFactory, CharSequence title) {
            mTabFactory = tabFactory;
            mTitle = title;
        }

        Fragment createFragment() {
            mFragment = mTabFactory.newInstance();
            return mFragment;
        }

        Fragment getFragment() {
            return mFragment;
        }

        CharSequence getTitle() {
            return mTitle;
        }
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mTabs.get(position).createFragment();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs.get(position).getTitle();
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public int getItemPosition(Object object){
            return PagerAdapter.POSITION_NONE;
        }
    }
}
