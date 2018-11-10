/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.Card;

/**
 *
 * @author Biju Ale
 */
public class BlackBxTestACard {

    public static void main(String[] args) {
        System.out.println("Result of test case #1");
        Card card = new Card(4, 453, "4d4");
        System.out.println("Card number: " + card.getNumber());
        System.out.println("Frequency: " + card.getFrequency());
        System.out.println("Dice Notation: " + card.getDiceNotation());
    }
}
