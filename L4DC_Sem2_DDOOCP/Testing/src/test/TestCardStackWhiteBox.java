/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardgame.Card;
import cardgame.CardStack;

/**
 *
 * @author Biju Ale
 */
public class TestCardStackWhiteBox {

    public static void main(String[] args) {

        //addToStack(Card card) method
        //Test Case #1
        System.out.println("Result of Test Case #1");
        try {
            CardStack cs = new CardStack();
            boolean result = cs.addToStack(new Card("5"));            
            cs.addToStack(new Card("5"));
            for (int i = 0; i < cs.getCardStack().size(); i++) {
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
