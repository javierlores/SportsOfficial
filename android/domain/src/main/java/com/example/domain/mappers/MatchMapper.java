package com.example.domain.mappers;


import com.example.domain.models.Match;

import java.util.Collection;

public class MatchMapper implements Mapper<Match, String> {
    @Override
    public Match transform(String from) {
        return null;
    }

    @Override
    public Collection<Match> transform(Collection<String> collection) {
        return null;
    }
}

/*
public class MatchMapper implements Mapper<Match, example.example.com.data.entities.MatchEntity> {
    @Override
    public Match transform(example.example.com.data.entities.MatchEntity from) {
        return null;
    }

    @Override
    public Collection<Match> transform(Collection<example.example.com.data.entities.MatchEntity> collection) {
        Collection<Match> matchList;

        if (collection != null && !collection.isEmpty()) {
            matchList = new ArrayList<Match>();
            for (example.example.com.data.entities.MatchEntity match : collection) {
                matchList.add(transform(match));
            }
        } else {
            matchList = Collections.emptyList();
        }

        return matchList;
    }
}
*/
