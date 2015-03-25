package example.example.com.sportsofficial.presentation.models;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    private List<Sport> mSports;

    public MainModel() {
        mSports = new ArrayList<>();
    }

    public Sport getSport(String sportTitle) {
        for(Sport sport : mSports) {
            if (sport.getName().equals(sportTitle)) {
                return sport;
            }
        }
        return null;
    }

    public List<Sport> getSports() {
        return mSports;
    }

    public List<String> getSportsTitles() {
        List<String> sportsTitles = new ArrayList<>();

        for (Sport sport : mSports) {
            sportsTitles.add(sport.getName());
        }

        return sportsTitles;
    }

    public void addSport(Sport sport) {
        mSports.add(sport);
    }

    public void removeSport(String sportTitle) {
        for(Sport sport : mSports) {
            if (sport.getName().equals(sportTitle)) {
                mSports.remove(sport);
            }
        }
    }
}
