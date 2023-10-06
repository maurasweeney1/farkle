package edu.gonzaga.Farkle;

import java.util.*;

public class Hand {
    private ArrayList<Integer> dice =  new ArrayList<Integer>();
    private boolean isAFarkle = false;
    private int numPairs = 0;
    private boolean gameOver = false;

    public Hand() {
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Die die3 = new Die(6);
        Die die4 = new Die(6);
        Die die5 = new Die(6);
        Die die6 = new Die(6);
        System.out.println("Now rolling our die!");
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
        die6.roll();
        dice.addAll(Arrays.asList(0, die1.getSideUp(), die2.getSideUp(), die3.getSideUp(), die4.getSideUp(), die5.getSideUp(), die6.getSideUp()));
        Collections.sort(dice);
    }

    public boolean getIsGameOver() {
        return gameOver;
    }

    public int getNumPairs() {
        return numPairs;
    }

    public ArrayList<Integer> getDiceArray() {
        return dice;
    }
        
    public void checkForFarkle () {
        if (dice.get(1) != 0 || dice.get(5) != 0) {
            isAFarkle = false;
        }
        else {
            for (Integer i = 0; i < 7; i++) {
                if (dice.get(i) >= 3) {
                    isAFarkle = false;
                }
                else if (dice.get(i) == 2) {
                    numPairs++;
                }
            }
            if (numPairs == 3) {
                isAFarkle = false;
            }
        }
        // end game if player farkled
        if (isAFarkle == true) {
            System.out.println("Oops! You farkled, round is over");
            gameOver = true;
        }
    }
}
