package com.example.domain.interactors;


import com.example.domain.models.Match;

public class AddLeagueMatchInteractorImpl implements AddLeagueMatchInteractor {
  //  private MatchRepository mMatchRepository;

    private int mSportId;
    private int mLeagueId;
    private Match mMatch;
    private Callback mCallback;

    public AddLeagueMatchInteractorImpl() {
       // mMatchRepository = new MatchRepository();
    }

    @Override
    public void execute(int sportId, int leagueId, Match match, Callback callback) {
        mSportId = sportId;
        mLeagueId = leagueId;
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
