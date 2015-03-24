package example.example.com.sportsofficial.presenters;

import com.example.domain.interactors.AddTournamentInteractor;
import com.example.domain.interactors.UpdateTournamentInteractor;
import com.example.domain.interactors.GetTournamentListInteractor;
import com.example.domain.interactors.RemoveTournamentInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.example.com.sportsofficial.models.SportModel;
import example.example.com.sportsofficial.models.TournamentListModel;
import example.example.com.sportsofficial.views.TournamentListView;
import example.example.com.sportsofficial.views.fragments.TournamentListFragment;

@Module(
        injects = TournamentListFragment.class,
        addsTo = SportModule.class
)
public class TournamentListModule {
    private TournamentListView mView;

    public TournamentListModule(TournamentListView view) {
        mView = view;
    }

    @Provides @Singleton
    public TournamentListView provideView() {
        return mView;
    }

    @Provides @Singleton
    public TournamentListModel provideModel(SportModel sportModel) {
        return new TournamentListModel(sportModel);
    }

    @Provides @Singleton
    public TournamentListPresenter providePresenter(TournamentListModel model, TournamentListView view,
                                                 GetTournamentListInteractor getTournamentListInteractor,
                                                 AddTournamentInteractor addTournamentInteractor,
                                                 RemoveTournamentInteractor removeTournamentInteractor,
                                                 UpdateTournamentInteractor editTournamentInteractor) {
        return new TournamentListPresenterImpl(model, view,
                getTournamentListInteractor,
                addTournamentInteractor,
                removeTournamentInteractor,
                editTournamentInteractor);
    }
}
