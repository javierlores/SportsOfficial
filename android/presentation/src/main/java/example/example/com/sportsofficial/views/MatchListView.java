package example.example.com.sportsofficial.views;

import java.util.List;
import java.util.Observer;

import example.example.com.sportsofficial.models.Match;

public interface MatchListView extends Observer {
    public void setMatchList(List<Match> matchList);
}
