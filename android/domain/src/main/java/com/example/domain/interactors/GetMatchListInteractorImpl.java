package com.example.domain.interactors;


public class GetMatchListInteractorImpl implements GetMatchListInteractor {
//    private MatchRepository mMatchRepository;;

    private int mSportId;
    private Callback mCallback;

    public GetMatchListInteractorImpl() {
      //  mMatchRepository = new MatchRepository();
    }


    @Override
    public void execute(int sportId, Callback callback) {
        mSportId = sportId;
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
