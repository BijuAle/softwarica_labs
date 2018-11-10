/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class ClLoginForm extends JFrame implements ActionListener {

    JLabel lblUsername, lblPassword;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin, btnClose, btnClear;

    public ClLoginForm() {
        Container c = getContentPane();
        c.setLayout(null);

        setTitle("Login Verification");
        setDefaultCloseOperation(3);
        setSize(300, 200);
        setLocationRelativeTo(null);

        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        btnClose = new JButton("Close");
        btnClear = new JButton("Clear");

        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
        btnClose.addActionListener(this);

        lblUsername.setBounds(25, 25, 100, 25);
        txtUsername.setBounds(125, 25, 100, 25);
        lblPassword.setBounds(25, 65, 100, 25);
        txtPassword.setBounds(125, 65, 100, 25);
        btnLogin.setBounds(25, 115, 70, 25);
        btnClose.setBounds(110, 115, 70, 25);
        btnClear.setBounds(195, 115, 70, 25);

        c.add(lblUsername);
        c.add(txtUsername);
        c.add(lblPassword);
        c.add(txtPassword);
        c.add(btnLogin);
        c.add(btnClose);
        c.add(btnClear);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();

        if (btnSource.equals(btnLogin)) {
            if (txtUsername.getText() != "" && txtUsername.getText() != null) {

                if ((txtUsername.getText().equals("admin")) && txtPassword.getPassword().length == 5
                        && (txtPassword.getPassword()[0]) == 'H'
                        && (txtPassword.getPassword()[1]) == 'e'
                        && (txtPassword.getPassword()[2]) == 'l'
                        && (txtPassword.getPassword()[3]) == 'l'
                        && (txtPassword.getPassword()[4]) == 'o') {

                    JOptionPane.showMessageDialog(null, "Welcome!");

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
                    txtUsername.selectAll();
                    txtUsername.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter username!");
                txtUsername.requestFocus();
            }

        } else if (btnSource.equals(btnClose)) {
            System.exit(EXIT_ON_CLOSE);
        } else if (btnSource.equals(btnClear)) {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }

    public static void main(String[] args) {
        ClLoginForm obj = new ClLoginForm();
        obj.setVisible(true);
    }

}
