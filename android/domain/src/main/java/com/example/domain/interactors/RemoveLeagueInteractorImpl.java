package com.example.domain.interactors;

public class RemoveLeagueInteractorImpl implements RemoveLeagueInteractor {
   // private LeagueRepository mLeagueRepository;

    private int mId;
    private Callback mCallback;

    public RemoveLeagueInteractorImpl() {
    //    mLeagueRepository = new LeagueRepository();
    }

    @Override
    public void execute(int id, Callback callback) {
        mId = id;
        mCallback = callback;
    }

    @Override
    public void run() {

    }

    /*
    private LeagueRepository.RemoveLeagueCallback removeLeagueCallback =
            new LeagueRepository.RemoveLeagueCallback() {
        @Override
        public void onLeagueRemoved() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
