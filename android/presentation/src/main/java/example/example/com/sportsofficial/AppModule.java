package example.example.com.sportsofficial;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                App.class
        }
)
public class AppModule {
    private App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides @Singleton public Context providesApplicationContext() {
        return mApp;
    }
}
