package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;

public interface RemoveTournamentInteractor extends Interactor {
    public interface Callback {
        public void onTournamentRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(int id, Callback callback);
}
