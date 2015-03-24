package example.example.com.data.entities;


import java.util.ArrayList;
import java.util.List;

public class TournamentEntity {
    private List<MatchEntity> mMatchList;

    public TournamentEntity() {
        mMatchList = new ArrayList<>();
    }

    public List<MatchEntity> getMatchList() {
        return mMatchList;
    }

    public void setMatchList(List<MatchEntity> matchList) {
        mMatchList = matchList;
    }
}
