package edu.gonzaga.Farkle;

public class Meld {
    private Integer meldScore;
    private Integer DEFAULT_MELD_SIZE = 7;
    private Integer meld[] = {0, 0, 0, 0, 0, 0, 0};
    private Combo combo = new Combo();

    public Meld () {
        meldScore = 0;
    }

    public void addDie(Integer sideUp, Integer index) {
        meld[index] = sideUp;
        combo.addToComboArr(sideUp);
    }

    public void removeDie(Integer sideUp, Integer index) {
        meld[index] = 0;
        combo.removeFromComboArr(sideUp);
    }

    public Integer returnDie(Integer index) {
        return meld[index];
    }

    public void printMeld() {
        for(int i = 1; i < 7; i++) {
            System.out.println("meld[" + i + "]: " + meld[i]);
        }
    }
    
    public Integer size() {
        return DEFAULT_MELD_SIZE;
    }
    
    public Integer calculateMeldScore() {
        if (this.combo == null) {
            return 0;
        }
        meldScore = combo.calculateScore();
        return meldScore;
    }
}