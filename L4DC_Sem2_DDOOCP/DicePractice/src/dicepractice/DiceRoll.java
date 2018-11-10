/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicepractice;

import java.util.*;

/**
 *
 * @author Biju Ale
 */
public class DiceRoll {

    static String diceNotation;
    final String separator = "d";
    final int rollTimes = 10000;
    LinkedList<Integer> CardStack;
    int minCombination, maxCombination;
    Integer[] frequencies;

    //Read Dice Notation
    void readDiceNotation() {
        int numFaces = 0, numDices = 0;

        String[] parts = diceNotation.trim().split(separator);

        try {
            numDices = Integer.parseInt(parts[0]);
            numFaces = Integer.parseInt(parts[1]);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Dice Notation format Incorrect! Correct Notation example(14 dices, each with 92 faces): 14d92");

        }

        setMinMax(numDices, numDices * numFaces);
    }

    //set - min & max Combination
    void setMinMax(int minCombination, int maxCombination) {
        this.minCombination = minCombination;
        this.maxCombination = maxCombination;
    }

    //Populate list with all possible combinations
    void populateList() {
        CardStack = new LinkedList();
        for (int Combination = minCombination; Combination < maxCombination + 1; Combination++) {
            CardStack.add(Combination);
        }
    }

    //Roll the dice & record combinations' frequecnies
    void roll() {
        int randomIndex;

        //Reset all indexes
        frequencies = new Integer[CardStack.size()];
        for (int i = 0; i < frequencies.length; i++) {
            frequencies[i] = 0;
        }

        //Save index frequencies
        Random rdmGenerator = new Random();
        for (int i = 0; i < rollTimes; i++) {
            randomIndex = rdmGenerator.nextInt(CardStack.size());
            frequencies[randomIndex] += 1;
        }

    }

    //Print the combinations' frequencies
    void displayCombinationFrequencies() {
        int sum = 0;
        double percentsum = 0.0;
        for (int i = 0; i < CardStack.size(); i++) {
            System.out.println("Card: " + CardStack.get(i) + " Frequency: " + frequencies[i] + " Percentage: " + ((double) frequencies[i] / rollTimes * 100) + "%");
            sum += frequencies[i];
            percentsum += ((double) frequencies[i] / rollTimes * 100);
        }
        System.out.println("Frequency Sum: " + sum + "\nPercentage Sum: " + percentsum);
    }

    public static void main(String[] args) {

        System.out.println("Enter Dice Notation to roll the desired dice.");
        Scanner sc = new Scanner(System.in);
        diceNotation = sc.next();

        DiceRoll obj = new DiceRoll();
        obj.readDiceNotation();
        obj.populateList();
        obj.roll();
        obj.displayCombinationFrequencies();
    }
}
