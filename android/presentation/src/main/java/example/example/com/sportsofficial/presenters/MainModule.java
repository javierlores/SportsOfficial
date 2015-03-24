package example.example.com.sportsofficial.presenters;

import com.example.domain.interactors.AddLeagueMatchInteractor;
import com.example.domain.interactors.AddMatchInteractor;
import com.example.domain.interactors.AddTournamentMatchInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.example.com.sportsofficial.App;
import example.example.com.sportsofficial.AppModule;
import example.example.com.sportsofficial.models.MainModel;
import example.example.com.sportsofficial.views.MainView;
import example.example.com.sportsofficial.views.activities.MainActivity;

@Module(
        injects = MainActivity.class,
        addsTo = AppModule.class
)
public class MainModule {
    private MainView mView;

    public MainModule(MainView view) {
        mView = view;
    }

    @Provides @Singleton
    public MainView provideView() {
        return mView;
    }

    @Provides @Singleton
    public MainModel provideModel() {
        return new MainModel();
    }

    @Provides @Singleton
    public MainPresenter providePresenter(App app, MainModel model, MainView view,
                                                 AddMatchInteractor addMatchInteractor,
                                                 AddTournamentMatchInteractor addTournamentMatchInteractor,
                                                 AddLeagueMatchInteractor addLeagueMatchInteractor) {
        return new MainPresenterImpl(app, model, view, addMatchInteractor,
                addTournamentMatchInteractor, addLeagueMatchInteractor);
    }
}
