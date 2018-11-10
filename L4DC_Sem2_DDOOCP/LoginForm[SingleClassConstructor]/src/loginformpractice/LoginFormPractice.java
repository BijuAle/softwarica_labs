/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginformpractice;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class LoginFormPractice {

    private JFrame jf;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JTextField txtPassword;
    private JButton btnLogin;

    FlowLayout layout;

    public LoginFormPractice() {

        jf = new JFrame("Login");
        lblUsername = new JLabel("Username");
        txtUsername = new JTextField(10);
        lblPassword = new JLabel("Password");
        txtPassword = new JTextField(10);
        btnLogin = new JButton("Login");
        layout = new FlowLayout();

        jf.setSize(230, 130);
        jf.setLayout(layout);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        jf.add(lblUsername);
        jf.add(txtUsername);
        jf.add(lblPassword);
        jf.add(txtPassword);
        jf.add(btnLogin);

        jf.setVisible(true);

    }

    public static void main(String[] args) {
        LoginFormPractice lg = new LoginFormPractice();
    }
}
