/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.Canvas;
import cardstacks.Card;
import cardstacks.CardStack;
import cardstacks.CardStackDealtCards;
import cardstacks.CardStackRemovedCards;
import cardstacks.CollectionCardStacks;
import cardstacks.Dice;
import cardstacks.DrawActionListener;
import cardstacks.NotationReader;
import cardstacks.NotificationListener;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Biju Ale
 */
public class BlackWhiteBxTestACanvas extends JFrame implements NotificationListener {

    static Canvas canvas;
    String notification;
    Graphics g;
    static DrawActionListener drawActionListener;

    void testA() {//For Test case #1
        canvas = new Canvas();
        drawActionListener = canvas;
        canvas.addNotificationListener(this);

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
            Card singlDealtCard = ccs.moveDealtCard(nreader.getDiceNotation(), csdc);

            canvas.sendSingleDealtCard(singlDealtCard);
            canvas.ACTION_DRAW = Canvas.DRAW_FOR_GET_CARD;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void testB() {//For Test case #2
        System.out.println("\nResult of test case #2");
        canvas = new Canvas();
        drawActionListener = canvas;
        canvas.addNotificationListener(this);

        CollectionCardStacks ccs = new CollectionCardStacks();
        CardStackRemovedCards csrc = new CardStackRemovedCards();
        CardStackDealtCards csdc = new CardStackDealtCards();
        NotationReader nreader = new NotationReader();
        Dice dice;

        try {
            nreader.parseDiceNotation("xxx");
            dice = new Dice(nreader);
            CardStack cs = new CardStack(dice, nreader, csrc);
            ccs.add(cs);
            Card singlDealtCard = ccs.moveDealtCard(nreader.getDiceNotation(), csdc);

            canvas.sendSingleDealtCard(singlDealtCard);
            canvas.ACTION_DRAW = Canvas.DRAW_FOR_GET_CARD;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void testC() {//For Test case #3
        System.out.println("\nResult of test case #3");
        canvas = new Canvas();
        drawActionListener = canvas;
        canvas.addNotificationListener(this);

        CollectionCardStacks ccs = new CollectionCardStacks();
        CardStackRemovedCards csrc = new CardStackRemovedCards();
        CardStackDealtCards csdc = new CardStackDealtCards();
        NotationReader nreader = new NotationReader();
        Dice dice;

        try {
            nreader.parseDiceNotation("");
            dice = new Dice(nreader);
            CardStack cs = new CardStack(dice, nreader, csrc);
            ccs.add(cs);
            Card singlDealtCard = ccs.moveDealtCard(nreader.getDiceNotation(), csdc);

            canvas.sendSingleDealtCard(singlDealtCard);
            canvas.ACTION_DRAW = Canvas.DRAW_FOR_GET_CARD;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        BlackWhiteBxTestACanvas btc = new BlackWhiteBxTestACanvas();
        btc.setSize(500, 500);
        btc.setVisible(true);

        btc.testA();
        btc.add(canvas);

        btc.testB();

        btc.testC();

    }

    @Override
    public void send(String notification) {
        this.notification = notification;
    }
}
