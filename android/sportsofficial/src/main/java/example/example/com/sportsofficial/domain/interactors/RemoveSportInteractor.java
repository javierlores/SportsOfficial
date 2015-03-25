package example.example.com.sportsofficial.domain.interactors;


import example.example.com.sportsofficial.domain.exceptions.ErrorBundle;

public interface RemoveSportInteractor extends Interactor {
    public interface Callback {
        public void onSportRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(int sportId, Callback callback);
}
