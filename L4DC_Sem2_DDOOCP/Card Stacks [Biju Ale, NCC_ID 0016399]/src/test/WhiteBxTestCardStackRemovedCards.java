/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.Card;
import cardstacks.CardStack;
import cardstacks.CardStackRemovedCards;
import cardstacks.Dice;
import cardstacks.NotationReader;
import java.util.ArrayList;

/**
 *
 * @author Biju Ale
 */
public class WhiteBxTestCardStackRemovedCards {
    public static void main(String[] args) {
        try {
            System.out.println("Result of test case #1");
            NotationReader nreader = new NotationReader();
            nreader.parseDiceNotation("3d2-4");
            Dice dice = new Dice(nreader);
            CardStackRemovedCards csrc = new CardStackRemovedCards();
            CardStack cardStack = new CardStack(dice, nreader, csrc);

            System.out.println("List of removed cards:");
            ArrayList<Card> removedCards = csrc.getRemovedCards("3d2-4");
            for (Card removedCard : removedCards) {
                System.out.println(removedCard.getNumber());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
