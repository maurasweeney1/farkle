/* This program runs a version of Farkle where the user gets one hand
 * of die, and one roll with which they can create a meld
 * CPSC 224
 * Homework 1 - Zag Farkle Rolling and Scoring
 * no sources to cite
 * 
 * @author Maura Sweeney
 * 
 * @version v1.0 9/20/23
 */

package edu.gonzaga.Farkle;

import java.util.*;

/*
*  This is the main class for the Farkle project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/


// check if any dice in meld are invalid, tell them and dont let them reroll until

/** Main program class for launching Farkle program. */
public class Farkle {
    // This main is where your Farkle game starts execution for general use.
    public static void main(String[] args) {
        double dist;
        Player player;
        boolean gameOver = false;
        Meld meld = new Meld();
        Integer meldScore = 0;
        char optChar = 'A';
        Scanner scan = new Scanner(System.in);

        // print out intro
        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j <= 12; j++) {
                dist = Math.sqrt((i - 6) * (i - 6) + (j - 6) * (j - 6));
                if (i == 4) {
                    System.out.print("*  Welcome  *");
                    break;
                }
                if (i == 5) {
                    System.out.print("*    to     *");
                    break;
                }
                if (i == 6) {
                    System.out.print("*  Maura's  *");
                    break;
                }
                if (i == 7) {
                    System.out.print("*  Farkle   *");
                    break;
                }
                if (i == 9) {
                    System.out.print(" * © 2023  *");
                    break;
                }
                else if (dist > 5.5 && dist < 6.5) 
                    System.out.print("*");
                else 
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.println("Please enter your name:");
        String name = scan.nextLine();
        if (name == "\n") { // FIXME
            player = new Player();
        }
        else {
            player = new Player(name);
        }
        
        // creates new hand
        Hand fullHand = new Hand();
        ArrayList<Integer> dice = fullHand.getDiceArray();
        gameOver = fullHand.getIsGameOver();

        // prints out game interface, takes in user choice 
        while (gameOver == false) {
            System.out.println("Welcome " + player.getName() + " its your turn!");
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

            String userChoiceString = scan.nextLine().toUpperCase();
            char userChoice = userChoiceString.charAt(0);
            int translatedChoice = userChoice - 64;
            System.out.println(translatedChoice);
            if (translatedChoice == 17) {
                // bank meld and end round
                gameOver = true;
                System.out.println("End of round, your score is 0");
            }
            else if (translatedChoice == 26) {
                // quit games
                gameOver = true;
                System.out.println("End of round, your score is " + meld.calculateMeldScore());
            }
            else if (translatedChoice >= 1 && translatedChoice <= 6) {
                if (dice.get(translatedChoice) != 0) {
                // adds the die to the meld array
                meld.addDie(dice.get(translatedChoice), translatedChoice);
                // removes die from the dice array
                dice.set(translatedChoice, 0);
                // calculates the new score with new meld
                meldScore = meld.calculateMeldScore();
                }
                else {
                    // if die is already in the meld, being moved to the dice array
                    dice.set(translatedChoice, meld.returnDie(translatedChoice));
                    // removes the die from the meld array
                    meld.removeDie(meld.returnDie(translatedChoice), translatedChoice);
                    // calculates new score without die in meld
                    meldScore = meld.calculateMeldScore();
                }
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }
}