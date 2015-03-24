package example.example.com.data.repositories;

import java.util.List;

import example.example.com.data.entities.LeagueEntity;
import example.example.com.data.entities.TournamentEntity;
import example.example.com.data.exceptions.ErrorBundle;

public class TournamentRepository {
    public interface GetTournamentListCallback {
        public void onTournamentListLoaded(List<LeagueEntity> tournamentList);
        public void onError(ErrorBundle errorBundle);
    }

    public interface AddTournamentCallback {
        public void onTournamentAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public interface RemoveTournamentCallback {
        public void onTournamentRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public interface UpdateTournamentCallback {
        public void onTournamentUpdated();
        public void onError(ErrorBundle errorBundle);
    }

    public void getTournamentListBySport(String sport, GetTournamentListCallback callback) {


    }

    public void addTournament(TournamentEntity tournament, AddTournamentCallback callback) {

    }

    public void removeTournament(int id, RemoveTournamentCallback callback) {

    }

    public void editTournament(TournamentEntity tournament, UpdateTournamentCallback callback) {

    }
}
