/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dualform;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Biju Ale
 */
public class Receive extends JFrame {

    JLabel lbl1;
    JLabel lblReceive;

    public Receive(String Receive) {

        setDefaultCloseOperation(3);
        setSize(200, 100);
        setLayout(null);
        setTitle("Receive");

        lbl1 = new JLabel("My name is ");
        lblReceive = new JLabel(Receive);

        lbl1.setBounds(25, 25, 100, 25);
        lblReceive.setBounds(125, 25, 100, 25);

        add(lbl1);
        add(lblReceive);
    }

}
