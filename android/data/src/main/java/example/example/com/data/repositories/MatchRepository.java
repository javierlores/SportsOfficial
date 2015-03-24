package example.example.com.data.repositories;

import java.util.List;

import example.example.com.data.entities.MatchEntity;
import example.example.com.data.exceptions.ErrorBundle;

public class MatchRepository {
    public interface GetMatchDetailsCallback {
        public void onMatchDetailsLoaded(MatchEntity matchDetails);
        public void onError(ErrorBundle errorBundle);
    }

    public interface GetMatchListCallback {
        public void onMatchListLoaded(List<MatchEntity> matchList);
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

    public void getMatchByID(final String sport, final int matchId, GetMatchDetailsCallback callback) {

    }

    public void getMatchListBySport(final String sport, GetMatchListCallback callback) {

    }

    public void getMatchListByLeague(final String sport, final String league,
                                     GetMatchListCallback callback) {

    }

    public void getMatchListByTournament(final String sport, final String tournament,
                                         GetMatchListCallback callback) {

    }

    public void addMatch(MatchEntity match, AddMatchCallback callback) {

    }

    public void removeMatch(MatchEntity match, RemoveMatchCallback callback) {

    }

    public void editMatch(MatchEntity match, UpdateMatchCallback callback) {

    }
}
