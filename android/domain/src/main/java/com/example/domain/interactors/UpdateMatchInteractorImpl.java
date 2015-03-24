package com.example.domain.interactors;


import com.example.domain.models.Match;

public class UpdateMatchInteractorImpl implements UpdateMatchInteractor {
   // private MatchRepository mMatchRepository;

    private Match mMatch;
    private UpdateMatchInteractor.Callback mCallback;

    public UpdateMatchInteractorImpl() {
  //      mMatchRepository = new MatchRepository();
    }

    @Override
    public void execute(Match match, UpdateMatchInteractor.Callback callback) {
        mMatch = match;
        mCallback = callback;;
    }


    @Override
    public void run() {

    }

    /*
    private MatchRepository.UpdateMatchCallback updateMatchCallback =
            new MatchRepository.UpdateMatchCallback() {
        @Override
        public void onMatchUpdated() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
