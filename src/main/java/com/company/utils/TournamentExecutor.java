package com.company.utils;

import com.company.model.MatchUp;
import com.company.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewlayser on 3/15/17.
 */
public class TournamentExecutor {

    private TournamentExecutor(){

    }

    public static Team getWinner(List<MatchUp> matchUps){
        while(matchUps.size() > 1){
            matchUps = playRound(matchUps, matchUps.get(0).getRound());
        }
        Team divisionChamp = Game.playGame(matchUps.get(0));
        if(matchUps.get(0).getRound() == 3){
            System.out.println(divisionChamp.getDivision() + " champion: " + divisionChamp.getName());
        }
        return  divisionChamp;
    }

    public static List<MatchUp> playRound(List<MatchUp> matchUps, Integer round){
        List<Team> winners = new ArrayList<>();
        List<MatchUp> nextRoundMatchups = new ArrayList<>();
        for(MatchUp matchUp : matchUps){
            Team winner = Game.playGame(matchUp);
            winners.add(winner);
            if(matchUp.getRound() == 4){
                System.out.println("Semifinals winner: " + winner.getName());
            }
            else {
                System.out.println(winner.getDivision() + " round: " + matchUp.getRound() + " winner: " + winner.getName());
            }
        }
        for(int i = 0; i < winners.size() - 1; i += 2){
            MatchUp matchUp = new MatchUp(winners.get(i), winners.get(i+1), round + 1);
            nextRoundMatchups.add(matchUp);
        }
        return nextRoundMatchups;
    }
}
