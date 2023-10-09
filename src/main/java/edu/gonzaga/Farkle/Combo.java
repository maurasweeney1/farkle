package edu.gonzaga.Farkle;
/** This class checks for each different possible combo and tallies
 * up the points earned
 */
public class Combo {
    /** dice array holds the side that is up for each die to keep track of which are used */
    private Integer dice[] = {0, 0, 0, 0, 0, 0, 0};
    private int unusedDice[] = {0, 0, 0, 0, 0, 0, 0};
    /** temporarily holds the score calculated by the combo checks for the meld score */
    private Integer score = 0;
    public Combo() {
        dice[0] = 0;
        dice[1] = 0;
        dice[2] = 0;
        dice[3] = 0;
        dice[4] = 0;
        dice[5] = 0;
        dice[6] = 0;
    }
    
    /** Increases thke number of the given side up in the array tracking
     * each side up in the dice array
     * 
     * @param the side that is up
     * @return nothing
    */
    public void addToComboArr(Integer sideUp){
        dice[sideUp] += 1;
        unusedDice[sideUp] += 1;
        if (unusedDice[sideUp] < 0) {
            unusedDice[sideUp] = 0;
        }
    }

    /** Decreases the number of the given side up in the array tracking
     * each side up in the dice array
     * 
     * @param the side that is up
     * @return nothing
    */
    public void removeFromComboArr(Integer sideUp) {
        dice[sideUp] -= 1;
        unusedDice[sideUp] -= 1;
        if (unusedDice[sideUp] < 0) {
            unusedDice[sideUp] = 0;
        }
    }

    /** Returns the number of dice with a given side up based on the index
     * 
     * @param the index (ie. the side thats up) to check
     * @return the number of dice at that index
    */
    public Integer returnComboArr(Integer index) {
        return dice[index];
    }

    /** Returns the score accumulated since it is private
     * 
     * @param none
     * @return the score
    */
    public Integer returnScore() {
        return score;
    }

    /** prints out the number of die at each index 
     * 
     * @param none
     * @return outputs the array
    */
    public void printComboArr() {
        for (int i = 0; i < 7; i++) {
            System.out.println("combo[" + i + "]: " + returnComboArr(i));
        }
    }

    public int [] getUnusedDice() {
        return unusedDice;
    }

    /** Checks to see if if 1 or 2 ones are in the meld and calculates
     * the score
     * 
     * @param none
     * @return nothing
    */
    public void checkForOnes() {
        if (dice[1] == 1) {
            unusedDice[1] -= 1;
            score += 100;
        }
        else if (dice[1] == 2){
            unusedDice[1] -= 2;
            score += 200;
        }
        else {
            score += 0;
        }
    }

    /** Checks to see if 1 or 2 fives are in the meld and calculates
     * the score
     * 
     * @param none
     * @return nothing
    */
    public void checkForFives() {
        if (dice[5] == 1) {
            unusedDice[5] -= 1;
            score += 50;
        }
        else if (dice[5] == 2){
            unusedDice[5] -= 2;
            score += 100;
        }
        else {
            score += 0;
        }
    }

    /** Checks to see if a triplet of any number is in the meld and calculates
     * the score
     * 
     * @param none
     * @return nothing
    */
    public void checkForTriples() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] >= 3){
                unusedDice[i] -= 3;
                if (i == 1) {
                    i = 10;
                }
                score += (i * 100);
            }
        }
        score += 0;
    }

    /** Checks to see if a quadruple of any number is in the meld and calculates
     * the score
     * 
     * @param none
     * @return nothing
    */
    public void checkForQuads() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] >= 4){
                unusedDice[i] -= 4;
                if (i == 1) {
                    i = 10;
                }
                score += ((i * 100) * 2);
            }
        }  
        score += 0;
    }

    /** Checks to see if a quintuple of any number is in the meld and calculates
     * the score
     * 
     * @param none
     * @return nothing
    */
    public void checkForQuints() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] == 5){
                unusedDice[i] -= 5;
                if (i == 1) {
                    i = 10;
                }
                score += ((i * 100) * 3);
            }
        }
        score += 0;
    }

    /** Checks to see if a hextuple of any number is in the meld and calculates
     * the score
     * 
     * @param none
     * @return nothing
    */
    public void checkForHex() {
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] == 6){
                unusedDice[i] -= 6;
                if (i == 1) {
                    i = 10;
                }
                score += (i * 100) * 4;
            }
        }
        score += 0;
    }

    /** Checks to see if a there is a straight (one of every number) 
     * is in the meld and calculates the score
     * 
     * @param none
     * @return nothing
    */
    public void CheckForStraight(){
        boolean isStraight = true;
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] != 1) {
                isStraight = false;
            }
        }
        if (isStraight == true) {
            for (int i = 1; i < 7; i++) {
                unusedDice[i] -= 1;
            }
            score += 1000;
        }
        else {
            score += 0;
        }
    }

     /** Checks to see if a there is are three sets of doubles in the 
     * meld and calculates the score
     * 
     * @param none
     * @return nothing
    */
    public void checkForTripleDouble() {
        Integer numPairs = 0;
        for (Integer i = 1; i < 7; i++) {
            if (dice[i] == 2) {
                unusedDice[i] -= 2;
                numPairs++;
            }
        }
        if (numPairs == 3) {
            score += 750;
        }
        else {
            score += 0;
        }
    }

    /** Calls checkForOnes(), checkForFives(), checkForTriples(), checkForQuads(), 
     * checkForQuints(), checkForHex(), CheckForStraight(), checkForTripleDouble() 
     * to find the total score
     * 
     * @param none
     * @return the meld score
    */
    public Integer calculateScore() {
        score = 0;
        checkForOnes();
        checkForFives();
        checkForTriples();
        checkForQuads();
        checkForQuints();
        checkForHex();
        CheckForStraight();
        checkForTripleDouble();
        for(int i = 0; i < 7; i++) {
            if(unusedDice[i] < 0) {
                unusedDice[i] = 0;
            }
        }
        return score;
    }
}
