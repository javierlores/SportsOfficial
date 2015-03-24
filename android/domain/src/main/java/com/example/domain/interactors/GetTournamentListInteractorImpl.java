package com.example.domain.interactors;

public class GetTournamentListInteractorImpl implements GetTournamentListInteractor {
    //private TournamentRepository mTournamentRespository;

    private int mSportId;
    private Callback mCallback;

    public GetTournamentListInteractorImpl() {
        //mTournamentRespository = new TournamentRepository();
    }

    @Override
    public void execute(int sportId, Callback callback) {
        mSportId = sportId;
        mCallback = callback;
    }

    @Override
    public void run() {
    }

    /*
    private TournamentRepository.GetTournamentListCallback getTournamentListCallback =
            new TournamentRepository.GetTournamentListCallback() {
        @Override
        public void onTournamentListLoaded(List<LeagueEntity> tournamentList) {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
