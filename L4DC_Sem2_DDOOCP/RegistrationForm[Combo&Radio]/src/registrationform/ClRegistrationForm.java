/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Biju Ale
 */
public class ClRegistrationForm extends JFrame {

    JPanel pnlMain, pnlGender, pnlCountry, pnlBtns;
    JTextField txtFirstName, txtLastName;
    ButtonGroup btnGender;
    JRadioButton rbtnMale, rbtnFemale;
    JComboBox<String> cboCountry;
    JButton btnRegister, btnExit;

    public ClRegistrationForm() {

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        setDefaultCloseOperation(3);
        setTitle("Registration Form");
        setResizable(false);

        txtFirstName = new JTextField(10);
        txtLastName = new JTextField(10);

        rbtnMale = new JRadioButton("Male", false);
        rbtnFemale = new JRadioButton("Female", true);

        btnGender = new ButtonGroup();
        btnGender.add(rbtnMale);
        btnGender.add(rbtnFemale);

        pnlGender = new JPanel();
        pnlGender.add(rbtnMale);
        pnlGender.add(rbtnFemale);
        pnlGender.setBorder(new TitledBorder("Select Gender"));

        cboCountry = new JComboBox<>();
        String[] countries = {"Romania", "Ukraine", "Istanbul", "Turkey", "Russia", "Nepal", "Denmark", "Norway", "France"};
        for (String EachCountry : countries) {
            cboCountry.addItem(EachCountry);
        }

        pnlCountry = new JPanel();
        pnlCountry.add(cboCountry);
        pnlCountry.setBorder(new TitledBorder("Select Country"));

        btnRegister = new JButton("Register");
        btnExit = new JButton("Exit");

        pnlBtns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBtns.add(btnRegister);
        pnlBtns.add(btnExit);

        pnlMain = new JPanel(new GridLayout(3, 2, 8, 8));
        pnlMain.setBorder(new EmptyBorder(10, 10, 10, 10)); //Padding
        pnlMain.add(new JLabel("First Name"));
        pnlMain.add(txtFirstName);
        pnlMain.add(new JLabel("Last Name"));
        pnlMain.add(txtLastName);
        pnlMain.add(pnlGender);
        pnlMain.add(pnlCountry);

//        Container c = this.getContentPane();
        c.add(pnlMain, BorderLayout.NORTH);
        c.add(pnlBtns, BorderLayout.SOUTH);

        txtFirstName.setBackground(Color.decode("#1DE9B6"));
        txtLastName.setBackground(Color.decode("#1DE9B6"));

        pack();
        setLocationRelativeTo(null);
    }
}
