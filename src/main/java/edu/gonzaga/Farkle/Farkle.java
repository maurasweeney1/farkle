

package edu.gonzaga.Farkle;

import java.util.*;

/*
*  This is the main class for the Farkle project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/


// from dice held in meld keep track of which combos are valid
// or keep track of unused die and calculate without those at the end

/** Main program class for launching Farkle program. */
public class Farkle {
    // This main is where your Farkle game starts execution for general use.
    public static void main(String[] args) {
        boolean gameOver = false;
        Combo combo = new Combo();
        char optChar = 'A';
        System.out.println("Hello Farkle");

        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Die die3 = new Die(6);
        Die die4 = new Die(6);
        Die die5 = new Die(6);
        Die die6 = new Die(6);
        System.out.println("Now rolling our die!");
        die1.roll();
        combo.addToComboArr(die1.getSideUp());
        die2.roll();
        combo.addToComboArr(die2.getSideUp());
        die3.roll();
        combo.addToComboArr(die3.getSideUp());
        die4.roll();
        combo.addToComboArr(die4.getSideUp());
        die5.roll();
        combo.addToComboArr(die5.getSideUp());
        die6.roll();
        combo.addToComboArr(die6.getSideUp());
        ArrayList<Integer> dice =  new ArrayList<Integer>(Arrays.asList(die1.getSideUp(), die2.getSideUp(), die3.getSideUp(), die4.getSideUp(), die5.getSideUp(), die6.getSideUp()));
        System.out.println("         Hand   Meld\n-----------------------");
        Collections.sort(dice);
        for (int i = 0; i < dice.size(); i++) {
            System.out.println((char)(optChar+i) + ")      " + dice.get(i) + "     | ");
        }
        System.out.println("\nQ)      Quit game\nZ)      Bank meld and end round");
        System.out.println("\nYou can choose which die to move into your meld based on the option to the left!");

    }
}
