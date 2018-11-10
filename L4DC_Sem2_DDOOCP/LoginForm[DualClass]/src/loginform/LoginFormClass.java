/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class LoginFormClass extends JFrame {

    JTextField txtUsername, txtPassword;
    JButton btnLogin, btnExit;

    LoginFormClass() {

        txtUsername = new JTextField(10);
        txtPassword = new JTextField(10);
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");

        setTitle("Authentication");
        setSize(220, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        add(new JLabel("Username"));
        add(txtUsername);
        add(new JLabel("Password"));
        add(txtPassword);
        add(btnLogin);
        add(btnExit);

    }
}
