package example.example.com.sportsofficial.presentation.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.example.com.sportsofficial.domain.interactors.AddMatchInteractor;
import example.example.com.sportsofficial.presentation.App;
import example.example.com.sportsofficial.presentation.models.MainModel;
import example.example.com.sportsofficial.presentation.presenters.MainPresenter;
import example.example.com.sportsofficial.presentation.presenters.MainPresenterImpl;
import example.example.com.sportsofficial.presentation.views.MainView;
import example.example.com.sportsofficial.presentation.views.activities.MainActivity;

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
                                                 AddMatchInteractor addMatchInteractor) {
        return new MainPresenterImpl(app, model, view, addMatchInteractor);
    }
}
