

package edu.gonzaga.Farkle;

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
        Combo combo = new Combo();
        System.out.println("Hello Farkle");

        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Die die3 = new Die(6);
        Die die4 = new Die(6);
        Die die5 = new Die(6);
        Die die6 = new Die(6);
        System.out.println("Now rolling our die!");
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
        die6.roll();
        System.out.println(die1);
        System.out.println("Cool, huh?");

        // misspelled this wrod
    }
}
