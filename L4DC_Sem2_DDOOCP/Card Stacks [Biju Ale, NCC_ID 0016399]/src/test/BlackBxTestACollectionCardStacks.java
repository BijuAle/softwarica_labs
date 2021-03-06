/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.Card;
import cardstacks.CardStack;
import cardstacks.CardStackDealtCards;
import cardstacks.CardStackRemovedCards;
import cardstacks.CollectionCardStacks;
import cardstacks.Dice;
import cardstacks.NotationReader;

/**
 *
 * @author Biju Ale
 */
public class BlackBxTestACollectionCardStacks {

    public static void main(String[] args) {
        System.out.println("Result of test case #1");
        CollectionCardStacks ccs = new CollectionCardStacks();

        CardStackRemovedCards csrc = new CardStackRemovedCards();
        CardStackDealtCards csdc = new CardStackDealtCards();
        NotationReader nreader = new NotationReader();
        Dice dice;
        try {
            nreader.parseDiceNotation("2d2");
            dice = new Dice(nreader);
            CardStack cs = new CardStack(dice, nreader, csrc);
            ccs.add(cs);

            Card dealtCard = ccs.moveDealtCard(nreader.getDiceNotation(), csdc);
            System.out.println("DealtCard: " + dealtCard.getNumber());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
