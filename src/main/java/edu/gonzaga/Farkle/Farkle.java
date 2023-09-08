

package edu.gonzaga.Farkle;

/*
*  This is the main class for the Farkle project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/

/** Main program class for launching Farkle program. */
public class Farkle {
    // This main is where your Farkle game starts execution for general use.
    public static void main(String[] args) {
        System.out.println("Hello Farkle");

        Die die1 = new Die(6);
        System.out.println(die1);
        System.out.println("Now rolling our die!");
        die1.roll();
        System.out.println(die1);
        System.out.println("Cool, huh?");

        // misspelled this wrod
    }
}
