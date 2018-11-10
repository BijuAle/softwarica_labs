/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.Card;
import cardstacks.CardStackDealtCards;
import java.util.ArrayList;

/**
 *
 * @author Biju Ale
 */
public class WhiteBxTestCardStackDealtCards {

    public static void main(String[] args) {
        try {
            System.out.println("Result of test case #1");

            CardStackDealtCards csdc = new CardStackDealtCards();
            csdc.add(new Card(4, 455, "4d4"));
            csdc.add(new Card(5, 345, "4d4"));
            csdc.add(new Card(6, 453, "4d4"));

            System.out.println("List of dealt cards:");
            ArrayList<Card> dealtCards = csdc.getDealtCards("4d4");
            for (Card dealtCard : dealtCards) {
                System.out.println(dealtCard.getNumber());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
