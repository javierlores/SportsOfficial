package example.example.com.sportsofficial.presenters;

import android.content.res.TypedArray;

import com.example.domain.interactors.AddLeagueMatchInteractor;
import com.example.domain.interactors.AddMatchInteractor;
import com.example.domain.interactors.AddTournamentMatchInteractor;

import example.example.com.sportsofficial.App;
import example.example.com.sportsofficial.R;
import example.example.com.sportsofficial.models.MainModel;
import example.example.com.sportsofficial.models.Sport;
import example.example.com.sportsofficial.views.MainView;
import example.example.com.sportsofficial.views.Navigator;

public class MainPresenterImpl implements MainPresenter {



    private App mApp;
    private MainModel mModel;
    private MainView mView;
    private AddMatchInteractor mAddMatchInteractor;
    private AddTournamentMatchInteractor mAddTournamentMatchInteractor;
    private AddLeagueMatchInteractor mAddLeagueMatchInteractor;

    public MainPresenterImpl(App app, MainModel model, MainView view,
                             AddMatchInteractor addMatchInteractor,
                             AddTournamentMatchInteractor addTournamentMatchInteractor,
                             AddLeagueMatchInteractor addLeagueMatchInteractor) {
        mApp = app;
        mModel = model;
        mView = view;
        mAddMatchInteractor = addMatchInteractor;
        mAddTournamentMatchInteractor = addTournamentMatchInteractor;
        mAddLeagueMatchInteractor = addLeagueMatchInteractor;
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

            // Add the sport to the model
            mModel.addSport(sport);

            // Add the sport to the navigation
            mView.addSportNav(sport);
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
                mView.navigateToSportView(mModel.getSport(sportTitle));
                break;
            case ADD_SPORT:
                mView.showAddSportDialog();
                break;
            case REMOVE_SPORT:
                mView.showRemoveSportDialog();
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
        mView.showAddMatchDialog();
    }

    @Override
    public void onAddMatchDialogPositiveClicked(String homeTeam, String awayTeam,
                                                String league, String tournament) {




    }

    @Override
    public void onAddSportClicked() {
        mView.showAddSportDialog();
    }

    @Override
    public void onAddSportDialogPositiveClicked(String name) {
        Sport sport = new Sport(name, -1, true, true, true);

        mModel.addSport(sport);
        mView.addSportNav(sport);
    }

    @Override
    public void onRemoveSportClicked() {
        mView.showRemoveSportDialog();
    }

    @Override
    public void onRemoveSportDialogPositiveClicked() {
        //mModel.removeSport(sport);
        //mView.removeSportNav(sport);
    }
}
