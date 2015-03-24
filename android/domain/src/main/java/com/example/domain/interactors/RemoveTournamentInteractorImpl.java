package com.example.domain.interactors;

public class RemoveTournamentInteractorImpl implements RemoveTournamentInteractor {
   // private final TournamentRepository mTournamentRepository;

    private int mId;
    private RemoveTournamentInteractor.Callback mCallback;

    public RemoveTournamentInteractorImpl() {
     //   mTournamentRepository = new TournamentRepository();
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
    private TournamentRepository.RemoveTournamentCallback removeTournamentCallback =
            new TournamentRepository.RemoveTournamentCallback() {
        @Override
        public void onTournamentRemoved() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
