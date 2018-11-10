/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 *
 * @author Biju Ale
 */
public class Graph extends JFrame {

    public ArrayList cardStack;
    Card seven, eight, nine, ten, eleven;
    int xDiff = 20;

    Graph() {
        setTitle("Graph Demo");
        setSize(580, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().add(new Canvas());

        cardStack = new ArrayList();

        seven = new Card(7, 55.5);
        eight = new Card(8, 45.5);
        nine = new Card(9, 33.5);
        ten = new Card(10, 23.5);
        eleven = new Card(1, 28.5);

        cardStack.add(seven);
        cardStack.add(eight);
        cardStack.add(nine);
        cardStack.add(ten);
        cardStack.add(eleven);
    }

    public class Canvas extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics g2d = (Graphics2D) g;
            g2d.setColor(Color.red);

            //Line2D xAxis = new Line2D(80, 80, 80, 400);
            //Line2D yAxis = new Line2D(80, 400, 480, 400);
            g2d.drawLine(80, 80, 80, 400);
            g2d.drawLine(80, 400, 480, 400);

            //Rectangle2D bar1 = new Rectangle2D.Double(120, 200, 10, 200);
            for (int i = 0; i < cardStack.size(); i++) {
                Card current = (Card) cardStack.get(i);
                g2d.fillRect(xDiff, (int) current.getFrequency(), 40, 400 - (int) current.getFrequency());
                xDiff += 25;
                // i=5;
            }

        }

    }

    public static void main(String[] args) {
        new Graph().setVisible(true);

    }
}
