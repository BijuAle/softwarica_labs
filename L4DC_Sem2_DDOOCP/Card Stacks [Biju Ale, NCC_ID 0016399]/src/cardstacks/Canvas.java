/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstacks;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JPanel;

/**
 *
 * @author Biju Ale
 */
public class Canvas extends JPanel implements DrawActionListener {

    public int ACTION_DRAW;
    public final static int DRAW_FOR_GET_CARD = 1;
    public final static int DRAW_FOR_DEALT_CARD = 2;
    public final static int DRAW_FOR_REMOVED = 3;
    public final static int DRAW_FOR_FUTURE = 4;

    private ArrayList<Card> allDealtCards;
    private ArrayList<Card> allRemovedCards;
    private Card singleDealtCard;
    private CardStack futureCards;

    private int x = 5, y = 25;
    NotificationListener notificationListener;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (ACTION_DRAW) {
            case DRAW_FOR_GET_CARD:
                drawForGetCard(g2d);
                break;
            case DRAW_FOR_REMOVED:
                drawForPeekRemovedCard(g2d);
                break;
            case DRAW_FOR_DEALT_CARD:
                drawForPeekDealtCard(g2d);
                break;
            case DRAW_FOR_FUTURE:
                drawForPeekFutureCard(g2d);
                break;
        }
    }

    private void drawForGetCard(Graphics g2d) {
        if (singleDealtCard.getDiceNotation() != null) {
            notificationListener.send("\n\nGetting card...");
            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g2d.drawString("Recently dealt card for stack: " + singleDealtCard.getDiceNotation(), x, y);

            Font font = new Font("Times New Roman", Font.PLAIN, 200);
            g2d.setFont(font);
            String num = "" + singleDealtCard.getNumber();
            g2d.drawString(num, 250, 292);

            Font font1 = new Font("Times New Roman", Font.PLAIN, 50);
            g2d.setFont(font1);
            String freq = "" + (double) Math.round((singleDealtCard.getFrequency() / 100d) * 10d) / 10d + "%";
            g2d.drawString(freq, 250, 394);
        } else {
            notificationListener.send("\n\nNo card exists to deal! Enter valid notation");
        }
    }

    private void drawForPeekDealtCard(Graphics g2d) {
        if (allDealtCards != null && allDealtCards.size() > 0) {
            notificationListener.send("\n\nGetting dealt cards with Graph...");
            int x = 5;
            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g2d.drawString("All Dealt Cards from stack: " + allDealtCards.get(0).getDiceNotation(), x, y);

            for (Card eachDealtCard : allDealtCards) {
                g2d.drawString("" + eachDealtCard.getNumber() + " [" + (double) Math.round((eachDealtCard.getFrequency() / 100d) * 10d) / 10d + "%], ", x, 50);
                x += 90;
            }
            drawGraph(g2d, "Dealt Cards", allDealtCards);
        } else {
            notificationListener.send("\n\nNo dealt card exists to peek!");
        }
    }

    private void drawForPeekRemovedCard(Graphics g2d) {
        if (allRemovedCards != null && allRemovedCards.size() > 0) {
            notificationListener.send("\n\nGetting removed cards...");
            int x = 5;
            int y = 250;
            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g2d.drawString("All Removed Cards from stack: " + allRemovedCards.get(0).getDiceNotation(), x, y);

            for (Card eachRemovedCard : allRemovedCards) {
                g2d.drawString("" + eachRemovedCard.getNumber() + " [" + (double) Math.round((eachRemovedCard.getFrequency() / 100d) * 10d) / 10d + "%], ", x, y + 40);
                x += 110;
            }
        } else {
            notificationListener.send("\n\nNo removed card exists to peek!");
        }
    }

    private void drawForPeekFutureCard(Graphics g2d) {
        if (futureCards != null && futureCards.size() > 0) {
            notificationListener.send("\n\nGetting furure cards with Graph...");
            int x = 5;
            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g2d.drawString("Future Cards from stack: " + futureCards.getFirst().getDiceNotation(), x, y);

            for (Card eachFutureCard : futureCards) {
                g2d.drawString("" + eachFutureCard.getNumber() + " [" + (double) Math.round((eachFutureCard.getFrequency() / 100d) * 10d) / 10d + "%], ", x, 50);
                x += 90;
            }
            drawGraph(g2d, "Future Cards", futureCards);
        } else {
            notificationListener.send("\n\nNo future cards exists left to peek!");
        }

    }

    private void drawGraph(Graphics g, String cardType, Collection<Card> stack) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 40, y = 100;

        //Y-Coordinate lines
        int s = y;
        for (int i = y; i > -10; i = i - 10) {
            g2d.drawString("" + (i), x - 10, s + 8);
            g2d.drawLine(x + 20, s, getWidth(), s);
            s += 40;
        }

        //X-Coordinate label
        g2d.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//        g2d.setColor(Color.decode("#371C00"));
        g2d.drawString(cardType + " (Card number)", 350, 550);

        //Y-Coordinate label
        AffineTransform t = new AffineTransform();
        t.rotate(Math.toRadians(-90));
        g2d.setFont(new Font("Times New Roman", Font.PLAIN, 20).deriveFont(t));
//        g2d.setColor(Color.decode("#371C00"));
        g2d.drawString("Chance of occurence (%)", x - 17, 380);

        //Bars
        double chartHeight = 400;
        double barWidth = 15;
        for (Card eachCard : stack) {
            double barHeight = (double) eachCard.getFrequency() / (double) Dice.ROLL_TIMES * 100 * 4d;
            double newY = chartHeight - barHeight;

            Rectangle2D bar = new Rectangle2D.Double(x + 50, newY + y, barWidth, barHeight);
            g2d.fill(bar);
            AffineTransform t1 = new AffineTransform();
            t.rotate(Math.toRadians(-90));
            g2d.setFont(new Font("Times New Roman", Font.ITALIC, 12).deriveFont(t1));
            g2d.drawString("" + eachCard.getNumber(), (float) x + 50, (float) chartHeight + 120);
            x += 30;
        }
    }

    @Override
    public void sendAllDealtCards(ArrayList allDealtCards) {
        this.allDealtCards = allDealtCards;
        this.repaint();
    }

    @Override
    public void sendSingleDealtCard(Card singleDealtCard) {
        this.singleDealtCard = singleDealtCard;
        this.repaint();
    }

    @Override
    public void sendRemovedCards(ArrayList allRemovedCards) {
        this.allRemovedCards = allRemovedCards;
        this.repaint();
    }

    @Override
    public void sendFutureCards(CardStack futureCards) {
        this.futureCards = futureCards;
        this.repaint();
    }

    public void addNotificationListener(NotificationListener notificationListener) {
        this.notificationListener = notificationListener;
    }
}
