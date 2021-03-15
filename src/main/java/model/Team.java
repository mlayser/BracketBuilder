package model;

import java.util.List;

/**
 * Created by matthewlayser on 3/15/17.
 */
public class Team {
    private String name;
    private String division;
    private Integer seed;
    private List<Double> winPercentages;

    public Team(String name, String division, Integer seed, List<Double> winPercentages){
        this.name = name;
        this.division = division;
        this.seed = seed;
        this.winPercentages = winPercentages;
    }

    public Double getWinPercentageAtRound(Integer round){
        return winPercentages.get(round);
    }

    public String getName(){
        return name;
    }

    public String getDivision() {
        return division;
    }

    public Integer getSeed() {
        return seed;
    }
}
