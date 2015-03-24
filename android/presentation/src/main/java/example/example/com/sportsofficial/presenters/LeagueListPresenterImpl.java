package example.example.com.sportsofficial.presenters;


import android.util.Log;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.interactors.AddLeagueInteractor;
import com.example.domain.interactors.GetLeagueListInteractor;
import com.example.domain.interactors.RemoveLeagueInteractor;
import com.example.domain.interactors.UpdateLeagueInteractor;

import java.util.List;

import example.example.com.sportsofficial.models.League;
import example.example.com.sportsofficial.models.LeagueListModel;
import example.example.com.sportsofficial.models.Location;
import example.example.com.sportsofficial.views.LeagueListView;

public class LeagueListPresenterImpl implements LeagueListPresenter {
    private LeagueListModel mModel;
    private LeagueListView mView;

    private GetLeagueListInteractor mGetLeagueListInteractor;
    private AddLeagueInteractor mAddLeagueInteractor;
    private RemoveLeagueInteractor mRemoveLeagueInteractor;
    private UpdateLeagueInteractor mUpdateLeagueInteractor;

    public LeagueListPresenterImpl(LeagueListModel model, LeagueListView view,
                                   GetLeagueListInteractor getLeagueListInteractor,
                                   AddLeagueInteractor addLeagueInteractor,
                                   RemoveLeagueInteractor removeLeagueInteractor,
                                   UpdateLeagueInteractor updateLeagueInteractor) {
        mModel = model;
        mView = view;
        mGetLeagueListInteractor = getLeagueListInteractor;
        mAddLeagueInteractor = addLeagueInteractor;
        mRemoveLeagueInteractor = removeLeagueInteractor;
        mUpdateLeagueInteractor = updateLeagueInteractor;
    }

    @Override
    public void onCreate() {
        mView.setLeagueList(mModel.getLeagueList());
        mModel.addObserver(mView);

       // mGetLeagueListInteractor.execute(mModel.getSport().toString(), mGetLeagueListCallback);
    }

    @Override
    public void onResume() {
        mView.setLeagueList(mModel.getLeagueList());
        mModel.addObserver(mView);
    }

    @Override
    public void onPause() {
        mModel.deleteObserver(mView);
    }

    @Override
    public void onAddLeagueClicked() {
        mView.showAddLeagueDialog();
        // mAddLeagueInteractor.execute(mModel.getSport(), mModel.getLeagueList().get(position), mAddLeagueCallback);
    }

    @Override
    public void onAddLeagueCreateClicked(String name, String country, String city, String address) {
        League league = new League();
        Location location = new Location();

        league.setName(name);
        location.setCountry(country);
        location.setCity(city);

        league.setLocation(location);

        Log.i("TAG", "adding league");

        mModel.addLeague(league);
    }

    @Override
    public void onRemoveLeagueClicked(int position) {
        mModel.removeLeague(position);
        // mRemoveLeagueInteractor.execute(mModel.getSport(), mModel.getLeagueList().get(position), mRemoveLeagueCallback);
    }

    @Override
    public void onEditLeagueClicked(int position) {
        // mEditLeagueInteractor.execute(mModel.getSport(), mModel.getLeagueList().get(position), mEditLeagueCallback);
    }

    private GetLeagueListInteractor.Callback mGetLeagueListCallback = new GetLeagueListInteractor.Callback() {
        @Override
        public void onLeagueListLoaded(List<com.example.domain.models.League> leagueList) {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };

    private AddLeagueInteractor.Callback mAddLeagueCallback = new AddLeagueInteractor.Callback() {
        @Override
        public void onLeagueAdded() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };


    private RemoveLeagueInteractor.Callback mRemoveLeagueCallback = new RemoveLeagueInteractor.Callback() {
        @Override
        public void onLeagueRemoved() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };

    private UpdateLeagueInteractor.Callback mEditLeagueCallback = new UpdateLeagueInteractor.Callback() {
        @Override
        public void onLeagueUpdated() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
}
