package example.example.com.data.entities;


import java.util.ArrayList;
import java.util.List;

public class LeagueEntity {
    private SportEntity mSport;
    private int mLeagueId;
    private String mName;
    private Location mLocation;
    private List<MatchEntity> mMatchList;

    public LeagueEntity() {
        mMatchList = new ArrayList<>();
    }

    public SportEntity getSport() {
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

    public List<MatchEntity> getMatchList() {
        return mMatchList;
    }

    public void setSport(SportEntity sport) {
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

    public void setMatchList(List<MatchEntity> matchList) {
        mMatchList = matchList;
    }
}
