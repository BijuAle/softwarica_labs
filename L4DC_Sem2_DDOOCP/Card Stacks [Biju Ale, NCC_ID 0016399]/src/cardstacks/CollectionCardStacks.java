/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Biju Ale
 */
public class CollectionCardStacks extends LinkedList<CardStack> {

    private NotificationListener notificationListener;

    public Card moveDealtCard(String diceNotation, CardStackDealtCards csdc) {
        Card dealtCard = new Card();
        for (CardStack eachCardStack : this) {
            if (eachCardStack.getDiceNotation().equals(diceNotation)) {
                if (!eachCardStack.isEmpty()) {
                    dealtCard = eachCardStack.getFirst();
                    eachCardStack.removeFirst();
                    csdc.add(dealtCard);
                } else if (eachCardStack.isEmpty()) {
                    notificationListener.send("\n\nCardStack empty! Reshuffling now...");
                    rePopulateStack(diceNotation, csdc);
                    dealtCard = eachCardStack.getFirst();
                    eachCardStack.removeFirst();
                    csdc.add(dealtCard);
                }
            }
        }
        return dealtCard;
    }

    private void rePopulateStack(String diceNotation, CardStackDealtCards csdc) {
        ListIterator<Card> itr = csdc.listIterator();
        ArrayList<Card> toReturn = new ArrayList<Card>();
        while (itr.hasNext()) {
            Card next = itr.next();
            if (next.getDiceNotation().equals(diceNotation)) {
                toReturn.add(next);
                itr.remove();
            }
        }
        for (CardStack eachCardStack : this) {
            if (eachCardStack.getDiceNotation().equals(diceNotation)) {
                eachCardStack.addAll(toReturn);
            }
        }
    }

    public boolean shuffleStack(String diceNotation) {
        for (CardStack eachCardStack : this) {
            if (eachCardStack.getDiceNotation().equals(diceNotation)) {
                Collections.shuffle(eachCardStack);
                return true;
            }
        }
        return false;
    }

    public CardStack getFutureCards(String diceNotation) {
        for (CardStack eachCardStack : this) {
            if (eachCardStack.getDiceNotation().equals(diceNotation)) {
                return eachCardStack;
            }
        }
        return null;
    }

    public void addNotificationListener(NotificationListener notificationListener) {
        this.notificationListener = notificationListener;
    }
}
