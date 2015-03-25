package example.example.com.sportsofficial.data.repositories;


import java.util.List;

import example.example.com.sportsofficial.domain.exceptions.ErrorBundle;
import example.example.com.sportsofficial.presentation.models.Match;

public class MatchRepository {
    public interface GetMatchCallback {
        public void onMatchLoaded(Match match);
        public void onError(ErrorBundle errorBundle);
    }

    public interface GetMatchListCallback {
        public void onMatchListLoaded(List<Match> matchList);
        public void onError(ErrorBundle errorBundle);
    }

    public interface AddMatchCallback {
        public void onMatchAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public interface RemoveMatchCallback {
        public void onMatchRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public interface UpdateMatchCallback {
        public void onMatchUpdated();
        public void onError(ErrorBundle errorBundle);
    }

    public void getMatchByID(final int matchId, GetMatchCallback callback){

    }
    public void getMatchListBySportId(final int sportId, GetMatchListCallback callback){

    }
    public void getMatchListByLeagueId(final int leagueId, GetMatchListCallback callback){

    }
    public void getMatchListByTournamentID(final int tournamentId, GetMatchListCallback callback){

    }
    public void addMatch(Match match, AddMatchCallback callback){

    }
    public void removeMatch(final int matchId, RemoveMatchCallback callback){

    }
    public void updateMatch(Match match, UpdateMatchCallback callback) {

    }
}
