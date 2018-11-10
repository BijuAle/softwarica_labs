        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstacks;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Biju Ale
 */
public class CardStack extends LinkedList<Card> {

    private String diceNotation;
    private Integer max;

    public String getDiceNotation() {
        return diceNotation;
    }

    public CardStack(Dice dice, NotationReader nreader, CardStackRemovedCards csrc) {
        this.diceNotation = dice.getDiceName();
        populateCardStack(dice.getCombinations(), dice.getFrequencies());
        if (nreader.getToRemove() > 0) {
            removeCard(nreader.getToRemove(), csrc);
        }
    }

    public CardStack(String diceNotation) {
        this.diceNotation = diceNotation;
    }

    private void populateCardStack(Integer[] Combinations, Integer[] frequencies) {
        for (int i = 0; i < Combinations.length; i++) {
            add(new Card(Combinations[i], frequencies[i], diceNotation));
        }
        Collections.shuffle(this);
    }

    private void removeCard(int toRemove, CardStackRemovedCards csrc) {
        Iterator itr = this.iterator();
        for (int i = 0; i < toRemove; i++) {
            csrc.add(getFirst());
            removeFirst();
        }
    }

}
