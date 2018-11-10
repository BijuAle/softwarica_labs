/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.Dice;
import cardstacks.NotationReader;

/**
 *
 * @author Biju Ale
 */
public class WhiteBxTestADice {

    public static void main(String[] args) {
        System.out.println("Result of Test Case #1");
        NotationReader nreader = new NotationReader();
        try {
            nreader.parseDiceNotation("4d4");
            Dice dice = new Dice(nreader);
            //Testing Constructor
            System.out.println("Result of Constructor:");
            System.out.println("Checking no. of card to remove is < max combination no.:\tYes");
            System.out.println("Dice Object created.");
            System.out.println("Dice name set to: " + dice.getDiceName());

            //Testing setMinMax invoked by constructor
            System.out.println("\nResult of setMinMax invoked by constructor:");
            System.out.println("Minimum Card number: " + dice.getMinCombination());
            System.out.println("Maximum Card number: " + dice.getMaxCombination());

            //Testing populateCombinations invoked by setMinMax
            System.out.println("\nResult of populateCombinations invoked by setMinMax:");
            System.out.println("All possible combinations of a  4d4 dice");
            for (Integer eachCombination : dice.getCombinations()) {
                System.out.println(eachCombination);
            }

            //Testing roll invoked by populateCombinations
            System.out.println("\nResult of roll invoked by populateCombinations:");
            int sumFreqquencies = 0;
            for (int i = 0; i < dice.getFrequencies().length; i++) {
                System.out.println("Card: " + dice.getCombinations()[i] + "  Frequency: " + dice.getFrequencies()[i]);
                sumFreqquencies += dice.getFrequencies()[i];
            }
            System.out.println("Frequency Sum: " + sumFreqquencies);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\nResult of Test Case #2");
        try {
            nreader.parseDiceNotation("4d4-344");
            Dice dice = new Dice(nreader);
        } catch (Exception ex) {
            System.out.println("Checking no. of card to remove is < max combination no.:\tNo");
            System.out.println("Dice name not set: ");
            System.out.println(ex.getMessage());
        }
    }
}
