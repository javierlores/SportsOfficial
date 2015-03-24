package example.example.com.sportsofficial.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainModel extends Observable {
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

    public void addSport(Sport sport) {
        mSports.add(sport);
    }

    public void removeSport(Sport sport) {
        mSports.remove(sport);
    }
}
