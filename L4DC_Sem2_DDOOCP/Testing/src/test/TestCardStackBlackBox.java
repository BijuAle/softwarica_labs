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
public class TestCardStackBlackBox {

    public static void main(String[] args) {

        //addToStack(Card card) method
        //Test Case #1
        System.out.println("Result of Test Case #1");
        try {
            CardStack cs = new CardStack();
            boolean result = cs.addToStack(new Card("-1"));
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Test Case #2
        System.out.println("\nResult of Test Case #2");
        try {
            CardStack cs = new CardStack();
            boolean result = cs.addToStack(new Card("5"));
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Test Case #3
        System.out.println("\nResult of Test Case #3");
        try {
            CardStack cs = new CardStack();
            boolean result = cs.addToStack(new Card("0"));
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test Case #4
        System.out.println("\nResult of Test Case #4");
        try {
            CardStack cs = new CardStack();
            boolean result = cs.addToStack(new Card("a"));
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test Case #5
        System.out.println("\nResult of Test Case #5");
        try {
            CardStack cs = new CardStack();
            boolean result = cs.addToStack(new Card(""));
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
