/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph2;

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
public class Graph extends JFrame {

    int chartHeight = 300, width = 20;
    Integer data[] = {343, 333, 343, 333, 334, 334, 333, 333, 456, 333, 366, 333, 346};
    LinkedList<Integer> dummyData;
    Integer max;

    Graph() {
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chart");
        setLocationRelativeTo(null);

        dummyData = new LinkedList();
        dummyData.addAll(Arrays.asList(data));
        max = Collections.max(dummyData, null);

        getContentPane().add(new Canvas());
    }

    public static void main(String[] args) {
        new Graph().setVisible(true);
    }

    public class Canvas extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 35, y = 25, height, newY;

            g.drawLine(x - width, y, x - width, chartHeight + y);
            g.drawLine(x - width, chartHeight + y, 800, chartHeight + y);

            for (Integer eachData : dummyData) {
                height = chartHeight * eachData / max;
                newY = chartHeight - height + y;

                g.fillRect(x, newY, width, height);
                
                g.drawString("%", x, newY);
                g.drawString(""+eachData, x, chartHeight+y+12);
                
                x += 40;
            }
            AffineTransform ty = new AffineTransform();
            ty.rotate(Math.toRadians(-90));
            Font fy = new Font("Times New Roman", Font.BOLD, 12).deriveFont(ty);
            g.setFont(fy);
            g.drawString("Pecentage",10, (chartHeight + y) / 2);
        }

    }
}
