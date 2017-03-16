package com.company.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matthewlayser on 3/15/17.
 */
public class TeamLookup {

    private Map<Integer, Team> east = new HashMap<>();
    private Map<Integer, Team> west = new HashMap<>();
    private Map<Integer, Team> south = new HashMap<>();
    private Map<Integer, Team> midwest = new HashMap<>();
    private Map<String, Map<Integer, Team>> divisionLookup = new HashMap<>();

    public TeamLookup(List<Team> teams){
        divisionLookup.put("East", east);
        divisionLookup.put("West", west);
        divisionLookup.put("South", south);
        divisionLookup.put("Midwest", midwest);
        for (Team team : teams){
            divisionLookup.get(team.getDivision()).put(team.getSeed(), team);
        }
    }

    public Team getTeam(String division, Integer seed){
        return divisionLookup.get(division).get(seed);
    }
}
