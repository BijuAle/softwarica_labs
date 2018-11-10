/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logingui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class LoginGUI {

    public static void main(String[] args) {

        JFrame jf = new JFrame();
        Container c = jf.getContentPane();
        c.setLayout(new FlowLayout());

        JLabel lblUsername = new JLabel("Username");
        JTextField txtUsername = new JTextField(15);
        JLabel lblPassword = new JLabel("Password");
        JPasswordField txtPassword = new JPasswordField(15);
        JButton btnLogin = new JButton("Login");
        JButton btnClose = new JButton("Close");

        jf.setTitle("Login");
        jf.setSize(280, 150);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        c.add(lblUsername);
        c.add(txtUsername);
        c.add(lblPassword);
        c.add(txtPassword);
        c.add(btnLogin);
        c.add(btnClose);

    }

}
