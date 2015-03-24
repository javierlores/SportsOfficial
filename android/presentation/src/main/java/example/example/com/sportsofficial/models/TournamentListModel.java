package example.example.com.sportsofficial.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TournamentListModel extends Observable {
    private SportModel mSportModel;
    private List<Tournament> mTournamentList;

    public TournamentListModel(SportModel sportModel) {
        mSportModel = sportModel;
        mTournamentList = new ArrayList<>();
    }

    public Sport getSport() {
        return mSportModel.getSport();
    }

    public List<Tournament> getTournamentList() {
        return mTournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        mTournamentList = tournamentList;
        setChanged();
        notifyObservers();
    }

    public void addTournament(Tournament tournament) {
        mTournamentList.add(tournament);
        setChanged();
        notifyObservers();
    }
}
