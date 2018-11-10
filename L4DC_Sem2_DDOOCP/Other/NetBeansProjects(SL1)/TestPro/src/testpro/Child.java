/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testpro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author NCC
 */
public class Child extends JFrame{
    Ellipse2D ed;
    Mypanel mp;
    Container c;
Child()
{
    setLayout(null);
    mp=new Mypanel();
    c=getContentPane();
    //c.setBackground(Color.GREEN);
    c.add(mp);
    setSize(400,400);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    for(int i=0; i<=30;i++)
    {
        mp.repaint();
    }
}
private class Mypanel extends JPanel {
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
       Graphics2D gd=(Graphics2D)g;
       gd.setColor(Color.RED);
       ed=new Ellipse2D.Double(100, 100, 40, 40);
       gd.fill(ed);
    }
}
   
    public static void main(String[] args) {
        new Child();
    }
    
}
