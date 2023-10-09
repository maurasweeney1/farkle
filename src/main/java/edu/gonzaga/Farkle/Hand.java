package edu.gonzaga.Farkle;

import java.util.*;

public class Hand {
    /** holds the side up of dice in the current hand */
    private ArrayList<Integer> dice =  new ArrayList<Integer>();
    /** holds whether or not the player Farkled */
    private boolean isAFarkle = false;
    /** holds whether or not the current game is over */
    private boolean gameOver = false;

    /** Description
     * 
     * @param 
     * @return 
    */
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
    public void checkForFarkle () {
        Integer numPairs = 0;
        Integer diceSidesUp[] = {0, 0, 0, 0, 0, 0, 0};
        int num = 0;
        for (int i = 0; i < dice.size(); i++) {
            num = dice.get(i);
            diceSidesUp[num] += 1;
        }
        if (dice.size() == 1) {
            isAFarkle = true;
        }
        else if (dice.get(1) != 0 || dice.get(5) != 0) {
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

    /** Checks whether or not the user has a hot hand, calling hotHandTrue() 
     * if they do
     * 
     * @return 0 if theres no hot hand, 1 if there is and the player rerolls, 
     * 2 if there is and the player quits
    */
    public Integer checkForHotHand() {
        for (int i = 0; i < dice.size(); i++) {
            if (!(dice.get(i).equals(dice.get(0))))
                return 0;
        }
        if (hotHandTrue() == 'A')
            return 1;
        else
            return 2;
    }

    /** Used when the user has a hot hand, asks wether they want to reroll all their die
     * or bank their current score
     * 
     * @return either A or B based on user input
    */
    public char hotHandTrue() {
        Scanner scan = new Scanner(System.in);
        Boolean validChoice = false;
        System.out.println("~~~~ Hot Hand! ~~~~\nWould you lik eto roll 6 new dice, or bank and end your turn?\n~~~~~~~~~~~~~~~~~~~");
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
