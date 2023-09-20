

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
        boolean isAFarkle = false;
        boolean gameOver = false;
        Meld meld = new Meld();
        Integer numPairs = 0;
        Integer meldScore = 0;
        char optChar = 'A';
        String userChoiceRaw = "";
        char userChoice = '\0';
        Scanner input = new Scanner(System.in);
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
        
        ArrayList<Integer> dice =  new ArrayList<Integer>(Arrays.asList(0, die1.getSideUp(), die2.getSideUp(), die3.getSideUp(), die4.getSideUp(), die5.getSideUp(), die6.getSideUp()));
        Collections.sort(dice);
        
        // check for a farkle
        if (dice.get(1) != 0 || dice.get(5) != 0) {
            isAFarkle = false;
        }
        else {
            for (Integer i = 0; i < 7; i++) {
                if (dice.get(i) >= 3) {
                    isAFarkle = false;
                }
                else if (dice.get(i) == 2) {
                    numPairs++;
                }
            }
            if (numPairs == 3) {
                isAFarkle = false;
            }
        }
        // end game if player farkled
        if (isAFarkle == true) {
            System.out.println("Oops! You farkled, round is over");
            gameOver = true;
        }

        while (gameOver == false) {
            System.out.println("\n     Hand   Meld\n----------------------");
            for (Integer i = 1; i < dice.size(); i++) {
                String diceAti = "";
                String meldAti = "";
                if (dice.get(i) == 0) {
                    diceAti = " ";
                }
                else {
                    diceAti = dice.get(i).toString();
                }
                if (meld.returnDie(i) == 0) {
                    meldAti = " ";
                }
                else {
                    meldAti = meld.returnDie(i).toString();
                }
                System.out.println((char)(optChar+i - 1) + ")   " + diceAti + "    |    " + meldAti);
            }
            System.out.println("Meld score: " + meldScore);
            System.out.println("----------------------\nQ)      Quit game\nZ)      Bank meld and end round");
            System.out.println("\nYou can choose which die to move into your meld based on the options to the left!");

            userChoiceRaw = input.nextLine();
            userChoice = ((userChoiceRaw.toUpperCase()).charAt(0));

            switch (userChoice) {
                case 'A': 
                    if (dice.get(1) != 0) {
                        meld.addDie(dice.get(1), 1);
                        dice.set(1, 0);
                        meldScore = meld.calculateMeldScore();
                        break;
                    }
                        dice.set(1, meld.returnDie(1));
                        meld.removeDie(meld.returnDie(1), 1);
                        meldScore = meld.calculateMeldScore();
                        break;
                // move dice after A) to meld
                case 'B': 
                    if (dice.get(2) != 0) {
                        meld.addDie(dice.get(2), 2);
                        dice.set(2, 0);
                        meldScore = meld.calculateMeldScore();
                        break;
                    }
                    dice.set(2, meld.returnDie(2));
                    meld.removeDie(meld.returnDie(2), 2);
                    meldScore = meld.calculateMeldScore();
                    break;
                // move dice after B) to meld
                case 'C': 
                    if (dice.get(3) != 0) {
                        meld.addDie(dice.get(3), 3);
                        dice.set(3, 0);
                        meldScore = meld.calculateMeldScore();
                        break;
                    }
                    dice.set(3, meld.returnDie(3));
                    meld.removeDie(meld.returnDie(3), 3);
                    meldScore = meld.calculateMeldScore();
                    break;
                // move dice after C) to meld
                case 'D': 
                    if (dice.get(4) != 0) {
                        meld.addDie(dice.get(4), 4);
                        dice.set(4, 0);
                        meldScore = meld.calculateMeldScore();
                        break;
                    }
                    dice.set(4, meld.returnDie(4));
                    meld.removeDie(meld.returnDie(4), 4);
                    meldScore = meld.calculateMeldScore();
                    break;
                // move dice after D) to meld
                case 'E':
                    if (dice.get(5) != 0) {
                        meld.addDie(dice.get(5), 5);
                        dice.set(5, 0);
                        meldScore = meld.calculateMeldScore();
                        break;
                    }
                    dice.set(5, meld.returnDie(5));
                    meld.removeDie(meld.returnDie(5), 5);
                    meldScore = meld.calculateMeldScore();
                    break;
                // move dice after E) to meld
                case 'F':
                    if (dice.get(6) != 0) {
                        meld.addDie(dice.get(6), 6);
                        dice.set(6, 0);
                        meldScore = meld.calculateMeldScore();
                        break;
                    }
                    dice.set(6, meld.returnDie(6));
                    meld.removeDie(meld.returnDie(6), 6);
                    meldScore = meld.calculateMeldScore();
                    break;
                // move dice after F) to meld
                case 'Q': gameOver = true;
                        System.out.println("End of round, your score is 0");
                        break;
                // bank meld and end round
                case 'Z': gameOver = true;
                        System.out.println("End of round, your score is " + meld.calculateMeldScore());
                        break;
                // quit games
                default: System.out.println("Invalid choice");
                        break;
            }
        }
    }
}