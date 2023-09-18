package edu.gonzaga.Farkle;
import java.util.ArrayList;

public class Combo {
    private ArrayList<Integer> dice = new ArrayList<>();

    public Combo() {
        dice.add(0);
        dice.add(0);
        dice.add(0);
        dice.add(0);
        dice.add(0);
        dice.add(0);
        dice.add(0);
    }

    public void addToComboArr(int sideUp){
        dice.get(sideUp);
        // if == # add 1 to that index
    }

    public void checkForFarkle() {
        for (int i = 0; i > dice.size(); i++) {
            
        }
    }
}
