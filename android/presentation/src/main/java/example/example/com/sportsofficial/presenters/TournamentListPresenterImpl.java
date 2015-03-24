package example.example.com.sportsofficial.presenters;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.interactors.AddTournamentInteractor;
import com.example.domain.interactors.GetTournamentListInteractor;
import com.example.domain.interactors.RemoveTournamentInteractor;
import com.example.domain.interactors.UpdateTournamentInteractor;

import java.util.ArrayList;
import java.util.List;

import example.example.com.sportsofficial.models.Date;
import example.example.com.sportsofficial.models.Location;
import example.example.com.sportsofficial.models.Tournament;
import example.example.com.sportsofficial.models.TournamentListModel;
import example.example.com.sportsofficial.views.TournamentListView;

public class TournamentListPresenterImpl implements TournamentListPresenter {
    private TournamentListModel mModel;
    private TournamentListView mView;
    
    private GetTournamentListInteractor mGetTournamentListInteractor;
    private AddTournamentInteractor mAddTournamentsInteractor;
    private RemoveTournamentInteractor mRemoveTournamentsInteractor;
    private UpdateTournamentInteractor mUpdateTournamentInteractor;

    public TournamentListPresenterImpl(TournamentListModel model, TournamentListView view,
                                       GetTournamentListInteractor getTournamentListInteractor,
                                       AddTournamentInteractor addTournamentInteractor,
                                       RemoveTournamentInteractor removeTournamentInteractor,
                                       UpdateTournamentInteractor updateTournamentInteractor) {
        mModel = model;
        mView = view;
        mGetTournamentListInteractor = getTournamentListInteractor;
        mAddTournamentsInteractor = addTournamentInteractor;
        mRemoveTournamentsInteractor = removeTournamentInteractor;
        mUpdateTournamentInteractor = updateTournamentInteractor;
    }

    @Override
    public void onCreate() {
        List<Tournament> tournamentList = new ArrayList<>();

        if (mModel.getSport().getName().equals("Football")) {
            Tournament tournament1 = new Tournament();
            tournament1.setName("Sectionals");

            Location location1 = new Location();
            location1.setCountry("USA");
            location1.setCity("Orlando");
            location1.setState("FL");

            tournament1.setLocation(location1);

            Date date = new Date();
            date.setYear(2015);
            date.setMonth(7);
            date.setDay(10);

            tournament1.setDate(date);

            tournamentList.add(tournament1);

            Tournament tournament2 = new Tournament();
            tournament2.setName("Regionals");
            Location location2 = new Location();
            location1.setCountry("USA");
            location1.setCity("Miami");
            location1.setState("FL");

            tournament1.setLocation(location2);

            date = new Date();
            date.setYear(2015);
            date.setMonth(7);
            date.setDay(10);

            tournament2.setDate(date);

            tournamentList.add(tournament2);

            Tournament tournament3 = new Tournament();

            tournament3.setName("Nationals");
            Location location3 = new Location();
            location3.setCountry("USA");
            location3.setCity("NY");
            location3.setState("NY");

            tournament3.setLocation(location3);

            date = new Date();
            date.setYear(2020);
            date.setMonth(8);
            date.setDay(1);

            tournament3.setDate(date);

            tournamentList.add(tournament3);

            mModel.setTournamentList(tournamentList);
        }

        mView.setTournamentsList(mModel.getTournamentList());
        mModel.addObserver(mView);
        //mGetTournamentListInteractor.execute(mModel.getSport().toString(), mGetTournamentsCallback);
    }

    @Override
    public void onResume() {
        mView.setTournamentsList(mModel.getTournamentList());
        mModel.addObserver(mView);
    }

    @Override
    public void onPause() {
        mModel.deleteObserver(mView);
    }

    @Override
    public void onAddTournamentClicked() {
        mView.showAddTournamentDialog();
        // mAddTournamentInteractor.execute(mModel.getSport(), mModel.getTournamentList().get(position), mAddTournamentCallback);
    }

    @Override
    public void onAddTournamentCreateClicked(String name, String venue, String country, String city,
                                             String address, Date date) {

        Tournament tournament = new Tournament();
        Location location = new Location();
        location.setCity(city);
        location.setCountry(country);

        tournament.setName(name);
        tournament.setVenue(venue);
        tournament.setLocation(location);
        tournament.setDate(date);

        mModel.addTournament(tournament);

    }

    @Override
    public void onRemoveTournamentClicked(int position) {
        // mRemoveTournamentInteractor.execute(mModel.getSport(), mModel.getTournamentList().get(position), mRemoveTournamentCallback);
    }

    @Override
    public void onEditTournamentClicked(int position) {
        // mEditTournamentInteractor.execute(mModel.getSport(), mModel.getTournamentList().get(position), mEditTournamentCallback);
    }

    private GetTournamentListInteractor.Callback mGetTournamentsCallback = new GetTournamentListInteractor.Callback() {

        @Override
        public void onTournamentListLoaded(List<com.example.domain.models.Tournament> tournamentList) {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };

    private AddTournamentInteractor.Callback mAddTournamentCallback = new AddTournamentInteractor.Callback() {
        @Override
        public void onTournamentAdded() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };


    private RemoveTournamentInteractor.Callback mRemoveTournamentCallback = new RemoveTournamentInteractor.Callback() {
        @Override
        public void onTournamentRemoved() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };

    private UpdateTournamentInteractor.Callback mEditTournamentCallback = new UpdateTournamentInteractor.Callback() {
        @Override
        public void onTournamentUpdated() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
}
