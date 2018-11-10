/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Biju Ale
 */
public class MainGUI extends JFrame implements ActionListener {

    //Declare components you need
    JButton btnCheckFav, btnShowAllFav;

    MainGUI() {

        //Set Frame settings
        setTitle("Which number does Joe like?");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        //Create objects/Instantiate declared objects
        btnCheckFav = new JButton("Check if Joe likes the no. you enter");
        btnShowAllFav = new JButton("Show list of all Joe' favourite no.");

        //Add action listener to components
        btnCheckFav.addActionListener(this);
        btnShowAllFav.addActionListener(this);

        //Add components to container
        Container c = getContentPane();
        c.add(btnCheckFav);
        c.add(btnShowAllFav);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();
        if (btnSource == btnCheckFav) {
        } else if (btnSource == btnShowAllFav) {
        }
    }

}
