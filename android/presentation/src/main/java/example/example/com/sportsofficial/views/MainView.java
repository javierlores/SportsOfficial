package example.example.com.sportsofficial.views;

import example.example.com.sportsofficial.models.Sport;

public interface MainView {
    public void setActionBarTitle(String title);
    public void navigateToHome();
    public void navigateToSportView(Sport sport);
    public void navigateToSettings();
    public void navigateToAbout();
    public void navigateToHelp();
    public void showAddMatchDialog();
    public void showAddSportDialog();
    public void showRemoveSportDialog();
    public void addSportNav(Sport sport);
    public void removeSportNav(Sport sport);
}
