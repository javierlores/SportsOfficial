package example.example.com.sportsofficial.presentation.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MatchListModel extends Observable {
    private Sport mSport;
    private List<Match> mMatchList;

    public MatchListModel() {
        mMatchList = new ArrayList<>();
    }

    public Sport getSport() {
        return mSport;
    }

    public List<Match> getMatchList() {
        return mMatchList;
    }

    public void setSport(Sport sport) {
        mSport = sport;
    }

    public void addMatch(Match match) {
        mMatchList.add(match);
        setChanged();
        notifyObservers();
    }

    public void removeMatch(int matchId) {
        for (Match match : mMatchList) {
            if (match.getMatchId() == matchId) {
                mMatchList.remove(match);
            }
        }
        setChanged();
        notifyObservers();
    }
}
