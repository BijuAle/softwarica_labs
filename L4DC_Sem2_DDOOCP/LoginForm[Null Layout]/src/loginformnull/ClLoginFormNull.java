/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginformnull;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class ClLoginFormNull extends JFrame {

    JLabel lblUsername, lblPassword;
    JTextField txtUsername, txtPassword;
    JButton btnLogin, btnExit;

    public ClLoginFormNull() {

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#1DE9B6"));

        setTitle("Login Form");
        setDefaultCloseOperation(3);
        setSize(200, 260);

        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");

        txtUsername = new JTextField(10);
        txtPassword = new JTextField(10);

        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");

        lblUsername.setBounds(25, 25, 100, 25);
        txtUsername.setBounds(25, 55, 100, 25);
        lblPassword.setBounds(25, 85, 100, 25);
        txtPassword.setBounds(25, 115, 100, 25);
        btnLogin.setBounds(25, 185, 70, 25);
        btnExit.setBounds(110, 185, 70, 25);

        c.add(lblUsername);
        c.add(txtUsername);
        c.add(lblPassword);
        c.add(txtPassword);
        c.add(btnLogin);
        c.add(btnExit);

        //pack();
        setLocationRelativeTo(null);

    }
}
