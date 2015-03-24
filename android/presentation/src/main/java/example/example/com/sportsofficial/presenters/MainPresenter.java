package example.example.com.sportsofficial.presenters;

import example.example.com.sportsofficial.views.Navigator;

public interface MainPresenter {
    public void onCreate();
    public void onNavigationItemClicked(Navigator.NavItemType navItem, String sportTitle);
    public void onSyncClicked();
    public void onAddMatchDialogPositiveClicked(String homeTeam, String awayTeam, String tournament,
                                                String league);
    public void onAddSportClicked();
    public void onAddSportDialogPositiveClicked(String name);
    public void onRemoveSportClicked();
    public void onRemoveSportDialogPositiveClicked();
}
