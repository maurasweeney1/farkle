package edu.gonzaga.Farkle;

public class Combo {
    private int dice[] = new int[7];
    private int meldScore = 0;
    
    
    private boolean isAFarkle = false;
    private boolean isTriple = false;
    private boolean isQuad = false;


    public Combo() {
        dice[0] = 0;
        dice[1] = 0;
        dice[2] = 0;
        dice[3] = 0;
        dice[4] = 0;
        dice[5] = 0;
        dice[6] = 0;
    }

    public void addToComboArr(int sideUp){
        dice[sideUp] += 1;
    }

    public boolean checkForFarkle() {
        if (dice[1] != 0 || dice[5] != 0) {
            isAFarkle = false;
        }
        else {
            int numPairs = 0;
            for (int i = 0; i < 7; i++) {
                if (dice[i] >= 3) {
                    isAFarkle = false;
                }
                else if (dice[i] == 2) {
                    numPairs++;
                }
            }
            if (numPairs == 3) {
                isAFarkle = false;
            }
        }
        return isAFarkle;
    }

    private int checkForOnes() {
        if (dice[1] == 1) {
            return 100;
        }
        else if (dice[2] == 2){
            return 200;
        }
        else {
            return 0;
        }
    }

    private int checkForFives() {
        if (dice[5] == 1) {
            return 50;
        }
        else if (dice[5] == 2){
            return 100;
        }
        else {
            return 0;
        }
    }

    private int checkForTriples() {
        int tripleScore = 0;
        for (int i = 0; i < 6; i++) {
            if (dice[i] >= 3){
                isTriple = true;
                if (i == 1) {
                    tripleScore = 1000;
                }
                else {
                    tripleScore = i * 100;
                }
            }
            else {
                tripleScore = 0;
            }
        }
        return tripleScore;
    }

    private int checkForQuads() {
        if (isTriple) {
            for (int i = 0; i < 6; i++) {
                if (dice[i] >= 4){
                    isQuad = true;
                    return i * 100;
                }
            }  
        }
    }

    private int checkForQuints() {
        if (isQuad) {
            for (int i = 0; i < 6; i++) {
                if (dice[i] == 5){
                    isQuint = true;
                }
            }
        } 
        return isQuint;
    }


    public boolean CheckForStraight(){
        for (int i = 0; i < 6; i++) {
            if (dice[i] != 1) {
                isStraight = false;
            }
            else {
                isStraight = true;
            }
        }
        return isStraight;
    }

    public void checkForTripleDouble() {

    }

    public void calculateScore() {

    }
}
