package com.example.domain.interactors;

import com.example.domain.models.Tournament;

public class AddTournamentInteractorImpl implements AddTournamentInteractor {
    //private TournamentRepository mTournamentRepository;

    private Tournament mTournament;
    private Callback mCallback;

    public AddTournamentInteractorImpl() {
       // mTournamentRepository = new TournamentRepository();
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
    private TournamentRepository.AddTournamentCallback addTournamentCallback =
            new TournamentRepository.AddTournamentCallback() {
        @Override
        public void onTournamentAdded() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
*/
}
