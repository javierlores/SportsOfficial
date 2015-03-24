package example.example.com.sportsofficial.presenters;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.example.com.sportsofficial.models.Sport;
import example.example.com.sportsofficial.models.SportModel;
import example.example.com.sportsofficial.views.fragments.SportTabsFragment;

@Module(
        injects = SportTabsFragment.class,
        addsTo = MainModule.class,
        library = true
)
public class SportModule {
    private SportModel mSportModel;

    public SportModule(Sport sport) {
        mSportModel = new SportModel(sport);
    }

    @Provides @Singleton
    public SportModel provideSportModel() {
        return mSportModel;
    }
}
