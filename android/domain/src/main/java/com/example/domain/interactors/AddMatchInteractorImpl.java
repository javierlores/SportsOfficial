package com.example.domain.interactors;

import com.example.domain.models.Match;

public class AddMatchInteractorImpl implements AddMatchInteractor {
  //  private MatchRepository mMatchRepository;

    private int mSportId;
    private Match mMatch;
    private Callback mCallback;

    public AddMatchInteractorImpl() {
    //    mMatchRepository = new MatchRepository();
    }

    @Override
    public void execute(int sportId, Match match, Callback callback) {
        mSportId = sportId;
        mMatch = match;
        mCallback = callback;
    }

    @Override
    public void run() {

    }
/*
    private  MatchRepository.AddMatchCallback addMatchCallback =
            new MatchRepository.AddMatchCallback() {
        @Override
        public void onMatchAdded() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
