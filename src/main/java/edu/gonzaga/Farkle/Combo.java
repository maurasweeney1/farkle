package edu.gonzaga.Farkle;

public class Combo {
    private int dice[] = {0, 0, 0, 0, 0, 0, 0};
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

    public void addToComboArr(Integer sideUp){
        dice[sideUp] += 1;
    }

    public void removeFromComboArr(Integer sideUp) {
        dice[sideUp] -= 1;
    }

    public Integer returnComboArr(Integer index) {
        return dice[index];
    }


    private Integer checkForOnes() {
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

    private Integer checkForFives() {
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

    private Integer checkForTriples() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] >= 3){
                isTriple = true;
                if (i == 1) {
                    return 1000;
                }
                else {
                    return i * 100;
                }
            }
        }
        return 0;
    }

    private int checkForQuads() {
        if (isTriple) {
            for (Integer i = 1; i < 7; i++) {
                if (dice[i] >= 4){
                    isQuad = true;
                    return i * 100;
                }
            }  
        }
        return 0;
    }

    private Integer checkForQuints() {
        if (isQuad) {
            for (Integer i = 1; i < 7; i++) {
                if (dice[i] == 5){
                    return i * 100;
                }
            }
        } 
        return 0;
    }


    private Integer CheckForStraight(){
        boolean isStraight = true;
        if (dice[1] == 0 &&  dice[2] == 0 && dice[3] == 0 && dice[4] == 0 && dice[5] == 0 && dice[1] == 0 && dice[6] == 0) {
            isStraight = false;
        }
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] != 1) {
                isStraight = false;
            }
        }
        if (isStraight == true) {
            return 1000;
        }
        else {
            return 0;
        }
    }

    private Integer checkForTripleDouble() {
        Integer numPairs = 0;
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] == 2) {
                numPairs++;
            }
        }
        if (numPairs == 3) {
            return 750;
        }
        else {
            return 0;
        }
    }

    public Integer calculateScore() {
        return checkForTriples() + checkForQuads() + checkForQuints() + CheckForStraight() + checkForTripleDouble() + checkForOnes() + checkForFives();
    }
}
