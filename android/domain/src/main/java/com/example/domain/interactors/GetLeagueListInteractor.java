package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.models.League;

import java.util.List;

public interface GetLeagueListInteractor extends Interactor {
    public interface Callback {
        public void onLeagueListLoaded(List<League> leagueList);
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(String sport, Callback callback);
}
