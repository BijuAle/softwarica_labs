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
import cardstacks.NotificationListener;

/**
 *
 * @author Biju Ale
 */
public class WhiteBxTestACollectionCardStacks implements NotificationListener {

    CollectionCardStacks ccs;
    String notification;

    WhiteBxTestACollectionCardStacks() {
        ccs = new CollectionCardStacks();
        ccs.addNotificationListener(this);

        System.out.println("Result of test case #1");
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
            System.out.println("Dealt Card: " + dealtCard.getNumber());

            System.out.println("\nResult of test case #1");
            //1 card is already dealt above, now 2 cards are dealt so that the carstack runs out of stack & returns dealtcard from repopulated stack.
            System.out.println("Dealt Card: " + dealtCard.getNumber());
            for (int i = 2; i < 4; i++) {
                Card dealtCard2 = ccs.moveDealtCard(nreader.getDiceNotation(), csdc);
                System.out.println("Dealt Card: " + dealtCard2.getNumber());
            }

            System.out.println("\nSize of cardstack: " + cs.size());
            System.out.println("Repopulating stack & dealing card again.");
            Card newDealtCard = ccs.moveDealtCard(nreader.getDiceNotation(), csdc);
            System.out.println("Dealt Card: " + newDealtCard.getNumber());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WhiteBxTestACollectionCardStacks();
    }

    @Override
    public void send(String notification) {
        this.notification = notification;
    }
}
