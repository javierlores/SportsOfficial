package example.example.com.data.repositories;

import java.util.List;

import example.example.com.data.entities.LeagueEntity;
import example.example.com.data.exceptions.ErrorBundle;

public class LeagueRepository {
    public interface LeagueListCallback {
        public void onLeaguesListLoaded(List<LeagueEntity> leagueList);
        public void onError(ErrorBundle errorBundle);
    }

    public interface AddLeagueCallback {
        public void onLeagueAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public interface RemoveLeagueCallback {
        public void onLeagueRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public interface UpdateLeagueCallback {
        public void onLeagueUpdate();
        public void onError(ErrorBundle errorBundle);
    }

    public void getLeagueListBySport(String sport, LeagueListCallback callback) {

    }

    public void addLeague(LeagueEntity league, AddLeagueCallback callback) {

    }

    public void removeLeague(int id, RemoveLeagueCallback callback) {

    }

    public void editLeague(LeagueEntity league, UpdateLeagueCallback callback) {

    }
}
