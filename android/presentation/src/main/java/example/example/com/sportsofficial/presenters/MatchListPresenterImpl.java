package example.example.com.sportsofficial.presenters;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.interactors.AddMatchInteractor;
import com.example.domain.interactors.GetMatchListInteractor;
import com.example.domain.interactors.RemoveMatchInteractor;
import com.example.domain.interactors.UpdateMatchInteractor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import example.example.com.sportsofficial.models.Date;
import example.example.com.sportsofficial.models.Match;
import example.example.com.sportsofficial.models.MatchListModel;
import example.example.com.sportsofficial.models.Time;
import example.example.com.sportsofficial.models.Tournament;
import example.example.com.sportsofficial.views.MatchListView;

public class MatchListPresenterImpl implements MatchListPresenter {
    private MatchListModel mModel;
    private MatchListView mView;
    private GetMatchListInteractor mGetMatchesInteractor;
    private UpdateMatchInteractor mUpdateMatchInteractor;
    private RemoveMatchInteractor mRemoveMatchInteractor;

    public MatchListPresenterImpl(MatchListModel model, MatchListView view,
                                  GetMatchListInteractor getMatchesInteractor,
                                  RemoveMatchInteractor removeMatchInteractor,
                                  UpdateMatchInteractor updateMatchInteractor) {
        mModel = model;
        mView = view;
        mGetMatchesInteractor = getMatchesInteractor;
        mUpdateMatchInteractor = updateMatchInteractor;
        mRemoveMatchInteractor = removeMatchInteractor;
    }

    @Override
    public void onCreate() {
        List<Tournament> tournamentList = new ArrayList<>();
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
    public void addMatch(String homeTeam, String awayTeam, String league, String tournament,
                         Integer homeScore, Integer awayScore) {
        Match match = new Match();

        match.setHomeTeamName(homeTeam);
        match.setAwayTeamName(awayTeam);
        match.setAwayTeamScore(awayScore.intValue());
        match.setHomeTeamScore(homeScore.intValue());

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        Date date = new Date(year, month, day);
        Time time = new Time();

        time.setHour(hour);
        time.setMinute(minute);

        match.setDate(date);
        match.setTime(time);

        mModel.addMatch(match);
    }

    @Override
    public void onRemoveMatchClicked(int position) {
        // mRemoveMatchInteractor.execute(mModel.getSport(), mModel.getMatchList().get(position), mRemoveMatchCallback);
    }

    @Override
    public void onEditMatchClicked(int position) {
        // mEditMatchInteractor.execute(mModel.getSport(), mModel.getMatchList().get(position), mEditMatchCallback);
    }


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

    private UpdateMatchInteractor.Callback mEditMatchCallback = new UpdateMatchInteractor.Callback() {
        @Override
        public void onMatchUpdated() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
}
