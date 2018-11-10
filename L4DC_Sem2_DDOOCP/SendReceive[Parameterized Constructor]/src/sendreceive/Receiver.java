/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendreceive;

import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class Receiver extends JFrame {

    JLabel lblName, lblAddress, lblBatch, lblSection;
    JTextField txtName, txtAddress, txtBatch, txtSection;

    public Receiver(String details[]) {

        setTitle("Receiver");
        setSize(280, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        lblName = new JLabel("Name");
        lblAddress = new JLabel("Address");
        lblBatch = new JLabel("Batch");
        lblSection = new JLabel("Section");
        txtName = new JTextField(details[0]);
        txtAddress = new JTextField(details[1]);
        txtBatch = new JTextField(details[2]);
        txtSection = new JTextField(details[3]);

        lblName.setBounds(25, 25, 80, 25);
        txtName.setBounds(125, 25, 80, 25);
        lblAddress.setBounds(25, 50, 80, 25);
        txtAddress.setBounds(125, 50, 80, 25);
        lblBatch.setBounds(25, 75, 80, 25);
        txtBatch.setBounds(125, 75, 80, 25);
        lblSection.setBounds(25, 100, 80, 25);
        txtSection.setBounds(125, 100, 80, 25);

        add(lblName);
        add(txtName);
        add(lblAddress);
        add(txtAddress);
        add(lblBatch);
        add(txtBatch);
        add(lblSection);
        add(txtSection);

        setVisible(true);

    }
}
