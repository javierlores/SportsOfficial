package com.example.domain.interactors;

public class GetLeagueListInteractorImpl implements GetLeagueListInteractor {
   // private final LeagueRepository mLeagueRepository;

    private String mSport;
    private Callback mCallback;

    public GetLeagueListInteractorImpl() {
       // mLeagueRepository = new LeagueRepository();
    }

    @Override
    public void execute(String sport, Callback callback) {
        mSport = sport;
        mCallback = callback;;
    }

    @Override
    public void run() {

    }

    /*
    private LeagueRepository.LeagueListCallback leagueListCallback =
            new LeagueRepository.LeagueListCallback() {
        @Override
        public void onLeaguesListLoaded(List<LeagueEntity> leagueList) {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
    */
}
