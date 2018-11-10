
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NCC
 */
public class LoginClass {

    JFrame jf;
    JLabel lblUsername;
    JTextField txtUsername;
    JLabel lblPassword;
    JTextField txtPassword;
    JButton btnLogin;

    FlowLayout layout;

   public LoginClass() {

        jf = new JFrame();
        lblUsername = new JLabel("Username");
        txtUsername = new JTextField(10);
        lblPassword = new JLabel("Password");
        txtPassword = new JTextField(10);
        btnLogin = new JButton("Login");

        layout = new FlowLayout();

        jf.setTitle("Login");
        jf.setSize(230, 150);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(layout);

        jf.add(lblUsername);
        jf.add(txtUsername);
        jf.add(lblPassword);
        jf.add(txtPassword);
        jf.add(btnLogin);

        jf.setVisible(true);
    }
    
}


