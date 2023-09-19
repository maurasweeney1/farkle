package edu.gonzaga.Farkle;
import java.util.ArrayList;

public class Meld {

    private int meldScore;
    int meld[] = {0, 0, 0, 0, 0, 0, 0};


    private ArrayList<Die> dice = new ArrayList<>();
    private ArrayList<Integer> dieNotUsed = new ArrayList<>();


    public Meld () {
        System.out.println("Meld created");
        System.out.println(dice.size());
    }

    public void addDie(Die die) {
        dice.add(die);
    }
    
    public Integer size() {
        return dice.size();
    }
    

    public void addToDieNotUsed(int value) {
        dieNotUsed.add(value);
    }
}