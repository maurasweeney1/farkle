package edu.gonzaga.Farkle;

public class Player {
    /** keeps track of the current player's name */
    private String name;
    /** keeps track of the player's meldScore throughout multiple rounds */
    private Integer playerScore;
    /** keeps track of the number of players to provide a unique name if not entered */
    private Integer numPlayers = 1;

    public Player() {
        name = "Unknown Player" + numPlayers;
        playerScore = 0;
        numPlayers++;
    }

    public Player(String inputName) {
        name = inputName;
        playerScore = 0;
    }

    /** getter for the name field
     * 
     * @return the name field
    */
    public String getName() {
        return name;
    }

    /** Updates the playerScore field with an input score
     * 
     * @param integer score value
     * @return updates the playerScore field
    */
    public void updatePlayerScore(Integer score) {
        playerScore += score;
    }

    /** getter for the playerScore field
     * 
     * @return the playerScore field
    */
    public Integer getPlayerScore() {
        return playerScore;
    }

    /** setter for the playerScore field
     * 
     * @param Integer score value
     * @return updates the playerScore field
    */
    public void setPlayerScore(Integer score) {
        playerScore = score;
    }
}

