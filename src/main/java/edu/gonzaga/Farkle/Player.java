package edu.gonzaga.Farkle;

public class Player {
    private String name;
    private Integer playerScore;

    public Player() {
        name = "Unknown Player";
        playerScore = 0;
    }

    public Player(String inputName) {
        name = inputName;
        playerScore = 0;
    }

    public String getName() {
        return name;
    }

    public void updatePlayerScore(Integer score) {
        playerScore += score;
    }

    public Integer getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Integer score) {
        playerScore = score;
    }
}

