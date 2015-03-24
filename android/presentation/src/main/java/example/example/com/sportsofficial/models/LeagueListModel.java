package example.example.com.sportsofficial.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class LeagueListModel extends Observable {
    private SportModel mSportModel;
    private List<League> mLeagueList;

    public LeagueListModel(SportModel sportModel) {
        mSportModel = sportModel;
        mLeagueList = new ArrayList<>();
    }

    public Sport getSport() {
        return mSportModel.getSport();
    }

    public List<League> getLeagueList() {
        return mLeagueList;
    }

    public void addLeague(League league) {
        mLeagueList.add(league);
        setChanged();
        notifyObservers();
    }

    public void removeLeague(int position) {
        mLeagueList.remove(position);
        setChanged();
        notifyObservers();
    }

    public void setLeagueList(List<League> leagueList) {
        mLeagueList = leagueList;
        setChanged();
        notifyObservers(leagueList);
    }

}
