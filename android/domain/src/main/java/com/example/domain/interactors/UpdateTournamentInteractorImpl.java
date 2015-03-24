package com.example.domain.interactors;

import com.example.domain.models.Tournament;

public class UpdateTournamentInteractorImpl implements UpdateTournamentInteractor {
   // private TournamentRepository mTournamentRepository;

    private Tournament mTournament;
    private Callback mCallback;

    public UpdateTournamentInteractorImpl() {
      //  mTournamentRepository = new TournamentRepository();
    }

    @Override
    public void execute(Tournament tournament, Callback callback) {
        mTournament = tournament;
        mCallback = callback;
    }

    @Override
    public void run() {

    }

    /*
    private TournamentRepository.UpdateTournamentCallback updateTournamentCallback =
            new TournamentRepository.UpdateTournamentCallback() {
        @Override
        public void onTournamentUpdated() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
