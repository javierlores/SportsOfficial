package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.models.Match;

public interface AddLeagueMatchInteractor extends Interactor {
    public interface Callback {
        public void onMatchAdded();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(int sportId, int leagueId, Match match, Callback callback);
}

