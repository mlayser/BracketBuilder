package model;

/**
 * Created by matthewlayser on 3/15/17.
 */
public class MatchUp {
    private Team underdog;
    private Team favored;
    private Integer round;

    public MatchUp(Team one, Team two, Integer round){
        this.round = round;
        if(one.getWinPercentageAtRound(round) < two.getWinPercentageAtRound(round)){
            underdog = one;
            favored = two;
        }
        else{
            underdog = two;
            favored = one;
        }
    }

    public Team getUnderdog(){
        return underdog;
    }

    public Double getUnderdogWinProbability(){
        return underdog.getWinPercentageAtRound(round);
    }

    public Double getFavoredWinProbability(){
        return favored.getWinPercentageAtRound(round);
    }

    public Team getFavored(){
        return favored;
    }

    public Integer getRound() {
        return round;
    }
}
