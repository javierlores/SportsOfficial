package example.example.com.sportsofficial.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import example.example.com.sportsofficial.models.Match;

public class MatchMapper implements Mapper<Match, com.example.domain.models.Match> {
    @Override
    public Match transform(com.example.domain.models.Match from) {
        return null;
    }

    @Override
    public Collection<Match> transform(Collection<com.example.domain.models.Match> collection) {
        Collection<Match> matchList;

        if (collection != null && !collection.isEmpty()) {
            matchList = new ArrayList<Match>();
            for (com.example.domain.models.Match match : collection) {
                matchList.add(transform(match));
            }
        } else {
            matchList = Collections.emptyList();
        }

        return matchList;
    }
}
