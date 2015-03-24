package example.example.com.sportsofficial.presenters;

import com.example.domain.interactors.AddLeagueInteractor;
import com.example.domain.interactors.UpdateLeagueInteractor;
import com.example.domain.interactors.GetLeagueListInteractor;
import com.example.domain.interactors.RemoveLeagueInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.example.com.sportsofficial.models.LeagueListModel;
import example.example.com.sportsofficial.models.SportModel;
import example.example.com.sportsofficial.views.LeagueListView;
import example.example.com.sportsofficial.views.fragments.LeagueListFragment;

@Module(
        injects = LeagueListFragment.class,
        addsTo = SportModule.class
)
public class LeagueListModule {
    private LeagueListView mView;

    public LeagueListModule(LeagueListView view) {
        mView = view;
    }

    @Provides @Singleton
    public LeagueListView provideView() {
        return mView;
    }

    @Provides @Singleton
    public LeagueListModel provideModel(SportModel sportModel) {
        return new LeagueListModel(sportModel);
    }

    @Provides @Singleton
    public LeagueListPresenter providePresenter(LeagueListModel model, LeagueListView view,
                                             GetLeagueListInteractor getLeaguesInteractor,
                                             AddLeagueInteractor addLeagueInteractor,
                                             RemoveLeagueInteractor removeLeagueInteractor,
                                             UpdateLeagueInteractor updateLeagueInteractor) {
        return new LeagueListPresenterImpl(model, view,
                getLeaguesInteractor,
                addLeagueInteractor,
                removeLeagueInteractor,
                updateLeagueInteractor);
    }
}
