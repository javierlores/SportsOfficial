package example.example.com.sportsofficial;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = App.class,
        includes = InteractorsModule.class
)
public class AppModule {
    private App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides @Singleton
    public App provideApplication() {
        return mApp;
    }
}
