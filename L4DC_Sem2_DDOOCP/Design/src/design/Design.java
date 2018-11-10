/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class Design extends JFrame {

    JLabel lbl1, lbl2, lbl3;
    JTextField txt1;
    Font ft, ft1;

    public Design() {

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.yellow);

        setSize(300, 300);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        lbl1 = new JLabel(new ImageIcon("\\Images\\Login.png"));    
        lbl2 = new JLabel("HELLO WORLD");
        lbl3 = new JLabel("Hello World");
        
        txt1 = new JTextField();
        
        ft = new Font("Arial", Font.BOLD, 12);
        ft1 = new Font("Cambria", Font.BOLD, 12);

        lbl2.setFont(ft1);
        lbl3.setFont(ft);
        lbl3.setOpaque(true);
        lbl3.setBackground(Color.red);
        
        lbl1.setBounds(25, 25, 100, 25);
        lbl2.setBounds(25, 50, 100, 25);
        lbl3.setBounds(25, 75, 100, 25);
        txt1.setBounds(25, 140, 100, 25);

        txt1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
//
        c.add(lbl1);
        c.add(lbl2);
        c.add(lbl3);
        c.add(txt1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Design();
    }
}
