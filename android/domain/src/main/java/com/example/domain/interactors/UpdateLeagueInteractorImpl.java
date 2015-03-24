package com.example.domain.interactors;

import com.example.domain.models.League;

public class UpdateLeagueInteractorImpl implements UpdateLeagueInteractor {
    //private LeagueRepository mLeagueRepository;

    private League mLeague;
    private Callback mCallback;

    public UpdateLeagueInteractorImpl() {
   //     mLeagueRepository = new LeagueRepository();
    }

    @Override
    public void execute(League league, Callback callback) {
        mLeague = league;
        mCallback = callback;
    }

    @Override
    public void run() {

    }

    /*
    private LeagueRepository.UpdateLeagueCallback updateLeagueCallback = new LeagueRepository.UpdateLeagueCallback() {
        @Override
        public void onLeagueUpdate() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
