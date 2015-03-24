package example.example.com.sportsofficial.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import example.example.com.sportsofficial.models.League;
import example.example.com.sportsofficial.models.Match;

public class LeagueMapper implements Mapper<League, com.example.domain.models.League> {
    @Override
    public League transform(com.example.domain.models.League from) {
        League league = new League();
        MatchMapper mapper = new MatchMapper();

        Collection<Match> matchList = mapper.transform(from.getMatchList());
        league.setMatchList(new ArrayList<>(matchList));

        return league;
    }

    @Override
    public Collection<League> transform(Collection<com.example.domain.models.League> collection) {
        Collection<League> leagueList;

        if (collection != null && !collection.isEmpty()) {
            leagueList = new ArrayList<League>();
            for (com.example.domain.models.League league : collection) {
                leagueList.add(transform(league));
            }
        } else {
            leagueList= Collections.emptyList();
        }

        return leagueList;
    }
}
