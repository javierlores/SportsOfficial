package example.example.com.sportsofficial.domain.interactors;


import example.example.com.sportsofficial.domain.exceptions.ErrorBundle;
import example.example.com.sportsofficial.presentation.models.Sport;

public interface AddSportInteractor extends Interactor {
    public interface Callback {
        public void onSportAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(Sport sport, Callback callback);
}
