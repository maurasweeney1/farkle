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
        Integer pointsToWin = 0;
        Integer numPlayers = 0;
        Player currentPlayer;
        ArrayList<Integer> dice = new ArrayList<>();
        boolean everyoneGameOver = false;
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

        // get number of points to play until
        System.out.print("Please enter how many points you would like to play to this time: ");
        String inputPoints = scan.nextLine();
        if (inputPoints.isEmpty()) {
            pointsToWin = 10000;
            System.out.println(1000 + " points to win");
        }
        else {
            while (!Character.isDigit(inputPoints.charAt(0))) {
                System.out.print("Invalid choice, please enter how many points you would like to play to: ");
                inputPoints = scan.nextLine();
            }
            pointsToWin = Integer.valueOf(inputPoints);
        }
        
        // get number of players
        System.out.print("Please enter how many players are going to be playing: ");
        String inputNumPlayers = scan.nextLine();
        if (inputNumPlayers.isEmpty()) {
            numPlayers = 1;
            System.out.println(1 + " player");
        }
        else {
            while (!Character.isDigit(inputNumPlayers.charAt(0))) {
                System.out.print("Invalid choice, please enter how many points you would like to play to: ");
                inputNumPlayers = scan.nextLine();
            }
            numPlayers = Integer.valueOf(inputNumPlayers);
        }
        ArrayList<Player> playerList = new ArrayList<Player>();
        Player player;
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Please enter player name: ");
            String name = scan.nextLine();
            if (name.isEmpty()) { 
                player = new Player(i + 1);
            }
            else {
                player = new Player(name);
            }
            if (!player.getGameOver()) {
                playerList.add(player);
            }
        }
        numPlayers = playerList.size();

        // incase all players farkle somehow
        if (numPlayers == 0) {
            System.out.println("Oh no! Everyone Farkled, game is over");
            everyoneGameOver = true;
        }
        
        // prints out game interface, takes in user choice 
        while (!everyoneGameOver) { 
            for (int j = 0; j < numPlayers; j++) {
                currentPlayer = playerList.get(j);
                dice = currentPlayer.getDiceArray();
                currentPlayer.setRoundOver(false);
                meldScore = 0;
                while (!currentPlayer.getRoundOver()) {
                    System.out.println("Welcome " + currentPlayer.getName() + " its your turn!");
                    System.out.println("\n     Hand   Meld\n----------------------");
                    for (int i = 1; i < dice.size(); i++) {
                        String diceAti = "";
                        String meldAti = "";
                        if (dice.get(i) == 0) {
                            diceAti = " ";
                        }
                        else {
                            diceAti = dice.get(i).toString();
                        }
                        if (currentPlayer.getMeldAt(i) == 0) {
                            meldAti = " ";
                        }
                        else {
                            meldAti = currentPlayer.getMeldAt(i).toString();
                        }
                        System.out.println((char)(optChar+i - 1) + ")   " + diceAti + "    |    " + meldAti);
                    }
                    System.out.println("Score: " + meldScore); 
                    System.out.println("----------------------\nR)      Reroll Die\nQ)      Quit game\nZ)      Bank meld and end round");
                    System.out.println("\nYou can choose which die to move into your meld based on the options to the left!");

                    String userChoiceString = scan.nextLine().toUpperCase();
                    char userChoice = userChoiceString.charAt(0);
                    int translatedChoice = userChoice - 64;
                    if (translatedChoice == 17) {
                        // quit game;
                        currentPlayer.setGameOver(true);
                        currentPlayer.setRoundOver(true);
                        System.out.println("End of round, your score is 0");
                    }
                    else if (translatedChoice == 26) {
                        // bank meld and end round
                        currentPlayer.setTotalScore(currentPlayer.getTotalScore() + currentPlayer.getMeldScore());
                        currentPlayer.newRoundDie();
                        dice = currentPlayer.getDiceArray();
                        currentPlayer.setRoundOver(true);
                    }
                    else if (translatedChoice == 18) {
                        // reroll die
                        if(currentPlayer.getIsBadMeld() == true){
                            System.out.println("Sorry, you have die in the meld that cannot be scored");
                        }
                        else {
                            currentPlayer.updateMeldScore();
                            dice = currentPlayer.tryToReroll(dice);
                        }
                    }
                    else if (translatedChoice >= 1 && translatedChoice <= 6) {
                        if (dice.get(translatedChoice) != 0) {
                        // adds the die to the meld array
                        currentPlayer.addToMeld(dice.get(translatedChoice), translatedChoice);
                        // removes die from the dice array
                        dice.set(translatedChoice, 0);
                        // calculates the new score with new meld
                        meldScore = currentPlayer.updateMeldScore(); 
                        }
                        else {
                            // if die is already in the meld, being moved to the dice array
                            dice.set(translatedChoice, currentPlayer.getMeldAt(translatedChoice));
                            // removes the die from the meld array
                            currentPlayer.removeFromMeld(currentPlayer.getMeldAt(translatedChoice), translatedChoice);
                            // calculates new score without die in meld
                            meldScore = currentPlayer.updateMeldScore(); 
                        }
                    }
                    else {
                        System.out.println("Invalid choice");
                    }
                    if (currentPlayer.getGameOver()){
                        for (int i = 0; i < numPlayers; i++) {
                            if (playerList.get(i) == currentPlayer) {
                                playerList.remove(i);
                                System.out.println(currentPlayer.getName() + " is out of the game");
                                numPlayers--;
                            }
                        }
                    }
                } // while loop for round over ends
                if (currentPlayer.getTotalScore() >= pointsToWin) {
                    System.out.println("Congratulations " + currentPlayer.getName() + " you won!"); 
                    everyoneGameOver = true;
                }
            } // for loop through each player ends 
            // printing out all scores
            if (numPlayers == 0) {
                System.out.println("No more players left in the game");
                break;
            }
            else {
                System.out.println("\nCurrent meld scores:\n~~~~~~~~~~~~~~~~~~~~~~");
                for (int i = 0; i < numPlayers; i++) {
                    System.out.println(playerList.get(i).getName() + ": " + playerList.get(i).getTotalScore());
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n");
            }
            for (int i = 0; i < numPlayers; i++) {
                if (playerList.get(i).getGameOver()) {
                    everyoneGameOver = true;
                }
            }
        } // while loop for game over ends
    }
}