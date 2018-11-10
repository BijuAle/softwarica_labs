/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
public class BlackBxTestBCollectionCardStacks {

    public static void main(String[] args) {
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
            System.out.println("CardStack 2d2 added. Only 2d2 exists in the collection.");

            System.out.println("\nResult of test case #1");
            System.out.println("Input for shuffling: 2d2");
            if (ccs.shuffleStack("2d2")) {
                System.out.println("TRUE");
            }

            System.out.println("\nResult of test case #2");
            System.out.println("Input for shuffling: xxx");
            if (!ccs.shuffleStack("xxx")) {
                System.out.println("FALSE");
            }

            System.out.println("\nResult of test case #3");
            System.out.println("Input for shuffling: 'null'");
            if (!ccs.shuffleStack("")) {
                System.out.println("FALSE");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
