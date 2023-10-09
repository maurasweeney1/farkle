package edu.gonzaga.Farkle;

import java.util.*;

public class Hand {
    private ArrayList<Integer> dice =  new ArrayList<Integer>();
    private boolean isAFarkle = false;
    private int numPairs = 0;
    private boolean gameOver = false;

    public Hand() {
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
        dice.addAll(Arrays.asList(0, die1.getSideUp(), die2.getSideUp(), die3.getSideUp(), die4.getSideUp(), die5.getSideUp(), die6.getSideUp()));
        Collections.sort(dice);
    }

    public ArrayList<Integer> getRerollHand(ArrayList<Integer> newDice) {
        ArrayList<Die> rerollHand = new ArrayList<Die>();
        Die tempDie = new Die(6);
        ArrayList<Integer> rerollHandSideUp = new ArrayList<Integer>();
        rerollHandSideUp.add(0);
        for (int i = 1; i < newDice.size(); i++) {
            System.out.print("reroll " + i + ": ");
            tempDie.roll();
            System.out.println(tempDie.getSideUp());
            if(newDice.get(i) != 0) {
                rerollHand.add(tempDie);
            }
        }
        Collections.sort(rerollHand);
        for(int i = 0; i < rerollHand.size(); i++) {
            rerollHandSideUp.add(rerollHand.get(i).getSideUp());
        }
        dice = rerollHandSideUp;
        return rerollHandSideUp;
    }

    public boolean getIsGameOver() {
        return gameOver;
    }

    public int getNumPairs() {
        return numPairs;
    }

    public ArrayList<Integer> getDiceArray() {
        return dice;
    }
        
    public void checkForFarkle () {
        Integer diceSidesUp[] = {0, 0, 0, 0, 0, 0, 0};
        int num = 0;
        for (int i = 0; i < dice.size(); i++) {
            num = dice.get(i);
            diceSidesUp[num] += 1;
        }
        if (dice.size() == 1) {
            isAFarkle = true;
        }
        else if (dice.get(1) != 0 || dice.get(5) != 0) {
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
    }

    public Integer checkForHotHand() {
        for (int i = 0; i < dice.size(); i++) {
            if (!(dice.get(i).equals(dice.get(0))))
                return 0;
        }
        if (hotHandTrue() == 'A')
            return 1;
        else
            return 2;
    }

    public char hotHandTrue() {
        Scanner scan = new Scanner(System.in);
        Boolean validChoice = false;
        System.out.println("~~~~ Hot Hand! ~~~~\nWould you lik eto roll 6 new dice, or bank and end your turn?\n~~~~~~~~~~~~~~~~~~~");
        while (validChoice == false) {
            System.out.println("A) Six new dice\nB) Bank meld and end round");
            String userChoiceString = scan.nextLine().toUpperCase();
            char userChoice = userChoiceString.charAt(0);
            if (userChoice == 'A' || userChoice == 'B') {
                validChoice = true;
                return userChoice;
            }
            else {
                System.out.println("Invalid Choice, Please enter another choice");
            }
        }
        return ' ';
    }
}
