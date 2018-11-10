/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.CardStack;
import cardstacks.CardStackRemovedCards;
import cardstacks.Dice;
import cardstacks.NotationReader;

/**
 *
 * @author Biju Ale
 */
public class WhiteBxTestCardStack {

    public static void main(String[] args) {
        try {
            System.out.println("Result of test case #1");
            NotationReader nreader = new NotationReader();
            nreader.parseDiceNotation("2d2");
            Dice dice = new Dice(nreader);
            CardStackRemovedCards csrc = new CardStackRemovedCards();

            CardStack cardStack = new CardStack(dice, nreader, csrc);
            System.out.println("diceNotation: " + cardStack.getDiceNotation());
            System.out.println("Cards to remove: " + nreader.getToRemove());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("\nResult of test case #2");
            NotationReader nreader = new NotationReader();
            nreader.parseDiceNotation("2d2-1");
            Dice dice = new Dice(nreader);
            CardStackRemovedCards csrc = new CardStackRemovedCards();

            CardStack cardStack = new CardStack(dice, nreader, csrc);
            System.out.println("diceNotation: " + cardStack.getDiceNotation());
            System.out.println("Cards to remove: " + nreader.getToRemove());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
