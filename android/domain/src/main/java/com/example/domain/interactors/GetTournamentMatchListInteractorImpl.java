package com.example.domain.interactors;


public class GetTournamentMatchListInteractorImpl implements GetTournamentMatchListInteractor {
   // private MatchRepository mMatchRepository;;

    private int mSportId;
    private int mTournamentId;
    private Callback mCallback;

    public GetTournamentMatchListInteractorImpl() {
      //  mMatchRepository = new MatchRepository();
    }


    @Override
    public void execute(int sportId, int tournamentId, Callback callback) {
        mSportId = sportId;
        mTournamentId = tournamentId;
        mCallback = callback;
    }

    @Override
    public void run() {

    }

    /*
    private MatchRepository.GetMatchListCallback getMatchListCallback =
            new MatchRepository.GetMatchListCallback() {
        @Override
        public void onMatchListLoaded(List<MatchEntity> matchList) {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
