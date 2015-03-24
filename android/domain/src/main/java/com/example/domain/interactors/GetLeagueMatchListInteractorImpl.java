package com.example.domain.interactors;


public class GetLeagueMatchListInteractorImpl implements GetLeagueMatchListInteractor {
  //  private MatchRepository mMatchRepository;

    private int mSportId;
    private int mLeagueId;
    private Callback mCallback;

    public GetLeagueMatchListInteractorImpl() {
    //    mMatchRepository = new MatchRepository();
    }


    @Override
    public void execute(int sportId, int leagueId, Callback callback) {
        mSportId = sportId;
        mLeagueId = leagueId;
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
