package com.example.domain.interactors;


import com.example.domain.models.Match;

public class AddTournamentMatchInteractorImpl implements AddTournamentMatchInteractor {
    //private MatchRepository mMatchRepository;

    private int mSportId;
    private int mTournamentId;
    private Match mMatch;
    private Callback mCallback;

    public AddTournamentMatchInteractorImpl() {
      //  mMatchRepository = new MatchRepository();
    }

    @Override
    public void execute(int sportId, int tournamentId, Match match, Callback callback) {
        mSportId = sportId;
        mTournamentId = tournamentId;
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