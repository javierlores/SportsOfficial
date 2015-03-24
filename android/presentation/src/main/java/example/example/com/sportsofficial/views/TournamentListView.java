package example.example.com.sportsofficial.views;

import java.util.List;
import java.util.Observer;

import example.example.com.sportsofficial.models.Tournament;

public interface TournamentListView extends Observer {
    public void showAddTournamentDialog();
    public void setTournamentsList(List<Tournament> tournamentsList);
}
