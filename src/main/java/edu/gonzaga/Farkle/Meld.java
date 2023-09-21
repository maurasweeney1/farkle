package edu.gonzaga.Farkle;
/** Class to hold die that have been added to the meld and hold meld score */
public class Meld {
    private Integer meldScore;
    private Integer DEFAULT_MELD_SIZE = 7;
    private Integer meld[] = {0, 0, 0, 0, 0, 0, 0};
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

    /*public void printMeld() {
        for(int i = 1; i < 7; i++) {
            System.out.println("meld[" + i + "]: " + meld[i]);
        }
    }*/
    
    /** Returns the size of the meld array
     * 
     * @param none
     * @return the size of the list
    */
    public Integer size() {
        return DEFAULT_MELD_SIZE;
    }
    
    /** uses combo method to calculate the meld score as long as the
     * array is not empty
     * 
     * @param none
     * @return the meld score
    */
    public Integer calculateMeldScore() {
        if (this.combo == null) {
            return 0;
        }
        meldScore = combo.calculateScore();
        return meldScore;
    }
}