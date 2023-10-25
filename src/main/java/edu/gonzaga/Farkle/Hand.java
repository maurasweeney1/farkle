 package edu.gonzaga.Farkle;

import java.util.*;

public class Hand {
    /** holds the side up of dice in the current hand */
    private ArrayList<Integer> dice =  new ArrayList<Integer>();
    /** holds whether or not the current game is over */
    private boolean gameOver = false;
    /** holds the number of dice in the current hand */
    private Integer numDie = 0;

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
        numDie = 6;
    }

    public Hand(ArrayList<Integer> newDice) {
        dice = newDice;
        Collections.sort(dice);
        numDie = newDice.size();
    }

    /** rerolls hand given previously used ArrayList of die
     * 
     * 
     * @param ArrayList of Integers, previous hand
     * @return ArrayList of a new hand, only including rerolled die
    */
    public ArrayList<Integer> getRerollHand(ArrayList<Integer> newDice) {
        Die tempDie = new Die(6);
        Integer tempSideUp = 0;
        ArrayList<Integer> rerollHandSideUp = new ArrayList<Integer>();
        rerollHandSideUp.add(0);
        for (int i = 1; i < newDice.size(); i++) {
            tempDie.roll();
            tempSideUp = tempDie.getSideUp();
            if(newDice.get(i) != 0) {
                rerollHandSideUp.add(tempSideUp);
            }   
        }
        Collections.sort(rerollHandSideUp);
        dice = rerollHandSideUp;
        numDie = newDice.size();
        return rerollHandSideUp;
    }

    /** getter for GameOver field
     * 
     * @return gameOver field
    */
    public boolean getIsGameOver() {
        return gameOver;
    }

    /** Setter for GameOver field
     * 
     * @param true or false value for gameOVer
     * @return updates gameOver field
    */
    public void setIsGameOver(boolean bool) {
        gameOver = bool;
    }

    /** getter for dice field
     * 
     * @return dice array field
    */
    public ArrayList<Integer> getDiceArray() {
        return dice;
    }
        
    /** checks whether or not the player Farkled that round
     * 
     * @return updates isAFarkle and gameOverField
    */
    public boolean checkForFarkle() {
        boolean isAFarkle = false;
        Meld meld = new Meld();
        for (int i = 0; i < dice.size(); i++) {
            meld.addDie(dice.get(i), i);
        }
        meld.calculateMeldScore();
        if(meld.getMeldScore() == 0) {
            // end game if player farkled
            System.out.println("Oops! You farkled, round is over");
            gameOver = true;
            isAFarkle = true;
        }
        return isAFarkle;
    }

    /** Checks whether or not the user has a hot hand, calling hotHandTrue() 
     * if they do
     * 
     * @return false if theres no hot hand, true if there is and the player rerolls, 
     * and true and gameOver is set to true if there is and the player quits
    */
    public boolean checkForHotHand(Hand hand) {
        Meld meld = new Meld();
        for (int i = 1; i < hand.dice.size(); i++) {
            meld.addDie(hand.dice.get(i), i);
        }
        meld.calculateMeldScore();
        if (meld.checkForBadMeld()) {
            return false;
        }
        else if (hotHandTrue() == 'A') {
            return true;
        }
        else {
            gameOver = true;
            return true;
        }
    }

    /** Used when the user has a hot hand, asks wether they want to reroll all their die
     * or bank their current score
     * 
     * @return either A or B based on user input
    */
    public char hotHandTrue() {
        Scanner scan = new Scanner(System.in);
        Boolean validChoice = false;
        System.out.println("~~~~ Hot Hand! ~~~~\nWould you like to roll 6 new dice, or bank and end your turn?\n~~~~~~~~~~~~~~~~~~~");
        while (validChoice == false) {
            System.out.println("A) Six new dice\nB) Bank meld and end round");
            String userChoiceString = scan.nextLine().toUpperCase();
            char userChoice = userChoiceString.charAt(0);
            if (userChoice == 'A' || userChoice == 'B') {
                validChoice = true;
                return userChoice;
            }
            else {
                System.out.println("Invalid Choice, Please enter another choice");
            }
        }
        return ' ';
    }
}