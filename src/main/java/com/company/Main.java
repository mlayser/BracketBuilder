package com.company;

import com.company.model.MatchUp;
import com.company.model.Team;
import com.company.model.TeamLookup;
import com.company.utils.FiveThirtyEightDataReader;
import com.company.utils.TournamentExecutor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<MatchUp> east;
    private static List<MatchUp> west;
    private static List<MatchUp> south;
    private static List<MatchUp> midwest;
    private static Integer[] adjacentSeeds = {1, 16, 8, 9, 5, 12, 4, 13, 6, 11, 3, 14, 7, 10, 2, 15};
    private static TeamLookup teamLookup;

    public static void main(String[] args) {
        buildDivisions();
        List<Team> finalFourTeams = new ArrayList<>();
        finalFourTeams.add(TournamentExecutor.getWinner(east));
        finalFourTeams.add(TournamentExecutor.getWinner(west));
        finalFourTeams.add(TournamentExecutor.getWinner(south));
        finalFourTeams.add(TournamentExecutor.getWinner(midwest));
        List<MatchUp> finalFour = createAdjacentMatchups(finalFourTeams, 4);
        Team champion = TournamentExecutor.getWinner(finalFour);
        System.out.println("The NCAA Champion is: " + champion.getName()+"!");
    }


    public static void buildDivisions(){
        List<Team> teams = FiveThirtyEightDataReader.getTeams();
        teamLookup = new TeamLookup(teams);
        east = createMatchupsForDivision("East");
        west = createMatchupsForDivision("West");
        south = createMatchupsForDivision("South");
        midwest = createMatchupsForDivision("Midwest");
    }

    private static List<MatchUp> createMatchupsForDivision(String divisionName) {
        List<Team> teams = new ArrayList<>();
        for(int i = 0; i < adjacentSeeds.length; i++){
            teams.add(teamLookup.getTeam(divisionName, adjacentSeeds[i]));
        }
        return createAdjacentMatchups(teams, 0);
    }

    private static List<MatchUp> createAdjacentMatchups(List<Team> teams, Integer startingRound) {
        List<MatchUp> matchUps = new ArrayList<>();
        for(int i = 0; i < teams.size() - 1; i += 2){
            MatchUp matchUp = new MatchUp(teams.get(i), teams.get(i+1), startingRound);
            matchUps.add(matchUp);
        }
        return matchUps;
    }

}
