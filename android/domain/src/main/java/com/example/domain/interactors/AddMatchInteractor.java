package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.models.Match;

public interface AddMatchInteractor extends Interactor {
    public interface Callback {
        public void onMatchAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(int sportId, Match match, Callback callback);
}
