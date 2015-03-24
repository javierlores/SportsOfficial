package example.example.com.sportsofficial.views.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import dagger.ObjectGraph;
import example.example.com.sportsofficial.App;
import example.example.com.sportsofficial.R;
import example.example.com.sportsofficial.models.Sport;
import example.example.com.sportsofficial.presenters.MainModule;
import example.example.com.sportsofficial.presenters.MainPresenter;
import example.example.com.sportsofficial.views.Injector;
import example.example.com.sportsofficial.views.MainView;
import example.example.com.sportsofficial.views.Navigator;
import example.example.com.sportsofficial.views.dialogs.ChangePebbleSettingsDialogFragment;
import example.example.com.sportsofficial.views.dialogs.CreateMatchDialogFragment;
import example.example.com.sportsofficial.views.dialogs.CreateSportDialogFragment;
import example.example.com.sportsofficial.views.fragments.HomeFragment;
import example.example.com.sportsofficial.views.fragments.MatchListFragment;
import example.example.com.sportsofficial.views.fragments.SportTabsFragment;


/**
 *
 */
public class MainActivity extends ActionBarActivity implements MainView, Injector,
        CreateMatchDialogFragment.CreateMatchDialogListener, CreateSportDialogFragment.CreateSportDialogListener,
        ChangePebbleSettingsDialogFragment.ChangePebbleSettingsDialogListener{
    private final static UUID PEBBLE_APP_UUID = UUID.fromString("432e9210-e61d-49e2-874f-e899af0472e5");
    private final static int SYNC_KEY = 0;
    private final static int HOME_SCORE_KEY = 1;
    private final static int AWAY_SCORE_KEY = 2;
    private final static int NUM_SCORES_KEY = 3;
    private final static int SINGLE_CLICK_KEY = 10;
    private final static int DOUBLE_CLICK_KEY = 11;
    private final static int LONG_CLICK_KEY = 12;
    private final static int DETAIL_POINTS_START = 100;


    public static int NAV_ITEM_COUNT = 6;
    public static String[] NAV_ITEM_TITLES = {
            "Home",
            null,
            //"Add sport",
            //"Remove sport",
            null,
            "Settings",
            "About",
            "Help"
    };

    public static Navigator.NavItemType[] NAV_ITEM_TYPES = {
            Navigator.NavItemType.HOME,
            Navigator.NavItemType.DIVIDER,
          //  Navigator.NavItemType.ADD_SPORT,
           // Navigator.NavItemType.REMOVE_SPORT,
            Navigator.NavItemType.DIVIDER,
            Navigator.NavItemType.SETTINGS,
            Navigator.NavItemType.ABOUT,
            Navigator.NavItemType.HELP
    };

    public static int[] NAV_ITEM_ICONS = {
            R.mipmap.ic_action_home,
            -1,
          //  R.mipmap.ic_placeholder,
          //  R.mipmap.ic_placeholder,
            -1,
            R.mipmap.ic_action_settings,
            R.mipmap.ic_placeholder,
            R.mipmap.ic_placeholder
    };

    private Toolbar mToolbar;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerListView;
    private NavDrawerListAdapter mDrawerAdapter;
    private List<NavDrawerItem> mDrawerItems;

    private String mHomeTeam;
    private String mAwayTeam;
    private String mLeague;
    private String mTournament;

    @Inject
    MainPresenter mPresenter;
    private ObjectGraph mObjectGraph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup the dagger graph
        List<Object> modules = Arrays.<Object>asList(new MainModule(this));
        mObjectGraph = ((App) getApplication()).getObjectGraph().plus(modules.toArray());
        mObjectGraph.inject(this);

        // Setup the action bar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        // Setup drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Set up drawer list view
        mDrawerListView = (ListView) findViewById(R.id.drawer_list_view);

        // Set up drawer item click listener
        mDrawerListView.setOnItemClickListener(new DrawerItemListener());

        // Set up the action bar drawer toggle
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawer.setDrawerListener(mDrawerToggle);

        // Create default navigation drawer items
        mDrawerItems = new ArrayList<>();
        for (int i = 0; i < NAV_ITEM_COUNT; i++) {
           NavDrawerItem navItem = new NavDrawerItem(NAV_ITEM_TITLES[i], NAV_ITEM_ICONS[i],
                   NAV_ITEM_TYPES[i]);
           mDrawerItems.add(navItem);
        }

        // Set up the navigation drawer adapter
        mDrawerAdapter = new NavDrawerListAdapter(this, mDrawerItems);
        mDrawerListView.setAdapter(mDrawerAdapter);

        mPresenter.onCreate();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        PebbleKit.registerReceivedDataHandler(getApplicationContext(), dataHandler);
    }

    @Override
    protected void onPause() {
        super.onPause();

        try {
            if (dataHandler != null) {
                unregisterReceiver(dataHandler);
                dataHandler = null;
            }
        } catch (IllegalArgumentException e) {

        }
    }

    @Override
    protected void onDestroy() {
        // Clear object graph reference to allow garbage collector to clean it up
        mObjectGraph = null;
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else {
            int itemId = item.getItemId();

            if (itemId == R.id.action_sync) {
                mPresenter.onSyncClicked();
            } else if (itemId == R.id.action_pebble_settings) {
                DialogFragment dialog = new ChangePebbleSettingsDialogFragment();
                dialog.show(getSupportFragmentManager(), "ChangePebbleSettingsDialogFragment");
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     *
     * @param title
     */
    @Override
    public void setActionBarTitle(String title) {
        setTitle(title);
    }

    /**
     *
     */
    @Override
    public void showAddMatchDialog() {
        DialogFragment dialog = new CreateMatchDialogFragment();
        dialog.show(getSupportFragmentManager(), "CreateMatchDialogFragment");
    }

    /**
     *
     */
    @Override
    public void showAddSportDialog() {
        DialogFragment dialog = new CreateSportDialogFragment();
        dialog.show(getSupportFragmentManager(), "AddSportDialogFragment");
    }

    /**
     *
     */
    @Override
    public void showRemoveSportDialog() {

    }

    /**
     *
     * @param sport
     */
    @Override
    public void addSportNav(Sport sport) {
        NavDrawerItem navItem = new NavDrawerItem(sport.getName(), sport.getIcon(),
                Navigator.NavItemType.SPORT);

        mDrawerItems.add(mDrawerItems.size() - 4, navItem);
        mDrawerAdapter.notifyDataSetChanged();
    }

    /**
     *
     * @param sport
     */
    @Override
    public void removeSportNav(Sport sport) {
        for (int i = 1; i < mDrawerItems.size() - 6; i ++) {
            if (mDrawerItems.get(i).getTitle().equals(sport.getName())) {
                mDrawerItems.remove(i);
            }
        }
    }

    /**
     *
     * @param sport
     */
    @Override
    public void navigateToSportView(Sport sport) {
        // Create the sports fragment
        SportTabsFragment fragment = new SportTabsFragment();

        // Create and add the arguments to the fragment
        Bundle args = new Bundle();
        args.putParcelable(getString(R.string.sport), sport);
        fragment.setArguments(args);

        // Insert the fragment by replacing the existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, fragment, "TabFragment").commit();
    }

    /**
     *
     */
    @Override
    public void navigateToHome() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
    }

    /**
     *
     */
    @Override
    public void navigateToSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /**
     *
     */
    @Override
    public void navigateToAbout() {
        //Intent intent = new Intent(this, AboutActivity.class);
        //startActivity(intent);
    }

    /**
     *
     */
    @Override
    public void navigateToHelp() {
        //Intent intent = new Intent(this, HelpActivity.class);
        //startActivity(intent);
    }

    /**
     * Gets this Activity's object graph.
     *
     * @return the object graph
     */
    @Override
    public final ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
    /**
     * Injects a target object using this Activity's object graph.
     *
     * @param object the target object
     */
    @Override
    public void inject(Object object) {
        mObjectGraph.inject(object);
    }

    @Override
    public void onCreateMatchDialogPositiveClicked(String homeTeam, String awayTeam,
                                                   String league, String tournament) {

        PebbleDictionary sync = new PebbleDictionary();
        sync.addInt32(SYNC_KEY, 0);
        PebbleKit.sendDataToPebble(getApplicationContext(), PEBBLE_APP_UUID, sync);

        mHomeTeam = homeTeam;
        mAwayTeam = awayTeam;
        mLeague = league;
        mTournament = tournament;
    }

    PebbleKit.PebbleDataReceiver dataHandler = new PebbleKit.PebbleDataReceiver(PEBBLE_APP_UUID){
        public void receiveData(final Context context, final int transactionID, final PebbleDictionary data){
            //ACK
            PebbleKit.sendAckToPebble(context, transactionID);

            //Get data
            Long home_score = data.getInteger(HOME_SCORE_KEY);
            Long away_score = data.getInteger(AWAY_SCORE_KEY);
            Long num_scores = data.getInteger(NUM_SCORES_KEY);
            //String detailed_score;
            //for(int i = DETAIL_POINTS_START; i < num_scores+100; i++){
            //    detailed_score = data.getString(i);
            //}


            SportTabsFragment fragment = (SportTabsFragment) getSupportFragmentManager().findFragmentByTag("TabFragment");


            Fragment currentFragment = fragment.getCurrentFragment();

            Integer homeScore = (int) (long) home_score;
            Integer awayScore = (int) (long) away_score;

            if (currentFragment instanceof MatchListFragment) {
                ((MatchListFragment) currentFragment).passMatch(mHomeTeam, mAwayTeam, mLeague, mTournament, homeScore, awayScore);
            }
        }
    };

    @Override
    public void onCreateSportDialogPositiveClicked(String name) {
        mPresenter.onAddSportDialogPositiveClicked(name);
    }

    @Override
    public void onChangePebbleSettingsPositiveClicked(int singleClick, int doubleClick, int longClick) {
        PebbleKit.startAppOnPebble(getApplicationContext(), PEBBLE_APP_UUID);

        PebbleDictionary click_settings = new PebbleDictionary();

        click_settings.addInt32(SINGLE_CLICK_KEY, singleClick);
        click_settings.addInt32(DOUBLE_CLICK_KEY, doubleClick);
        click_settings.addInt32(LONG_CLICK_KEY, longClick);

        PebbleKit.sendDataToPebble(getApplicationContext(), PEBBLE_APP_UUID, click_settings);
    }

    /**
     *
     */
    private class DrawerItemListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Notify presenter
            Navigator.NavItemType navItemType = mDrawerItems.get(position).getItemType();
            String sportTitle = (navItemType == Navigator.NavItemType.SPORT) ? mDrawerItems.get(position).getTitle() : null;

            mPresenter.onNavigationItemClicked(navItemType, sportTitle);

            // Handle drawer
            mDrawerListView.setItemChecked(position, true);
            mDrawer.closeDrawer(mDrawerListView);
        }
    }

    /**
     *
     */
    private class NavDrawerItem {
        private String mTitle;
        private int mIcon;
        private Navigator.NavItemType mItemType;

        public NavDrawerItem(String title, int icon, Navigator.NavItemType itemType){
            mTitle = title;
            mIcon = icon;
            mItemType = itemType;
        }

        public String getTitle(){
            return this.mTitle;
        }

        public int getIcon(){
            return this.mIcon;
        }

        public Navigator.NavItemType getItemType() {
            return mItemType;
        }

        public void setTitle(String title){
            mTitle = title;
        }

        public void setIcon(int icon){
            mIcon = icon;
        }

        public void setItemType(Navigator.NavItemType itemType) {
            mItemType = itemType;
        }
    }


    /**
     *
     */
    private class NavDrawerListAdapter extends BaseAdapter {
        private Context mContext;
        private List<NavDrawerItem> mNavItems;

        public NavDrawerListAdapter(Context context, List<NavDrawerItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        private class ViewHolder {
            ImageView icon;
            TextView title;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {
            if (rowView == null) {
                ViewHolder viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(mContext);

                switch (mNavItems.get(position).getItemType()) {
                    case HOME:
                    case SPORT:
                    case ADD_SPORT:
                    case REMOVE_SPORT:
                    case SETTINGS:
                    case ABOUT:
                    case HELP:
                        rowView = inflater.inflate(R.layout.drawer_nav_item, null);
                        viewHolder.title = (TextView) rowView.findViewById(R.id.title);
                        //viewHolder.icon = (ImageView) rowView.findViewById(R.id.icon);
                        break;
                    case DIVIDER:
                        rowView = inflater.inflate(R.layout.drawer_list_divider, null);
                        break;
                }
                rowView.setTag(viewHolder);
            }

            ViewHolder viewHolder = (ViewHolder) rowView.getTag();
            switch (mNavItems.get(position).getItemType()) {
                case HOME:
                case SPORT:
                case ADD_SPORT:
                case REMOVE_SPORT:
                case SETTINGS:
                case ABOUT:
                case HELP:
                   // viewHolder.icon.setImageResource(mNavItems.get(position).getIcon());
                    viewHolder.title.setText(mNavItems.get(position).getTitle());
                    break;
                case DIVIDER:
                    break;
            }
            return rowView;
        }
    }
}
