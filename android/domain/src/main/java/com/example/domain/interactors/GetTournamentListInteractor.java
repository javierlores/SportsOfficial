package com.example.domain.interactors;

import com.example.domain.exceptions.ErrorBundle;
import com.example.domain.models.Tournament;

import java.util.List;

public interface GetTournamentListInteractor extends Interactor {
    public interface Callback {
        public void onTournamentListLoaded(List<Tournament> tournamentList);
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(int id, Callback callback);
}
