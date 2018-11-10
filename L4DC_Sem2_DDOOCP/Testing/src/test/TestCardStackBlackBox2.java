/*
 * To change this license header, choose License Headers in Project Properties.
 * To cpen the template in the editor.
 */
package test;

import cardgame.Card;
import cardgame.CardStack;

/**
 *
 * @author Biju Ale
 */
public class TestCardStackBlackBox2 {

    public static void main(String[] args) {
        //removeFromStack(Card card) method
        //Test Case #1       

        System.out.println("\nResult of Test Case #1");
        try {
            CardStack cs = new CardStack();
            Card one = new Card("1");
            Card two = new Card("2");
            cs.addToStack(one);
            cs.addToStack(two);

            boolean result = cs.removeFromStack(one);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Test Case #2
        System.out.println("\nResult of Test Case #2");
        try {
            CardStack cs = new CardStack();
            Card one = new Card("1");
            Card two = new Card("2");
            cs.addToStack(one);

            boolean result = cs.removeFromStack(two);
            System.out.println(result);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
