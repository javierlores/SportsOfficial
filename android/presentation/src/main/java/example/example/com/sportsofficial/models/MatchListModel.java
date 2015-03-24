package example.example.com.sportsofficial.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MatchListModel extends Observable {
    private SportModel mSportModel;
    private List<Match> mMatchList;

    public MatchListModel(SportModel model) {
        mSportModel = model;
        mMatchList = new ArrayList<>();
    }

    public Sport getSport() {
        return mSportModel.getSport();
    }

    public List<Match> getMatchList() {
        return mMatchList;
    }

    public void setMatchList(List<Match> matchList) {
        mMatchList = matchList;
        setChanged();
        notifyObservers(matchList);
    }

    public void addMatch(Match match) {
        mMatchList.add(match);
        setChanged();
        notifyObservers();
    }
}
