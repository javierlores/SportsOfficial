package example.example.com.sportsofficial.models;

import java.util.ArrayList;
import java.util.List;

public class League {
    private Sport mSport;
    private int mLeagueId;
    private String mName;
    private Location mLocation;
    private List<Match> mMatchList;

    public League() {
        mMatchList = new ArrayList<>();
    }

    public Sport getSport() {
        return mSport;
    }

    public int getLeagueId() {
        return mLeagueId;
    }

    public String getName() {
        return mName;
    }

    public Location getLocation() {
        return mLocation;
    }

    public List<Match> getMatchList() {
        return mMatchList;
    }

    public void setSport(Sport sport) {
        mSport = sport;
    }

    public void setLeagueId(int leagueId) {
        mLeagueId = leagueId;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public void setMatchList(List<Match> matchList) {
        mMatchList = matchList;
    }
}
