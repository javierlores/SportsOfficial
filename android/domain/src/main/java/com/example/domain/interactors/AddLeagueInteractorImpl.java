package com.example.domain.interactors;

import com.example.domain.models.League;

public class AddLeagueInteractorImpl implements AddLeagueInteractor {
    //private LeagueRepository mLeagueRepository;

    private League mLeague;
    private Callback mCallback;

    public AddLeagueInteractorImpl() {
        //mLeagueRepository = new LeagueRepository();
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
    private LeagueRepository.AddLeagueCallback addLeagueCallback =
            new LeagueRepository.AddLeagueCallback() {
        @Override
        public void onLeagueAdded() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
