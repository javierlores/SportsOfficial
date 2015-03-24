package com.example.domain.interactors;


import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.models.Match;

public interface UpdateMatchInteractor extends Interactor {
    public interface Callback {
        public void onMatchUpdated();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(Match match, Callback callback);
}
