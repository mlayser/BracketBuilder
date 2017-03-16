package com.company.utils;

import com.company.model.MatchUp;
import com.company.model.Team;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by matthewlayser on 3/15/17.
 */
public class Game {

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    private Game(){

    }

    public static Team playGame(MatchUp m){
        return didFavoredWin(m.getUnderdogWinProbability(), m.getFavoredWinProbability()) ? m.getFavored() : m.getUnderdog();
    }


    /**
     * Returns true if the favored team won
     */
    private static Boolean didFavoredWin(Double underdog, Double favored){
        Double lotteryNumber = random.nextDouble(underdog + favored);
        return lotteryNumber < underdog ? false : true;
    }
}
