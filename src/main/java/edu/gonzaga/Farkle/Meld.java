package edu.gonzaga.Farkle;
import java.util.ArrayList;

public class Meld {

    Die dieA;

    ArrayList<Die> dice = new ArrayList<>();

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
}