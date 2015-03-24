package example.example.com.sportsofficial.presenters;

public interface MatchListPresenter {
    public void onCreate();
    public void onResume();
    public void onPause();

    public void addMatch(String homeTeam, String awayTeam, String league, String tournament,
                         Integer homeScore, Integer awayScore);
    public void onRemoveMatchClicked(int position);
    public void onEditMatchClicked(int position);
}
