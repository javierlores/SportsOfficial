package example.example.com.sportsofficial.presentation.presenters;

import java.util.List;

import example.example.com.sportsofficial.domain.exceptions.ErrorBundle;
import example.example.com.sportsofficial.domain.interactors.AddMatchInteractor;
import example.example.com.sportsofficial.domain.interactors.GetMatchListInteractor;
import example.example.com.sportsofficial.domain.interactors.RemoveMatchInteractor;
import example.example.com.sportsofficial.presentation.models.Match;
import example.example.com.sportsofficial.presentation.models.MatchListModel;
import example.example.com.sportsofficial.presentation.views.MatchListView;

public class MatchListPresenterImpl implements MatchListPresenter {
    private MatchListModel mModel;
    private MatchListView mView;

    private GetMatchListInteractor mGetMatchListInteractor;
    private RemoveMatchInteractor mRemoveMatchInteractor;

    public MatchListPresenterImpl(MatchListModel model, MatchListView view,
                                  GetMatchListInteractor getMatchListInteractor,
                                  RemoveMatchInteractor removeMatchInteractor) {
        mModel = model;
        mView = view;

        mGetMatchListInteractor = getMatchListInteractor;
        mRemoveMatchInteractor = removeMatchInteractor;
    }

    @Override
    public void setSportId(final int sportId) {
        mGetMatchListInteractor.executeSport(sportId, mGetMatchListCallback);
    }

    @Override
    public void setLeagueId(final int leagueId) {
        mGetMatchListInteractor.executeLeague(leagueId, mGetMatchListCallback);
    }

    @Override
    public void setTournamentId(final int tournamentId) {
        mGetMatchListInteractor.executeTournament(tournamentId, mGetMatchListCallback);
    }

    @Override
    public void onCreateView() {
        mView.setMatchList(mModel.getMatchList());
        mModel.addObserver(mView);
    }

    @Override
    public void onResume() {
        mView.setMatchList(mModel.getMatchList());
        mModel.addObserver(mView);
    }

    @Override
    public void onPause() {
        mModel.deleteObserver(mView);
    }

    @Override
    public void onMatchClicked(int position) {
        mView.showMatchDetails(mModel.getMatchList().get(position).getMatchId());
    }

    @Override
    public void onRemoveMatchClicked(final int position) {
        mRemoveMatchInteractor.execute(mModel.getMatchList().get(position).getMatchId(), mRemoveMatchCallback);
    }

    private GetMatchListInteractor.Callback mGetMatchListCallback = new GetMatchListInteractor.Callback() {
        @Override
        public void onMatchListLoaded(List<Match> matchList) {
            //mView.setMatchList(matchList);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };

    private AddMatchInteractor.Callback mAddMatchCallback = new AddMatchInteractor.Callback() {
        @Override
        public void onMatchAdded() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };


    private RemoveMatchInteractor.Callback mRemoveMatchCallback = new RemoveMatchInteractor.Callback() {
        @Override
        public void onMatchRemoved() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
}
