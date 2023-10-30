package edu.gonzaga.Farkle;
/** Class to hold die that have been added to the meld and hold meld score */
public class Meld {
    /** keeps track of the score as combo does calculations */
    private Integer meldScore;
    /** default number of dice that can be in a meld (is 6, first only holds 0) */
    private Integer DEFAULT_MELD_SIZE = 7;
    /** meld array holds the side that is up of each dice added */
    private Integer meld[] = {0, 0, 0, 0, 0, 0, 0};
    /** instance of combo in order to call combo methods */
    private Combo combo = new Combo();
    
    public Meld () {
        meldScore = 0;
    }

    /** Adds the number from the side of the die thats up to the meld
     * and combo array to calculate combos
     * 
     * @param the side of the die thats up, the index of the meld's
     * array to add the die at
     * @return nothing
    */
    public void addDie(Integer sideUp, Integer index) {
        meld[index] = sideUp;
        combo.addToComboArr(sideUp);
    }

    /** Removes the number from the side of the die thats up from the meld
     * and combo array
     * 
     * @param the side of the die thats up, the index of the meld's
     * array to add the die at
     * @return nothing
    */
    public void removeDie(Integer sideUp, Integer index) {
        meld[index] = 0;
        combo.removeFromComboArr(sideUp);
    }

    /** Returns the side of the die thats up at the the given index
     * 
     * @param the index of the meld's array the die is at
     * @return the side up
    */
    public Integer returnDie(Integer index) {
        return meld[index];
    }

    /** getter for the meldScore field
     * 
     * @return meldScore field
    */
    public Integer getMeldScore() {
        return meldScore;
    }

    /** setter for the meldScore field
     * 
     * @return updates meldScore field
    */
    public void setMeldScore(Integer meldScore) {
        this.meldScore = meldScore;
    }
    
    /** Returns the size of the meld array
     * 
     * @return the size of the list
    */
    public Integer size() {
        return DEFAULT_MELD_SIZE;
    }
    
    /** uses combo method to calculate the meld score as long as the
     * array is not empty
     * 
     * @return the meld score
    */
    public Integer calculateMeldScore() {
        if (this.combo == null) {
            return 0;
        }
        combo.calculateScore();
        meldScore = combo.getScore();
        return meldScore;
    }

    /** Checks to see if a there are any dice left in the meld, to be
     * used after calculating the score to ensure no dice in the meld
     * cannot be used
     * 
     * @return true or false (is or isn't any dice left in the meld)
    */
    public boolean checkForBadMeld() {
        int arr[] = combo.getUnusedDice();
        boolean badMeld = false;
        for (int i = 0; i < 7; i++) {
            if (arr[i] != 0) {
                badMeld = true;
            }
        }
        return badMeld;
    }
}

