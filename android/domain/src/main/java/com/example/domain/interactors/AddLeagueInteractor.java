package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.models.League;

public interface AddLeagueInteractor extends Interactor {
    public interface Callback {
        public void onLeagueAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(League league, Callback callback);
}
