/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.NotationReader;

/**
 *
 * @author Biju Ale
 */
public class WhiteBxTestANotationReader {

    public static void main(String[] args) {
        NotationReader nreader = new NotationReader();

        System.out.println("Result of Test Case # 1");
        try {
            nreader.parseDiceNotation("4d4-2");
            System.out.println("Dice Notation: " + nreader.getDiceNotation());
            System.out.println("No. of dice(s): " + nreader.getNumDices());
            System.out.println("No. of dice-faces: " + nreader.getNumFaces());
            System.out.println("No. of cards to remove: " + nreader.getToRemove());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nResult of Test Case # 2");
        try {
            nreader.parseDiceNotation("xyz");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
