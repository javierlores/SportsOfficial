package com.example.domain.interactors;


import com.example.domain.exceptions.ErrorBundle;

public interface RemoveMatchInteractor extends Interactor {
    public interface Callback {
        public void onMatchRemoved();
        public void onError(ErrorBundle errorBundle);
    }

    public void execute(int id, Callback callback);
}
