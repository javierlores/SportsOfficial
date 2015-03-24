package example.example.com.sportsofficial.presenters;

import com.example.domain.interactors.UpdateMatchInteractor;
import com.example.domain.interactors.GetMatchListInteractor;
import com.example.domain.interactors.RemoveMatchInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.example.com.sportsofficial.models.MatchListModel;
import example.example.com.sportsofficial.models.SportModel;
import example.example.com.sportsofficial.views.MatchListView;
import example.example.com.sportsofficial.views.fragments.MatchListFragment;

@Module(
        injects = MatchListFragment.class,
        addsTo = SportModule.class
)
public class MatchListModule {
    private MatchListView mView;

    public MatchListModule(MatchListView view) {
        mView = view;
    }

    @Provides
    @Singleton
    public MatchListView provideView() {
        return mView;
    }

    @Provides @Singleton
    public MatchListModel provideModel(SportModel sportModel) {
        return new MatchListModel(sportModel);
    }

    @Provides @Singleton
    public MatchListPresenter providePresenter(MatchListModel model, MatchListView view,
                                                GetMatchListInteractor getMatchListInteractor,
                                                RemoveMatchInteractor removeMatchInteractor,
                                                UpdateMatchInteractor editMatchInteractor) {
        return new MatchListPresenterImpl(model, view,
                getMatchListInteractor,
                removeMatchInteractor,
                editMatchInteractor);
    }
}

