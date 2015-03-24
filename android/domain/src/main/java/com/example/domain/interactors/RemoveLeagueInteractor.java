package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;

public interface RemoveLeagueInteractor extends Interactor {
    public interface Callback {
        public void onLeagueRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(int id, Callback callback);
}
