package edu.gonzaga.Farkle;

public class Player {
    private String name;

    public Player() {
        name = "Unknown Player";
    }

    public Player(String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }
}

