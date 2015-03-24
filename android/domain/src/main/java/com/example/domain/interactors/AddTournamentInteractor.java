package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.models.Tournament;

public interface AddTournamentInteractor extends Interactor {
    public interface Callback {
        public void onTournamentAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(Tournament tournament, Callback callback);
}
