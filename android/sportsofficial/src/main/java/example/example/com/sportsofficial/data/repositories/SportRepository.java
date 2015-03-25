package example.example.com.sportsofficial.data.repositories;


import java.util.List;

import example.example.com.sportsofficial.domain.exceptions.ErrorBundle;
import example.example.com.sportsofficial.presentation.models.Sport;

public class SportRepository {
    public interface  GetSportListCallback {
        public void onSportListLoaded(List <Sport> sportList);
        public void onError(ErrorBundle errorBundle);
    }

    public interface GetSportCallback {
        public void onSportLoaded(Sport sport);
        public void onError(ErrorBundle errorBundle);
    }

    public interface AddSportCallback {
        public void onSportAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public interface RemoveSportCallback {
        public void onSportRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public interface UpdateSportCallback {
        public void onSportUpdated();
        public void onError(ErrorBundle errorBundle);
    }

    public void getSportList(GetSportListCallback callback) {

    }

    public void getSportById(final int sportId, GetSportCallback callback) {

    }

    public void addSport(Sport sport, AddSportCallback callback) {

    }

    public void removeSport(final int sportId, RemoveSportCallback callback) {

    }

    public void updateSport(Sport sport, UpdateSportCallback callback) {

    }
}
