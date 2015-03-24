package example.example.com.sportsofficial.views;


import java.util.List;
import java.util.Observer;

import example.example.com.sportsofficial.models.League;

public interface LeagueListView extends Observer {
    public void showAddLeagueDialog();
    public void setLeagueList(List<League> leagueList);
}
