package diceroll3;

import java.util.Random;
import java.util.Scanner;

public class diceroll {

    static String diceNotation;

    public static void main(String[] args) {
        System.out.println("Enter dice Notation.");
        diceNotation = new Scanner(System.in).next();
        readDiceNotation(diceNotation);
    }

    static void readDiceNotation(String diceNotation) {
        String[] parts = diceNotation.split("d");
        int numDices = Integer.parseInt(parts[0]);
        int numFaces = Integer.parseInt(parts[1]);

        generateCards(numDices, numFaces);
    }

    static void generateCards(int numDices, int numFaces) {
        int[] Cards = new int[(numDices * numFaces - numDices) + 1];
        int j = 0;
        for (int i = numDices; i < (numDices * numFaces + 1); i++) {
            Cards[j] = i;
            j++;
        }
        generateFrequencies(Cards);
    }

    static void generateFrequencies(int[] Cards) {
        int[] frequencies = new int[Cards.length];
        Random random = new Random();
        int roll;

        for (int i = 0; i < 5000; i++) {
            roll = random.nextInt(Cards.length);
            frequencies[roll] += 1;
        }
        displayOccurence(frequencies, Cards);
    }

    static void displayOccurence(int[] frequencies, int[] Cards) {
        int sum = 0;
        double perSum = 0.00d;

        for (int i = 0; i < frequencies.length; i++) {
            System.out.println("Cards " + Cards[i] + " Frequency: " + frequencies[i] + " Percentage: " + (double) (frequencies[i] / 50d));
            sum += frequencies[i];
            perSum += (double) (frequencies[i] / 50d);
        }
        System.out.println("\nSum:" + sum + "\tPercentage Sum: " + perSum);
    }

}
