/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdemo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Biju Ale
 */
public class GraphDemo extends JFrame {

    LinkedList<Integer> data;
    int chartHeight = 500;
    Integer max;

    public GraphDemo() {

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);

        Integer dummyData[] = {652, 987, 236, 459, 56, 567, 567, 765, 34, 234,234,34,45,567,3};

        data = new LinkedList<>();
        data.addAll(Arrays.asList(dummyData));
        max = Collections.max(data, null);

        getContentPane().add(new MyPanel());
    }

    public static void main(String[] args) {
        new GraphDemo().setVisible(true);
    }

    public class MyPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 35;
            int y = 25;
            int sum = 0;

            for (Integer i : data) {
                sum += i;
            }
            System.out.println(sum);
            for (Integer i : data) {

                int height = chartHeight * i / max;
//                int height = i / max * chartHeight;
                int width = 20;
                int newY = chartHeight - height + y;
                g.drawString((double) (100 * i / sum) + "%", x, newY - 9);
                g.fillRect(x, newY, width, height);
                x += 40;

            }

            AffineTransform transform = new AffineTransform();
            transform.rotate(Math.toRadians(-90));
            Font ft = new Font("Arial", Font.BOLD, 20).deriveFont(transform);

            g.setFont(ft);
            g.drawString("Percentage", 8, 250);

        }

    }
}
