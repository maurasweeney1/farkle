package edu.gonzaga.Farkle;

public class Combo {
    private int dice[] = {0, 0, 0, 0, 0, 0, 0};

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

    public void printComboArr() {
        for (int i = 0; i < 7; i++) {
            System.out.println(returnComboArr(i));
        }
    }

    public Integer checkForOnes() {
        if (dice[1] == 1) {
            dice[1] -= 1;
            return 100;
        }
        else if (dice[1] == 2){
            dice[1] -= 2;
            return 200;
        }
        else {
            return 0;
        }
    }

    public Integer checkForFives() {
        if (dice[5] == 1) {
            dice[5] -= 1;
            return 50;
        }
        else if (dice[5] == 2){
            dice[5] -= 2;
            return 100;
        }
        else {
            return 0;
        }
    }

    public Integer checkForTriples() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] >= 3){
                dice[i] -= 3;
                if (i == 1) {
                    i = 10;
                }
                return i * 100;
            }
        }
        return 0;
    }

    public int checkForQuads() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] >= 4){
                dice[i] -= 4;
                if (i == 1) {
                    i = 10;
                }
                return (i * 100) * 2;
            }
        }  
        return 0;
    }

    public Integer checkForQuints() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] == 5){
                dice[i] -= 5;
                if (i == 1) {
                    i = 10;
                }
                return (i * 100) * 3;
            }
        }
        return 0;
    }

    public Integer checkForHex() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] == 6){
                dice[i] -= 6;
                if (i == 1) {
                    i = 10;
                }
                return (i * 100) * 4;
            }
        }
        return 0;
    }


    public Integer CheckForStraight(){
        boolean isStraight = true;
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] != 1) {
                isStraight = false;
            }
        }
        if (isStraight == true) {
            for (int i = 1; i < 7; i++) {
                dice[i] -= 1;
            }
            return 1000;
        }
        else {
            return 0;
        }
    }

    public Integer checkForTripleDouble() {
        Integer numPairs = 0;
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] == 2) {
                dice[i] -= 2;
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
        return checkForTriples() + checkForQuads() + checkForQuints() + checkForHex() + CheckForStraight() + checkForTripleDouble() + checkForOnes() + checkForFives();
    }
}
