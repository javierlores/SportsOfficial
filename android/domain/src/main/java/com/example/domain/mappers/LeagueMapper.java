package com.example.domain.mappers;


import com.example.domain.models.League;

import java.util.Collection;

public class LeagueMapper implements Mapper<League, String> {

    @Override
    public League transform(String from) {
        return null;
    }

    @Override
    public Collection<League> transform(Collection<String> collection) {
        return null;
    }
}

/*
public class LeagueMapper implements Mapper<League, example.example.com.data.entities.LeagueEntity> {
    @Override
    public League transform(example.example.com.data.entities.LeagueEntity from) {
        League league = new League();
        MatchMapper mapper = new MatchMapper();

        Collection<Match> matchList = mapper.transform(from.getMatchList());
        league.setMatchList(new ArrayList<>(matchList));

        return league;
    }

    @Override
    public Collection<League> transform(Collection<example.example.com.data.entities.LeagueEntity> collection) {
        Collection<League> leagueList;

        if (collection != null && !collection.isEmpty()) {
            leagueList = new ArrayList<League>();
            for (example.example.com.data.entities.LeagueEntity league : collection) {
                leagueList.add(transform(league));
            }
        } else {
            leagueList = Collections.emptyList();
        }

        return leagueList;
    }
}
*/