package example.example.com.sportsofficial.presentation.presenters;

import android.content.Context;
import android.content.res.TypedArray;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.UUID;

import example.example.com.sportsofficial.R;
import example.example.com.sportsofficial.domain.interactors.AddMatchInteractor;
import example.example.com.sportsofficial.presentation.App;
import example.example.com.sportsofficial.presentation.models.MainModel;
import example.example.com.sportsofficial.presentation.models.Sport;
import example.example.com.sportsofficial.presentation.views.MainView;
import example.example.com.sportsofficial.presentation.views.Navigator;

public class MainPresenterImpl implements MainPresenter {
    private final static UUID PEBBLE_APP_UUID = UUID.fromString("432e9210-e61d-49e2-874f-e899af0472e5");
    private final static int SYNC_KEY = 0;
    private final static int HOME_SCORE_KEY = 1;
    private final static int AWAY_SCORE_KEY = 2;
    private final static int NUM_SCORES_KEY = 3;
    private final static int SINGLE_CLICK_KEY = 10;
    private final static int DOUBLE_CLICK_KEY = 11;
    private final static int LONG_CLICK_KEY = 12;
    private final static int DETAIL_POINTS_START = 100;

    private App mApp;
    private MainModel mModel;
    private MainView mView;

    private AddMatchInteractor mAddMatchInteractor;

    public MainPresenterImpl(App app, MainModel model, MainView view,
                             AddMatchInteractor addMatchInteractor) {
        mApp = app;
        mModel = model;
        mView = view;

        mAddMatchInteractor = addMatchInteractor;
    }

    /**
     *
     */
    @Override
    public void onCreate() {
        // Add the default sports
        int sportsCount = mApp.getResources().getInteger(R.integer.default_sports_count);
        String[] sportNames = mApp.getResources().getStringArray(R.array.default_sport_names);
        TypedArray sportIcons = mApp.getResources().obtainTypedArray(R.array.default_sport_icons);
        TypedArray sportHasLeagues = mApp.getResources().obtainTypedArray(R.array.default_sports_has_leagues);
        TypedArray sportHasTournaments = mApp.getResources().obtainTypedArray(R.array.default_sports_has_tournaments);
        TypedArray sportHasMatches= mApp.getResources().obtainTypedArray(R.array.default_sports_has_matches);

        for (int i = 0; i < sportsCount; i++) {
            Sport sport = new Sport(sportNames[i],
                    sportIcons.getResourceId(i, -1),
                    sportHasLeagues.getBoolean(i, false),
                    sportHasTournaments.getBoolean(i, false),
                    sportHasMatches.getBoolean(i, false));

            mModel.addSport(sport);
            mView.addSportNav(sport);
        }

        mView.navigateToHome();
    }

    @Override
    public void onResume() {
        PebbleKit.registerReceivedDataHandler(mApp, dataHandler);
    }

    @Override
    public void onPause() {
        try {
            if (dataHandler != null) {
                mApp.unregisterReceiver(dataHandler);
                dataHandler = null;
            }
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     *
     * @param navItemType
     * @param sportTitle
     */
    @Override
    public void onNavigationItemClicked(Navigator.NavItemType navItemType, String sportTitle) {
        switch (navItemType) {
            case HOME:
                mView.setActionBarTitle(mApp.getString(R.string.app_name));
                mView.navigateToHome();
                break;
            case SPORT:
                mView.setActionBarTitle(sportTitle);
                mView.navigateToSportView(mModel.getSport(sportTitle).getId());
                break;
            case ADD_SPORT:
                mView.showAddSportDialog();
                break;
            case REMOVE_SPORT:
                mView.showRemoveSportDialog(mModel.getSportsTitles());
                break;
            case SETTINGS:
                mView.navigateToSettings();
                break;
            case ABOUT:
                mView.navigateToAbout();
                break;
            case HELP:
                mView.navigateToHelp();
                break;
            default:
                break;
        }
    }

    @Override
    public void onSyncClicked() {
        PebbleDictionary sync = new PebbleDictionary();
        sync.addInt32(SYNC_KEY, 0);
        PebbleKit.sendDataToPebble(mApp, PEBBLE_APP_UUID, sync);
        mView.showPebbleSyncProgressDialog();
    }

    @Override
    public void onPebbleSyncSuccess(String homeTeam, String awayTeam) {
        mView.closePebbleSyncProgressDialog();
        mView.showCreateMatchDialog();
    }

    @Override
    public void onPebbleSportClicked() {
        mView.showChangePebbleSportDialog(mModel.getSportsTitles());
    }

    @Override
    public void onChangePebbleSportPositiveClicked(String sport) {
        PebbleKit.startAppOnPebble(mApp, PEBBLE_APP_UUID);

        PebbleDictionary click_settings = new PebbleDictionary();

        //click_settings.addInt32(SINGLE_CLICK_KEY, singleClick);
        //click_settings.addInt32(DOUBLE_CLICK_KEY, doubleClick);
        //click_settings.addInt32(LONG_CLICK_KEY, longClick);

        PebbleKit.sendDataToPebble(mApp, PEBBLE_APP_UUID, click_settings);
    }

    @Override
    public void onAddMatchDialogPositiveClicked(String homeTeam, String awayTeam) {


    }

    @Override
    public void onAddSportDialogPositiveClicked(String sportTitle) {
        Sport sport = new Sport(sportTitle, -1, true, true, true);

        mModel.addSport(sport);
        mView.addSportNav(sport);
    }

    @Override
    public void onRemoveSportDialogPositiveClicked(String sportTitle) {
        mView.removeSportNav(mModel.getSport(sportTitle));
        mModel.removeSport(sportTitle);
    }

    PebbleKit.PebbleDataReceiver dataHandler = new PebbleKit.PebbleDataReceiver(PEBBLE_APP_UUID){
        public void receiveData(final Context context, final int transactionID, final PebbleDictionary data) {
            //ACK
            PebbleKit.sendAckToPebble(context, transactionID);

            // Get data
            Long homeScore = data.getInteger(HOME_SCORE_KEY);
            Long awayScore = data.getInteger(AWAY_SCORE_KEY);
            Long numScores = data.getInteger(NUM_SCORES_KEY);

            String detailedScore;
            for(int i = DETAIL_POINTS_START; i < numScores + 100; i++){
                detailedScore = data.getString(i);
            }
        }
    };
}
