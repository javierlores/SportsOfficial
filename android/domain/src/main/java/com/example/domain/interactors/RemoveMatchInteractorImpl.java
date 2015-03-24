package com.example.domain.interactors;


public class RemoveMatchInteractorImpl implements RemoveMatchInteractor {
  //  private MatchRepository mMatchRepository;

    private Callback mCallback;
    private int mId;

    public RemoveMatchInteractorImpl() {
   //     mMatchRepository = new MatchRepository();
    }

    @Override
    public void execute(int id, RemoveMatchInteractor.Callback callback) {
        mCallback = callback;
        mId = id;
    }

    @Override
    public void run() {

    }

    /*
    private MatchRepository.RemoveMatchCallback removeMatchCallback =
            new MatchRepository.RemoveMatchCallback() {
        @Override
        public void onMatchRemoved() {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
