package example.example.com.sportsofficial.presenters;

import example.example.com.sportsofficial.models.Date;

public interface TournamentListPresenter {
    public void onCreate();
    public void onResume();
    public void onPause();

    public void onAddTournamentClicked();
    public void onAddTournamentCreateClicked(String name, String venue, String country, String city,
                                             String address, Date date);
    public void onRemoveTournamentClicked(int position);
    public void onEditTournamentClicked(int position);
}
