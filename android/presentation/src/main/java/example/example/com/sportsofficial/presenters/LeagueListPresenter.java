package example.example.com.sportsofficial.presenters;


public interface LeagueListPresenter {
    public void onCreate();
    public void onResume();
    public void onPause();

    public void onAddLeagueClicked();
    public void onAddLeagueCreateClicked(String name, String country, String city, String address);
    public void onRemoveLeagueClicked(int position);
    public void onEditLeagueClicked(int position);
}
