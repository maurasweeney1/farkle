package edu.gonzaga.Farkle;

import java.util.ArrayList;

public class Player {
    /** keeps track of the current player's name */
    private String name;
    /** keeps track of the player's meldScore per round */
    private Integer meldScore = 0;
    /** keeps track of the player's score throughout multiple rounds */
    private Integer totalScore = 0;
    /** holds the player's meld */
    private Meld meld;
    /** holds each player's hand */
    private Hand hand;
    
    public Player(Integer numPlayers) {
        name = "Unknown Player #" + numPlayers;
        meldScore = 0;
        meld = new Meld();
        hand = new Hand();
        if (hand.checkForFarkle()) {
            hand.setIsRoundOver(true);
        }
    }

    public Player(String inputName) {
        name = inputName;
        meldScore = 0;
        meld = new Meld();
        hand = new Hand();
        if (hand.checkForFarkle()) {
            hand.setIsRoundOver(true);
        }
    }

    public void newRoundDie() {
        meld = new Meld();
        hand = new Hand();
        if (hand.checkForFarkle()) {
            hand.setIsRoundOver(true);
        }
    }

    /** getter for the name field
     * 
     * @return the name field
    */
    public String getName() {
        return name;
    }

    /** setter for the name field
     * 
     * @param string input by user
     * @return updates the name field
    */
    public void setName(String name) {
        this.name = name;
    }

    /** Updates the playerScore field with an input score
     * 
     * @param integer score value
     * @return updates the playerScore field
    */
    public Integer updateMeldScore() {
        return meld.calculateMeldScore();
    }

    /** getter for the meldScore field
     * 
     * @return the meldScore field
    */
    public Integer getMeldScore() {
        meldScore = meld.getMeldScore();
        return meldScore;
    }

    /** setter for the meldScore field
     * 
     * @param Integer score value
     * @return updates the meldScore field
    */
    public void setMeldScore(Integer score) {
        meldScore = score;
    }

    /** getter for the totalScore field
     * 
     * @return the totalScore field
    */
    public Integer getTotalScore() {
        return totalScore;
    }

    /** setter for the totalScore field
     * 
     * @param Integer score value
     * @return updates the totalScore field
    */
    public void setTotalScore(Integer score) {
        totalScore = score;
    }

    /** removes a die at a given index with a certain side up from the player's meld
     * 
     * @param the index and side up of the die
     * @return the die is removed from the meld and combo arrays
    */
    public void removeFromMeld(Integer sideUp, Integer index) {
        meld.removeDie(sideUp, index);
    }

    /** adds a die at a given index with a certain side up to the player's meld
     * 
     * @param the index and side up of the die
     * @return the die is added to the meld and combo arrays
    */
    public void addToMeld(Integer sideUp, Integer index) {
        meld.addDie(sideUp, index);
    }

    /** returns the die at a given index with a certain side up in the player's meld
     * 
     * @param the index of the die
     * @return the side up of the die
    */
    public Integer getMeldAt(Integer index) {
        return meld.returnDie(index);
    }

    /** getter for the meld field
     * 
     * @return the player's meld
    */
    public Meld getMeld() {
        return meld;
    }

    /** getter for the gameOver field
     * 
     * @return the boolean value in the gameOver field
    */
    public boolean getGameOver() {
        return hand.getIsGameOver();
    }

    /** setter for the gameOver field
     * 
     * @param a true or false value
     * @return the gameOver field is changed to the parameter value
    */
    public void setGameOver(boolean isGameOver) {
        hand.setIsGameOver(isGameOver);
    }

    /** getter for the roundOver field
     * 
     * @return the boolean value in the roundOver field
    */
    public boolean getRoundOver() {
        return hand.getIsRoundOver();
    }

    /** setter for the roundOver field
     * 
     * @param a true or false value
     * @return the roundOver field is changed to the parameter value
    */
    public void setRoundOver(boolean isRoundOver) {
        hand.setIsRoundOver(isRoundOver);
    }

    /** getter for the dice field
     * 
     * @return the ArrayList in in the dice field
    */
    public ArrayList<Integer> getDiceArray() {
        return hand.getDiceArray();
    }

    /** calls the checkForBadMeld functioin in the hand class on the player's hand
     * 
     * @return a boolean value based on whether the player's hand is a value meld
    */
    public boolean getIsBadMeld() {
        return meld.checkForBadMeld();
    }

    /** Creates a new meld to reroll with, updates dice and meldScore fields
     * 
     * @param ArrayList of dice, and integer representing the meldscore 
     * @return the updated dice ArrayList
    */
    public ArrayList<Integer> tryToReroll(ArrayList<Integer> dice) {
        meld = new Meld();
        dice = hand.getRerollHand(dice);
        hand.checkForFarkle();
        if (hand.checkForHotHand() == true) {
            hand = new Hand();
        }
        return dice;
    }
}
