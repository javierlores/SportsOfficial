package example.example.com.sportsofficial;

import com.example.domain.interactors.AddLeagueInteractor;
import com.example.domain.interactors.AddLeagueInteractorImpl;
import com.example.domain.interactors.AddLeagueMatchInteractor;
import com.example.domain.interactors.AddLeagueMatchInteractorImpl;
import com.example.domain.interactors.AddMatchInteractor;
import com.example.domain.interactors.AddMatchInteractorImpl;
import com.example.domain.interactors.AddTournamentInteractor;
import com.example.domain.interactors.AddTournamentInteractorImpl;
import com.example.domain.interactors.AddTournamentMatchInteractor;
import com.example.domain.interactors.AddTournamentMatchInteractorImpl;
import com.example.domain.interactors.GetLeagueListInteractor;
import com.example.domain.interactors.GetLeagueListInteractorImpl;
import com.example.domain.interactors.GetLeagueMatchListInteractor;
import com.example.domain.interactors.GetLeagueMatchListInteractorImpl;
import com.example.domain.interactors.GetMatchListInteractor;
import com.example.domain.interactors.GetMatchListInteractorImpl;
import com.example.domain.interactors.GetTournamentListInteractor;
import com.example.domain.interactors.GetTournamentListInteractorImpl;
import com.example.domain.interactors.GetTournamentMatchListInteractor;
import com.example.domain.interactors.GetTournamentMatchListInteractorImpl;
import com.example.domain.interactors.RemoveLeagueInteractor;
import com.example.domain.interactors.RemoveLeagueInteractorImpl;
import com.example.domain.interactors.RemoveMatchInteractor;
import com.example.domain.interactors.RemoveMatchInteractorImpl;
import com.example.domain.interactors.RemoveTournamentInteractor;
import com.example.domain.interactors.RemoveTournamentInteractorImpl;
import com.example.domain.interactors.UpdateLeagueInteractor;
import com.example.domain.interactors.UpdateLeagueInteractorImpl;
import com.example.domain.interactors.UpdateMatchInteractor;
import com.example.domain.interactors.UpdateMatchInteractorImpl;
import com.example.domain.interactors.UpdateTournamentInteractor;
import com.example.domain.interactors.UpdateTournamentInteractorImpl;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true
)
public class InteractorsModule {
    @Provides
    public AddLeagueInteractor provideAddLeagueInteractor() {
        return new AddLeagueInteractorImpl();
    }

    @Provides
    public AddLeagueMatchInteractor provideAddLeagueMatchInteractor() {
        return new AddLeagueMatchInteractorImpl();
    }

    @Provides
    public AddMatchInteractor provideAddMatchInteractor() {
        return new AddMatchInteractorImpl();
    }

    @Provides
    public AddTournamentInteractor provideAddTournamentInteractor() {
        return new AddTournamentInteractorImpl();
    }

    @Provides
    public AddTournamentMatchInteractor provideAddTournamentMatchInteractor() {
        return new AddTournamentMatchInteractorImpl();
    }

    @Provides
    public GetLeagueListInteractor provideGetLeagueListInteractor() {
        return new GetLeagueListInteractorImpl();
    }

    @Provides
    public GetLeagueMatchListInteractor provideGetLeagueMatchListInteractor() {
        return new GetLeagueMatchListInteractorImpl();
    }

    @Provides
    public GetMatchListInteractor provideGetMatchListInteractor() {
        return new GetMatchListInteractorImpl();
    }

    @Provides
    public GetTournamentListInteractor provideGetTournamentListInteractor() {
        return new GetTournamentListInteractorImpl();
    }

    @Provides
    public GetTournamentMatchListInteractor provideGetTournamentMatchListInteractor() {
        return new GetTournamentMatchListInteractorImpl();
    }

    @Provides
    public RemoveLeagueInteractor provideRemoveLeagueInteractor() {
        return new RemoveLeagueInteractorImpl();
    }

    @Provides
    public RemoveMatchInteractor provideRemoveMatchInteractor() {
        return new RemoveMatchInteractorImpl();
    }

    @Provides
    public RemoveTournamentInteractor provideRemoveTournamentInteractor() {
        return new RemoveTournamentInteractorImpl();
    }

    @Provides
    public UpdateLeagueInteractor provideUpdateLeagueInteractor() {
        return new UpdateLeagueInteractorImpl();
    }

    @Provides
    public UpdateMatchInteractor provideUpdateMatchInteractor() {
        return new UpdateMatchInteractorImpl();
    }

    @Provides
    public UpdateTournamentInteractor provideUpdateTournamentInteractor() {
        return new UpdateTournamentInteractorImpl();
    }
}