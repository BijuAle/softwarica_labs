/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendreceive;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class Sender extends JFrame implements ActionListener {

    JLabel lblName, lblAddress, lblBatch, lblSection;
    JTextField txtName, txtAddress, txtBatch, txtSection;
    JButton btnSend;
    String[] details = new String[4];

    public Sender() {

        setTitle("Sender");
        setSize(280, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        lblName = new JLabel("Name");
        lblAddress = new JLabel("Address");
        lblBatch = new JLabel("Batch");
        lblSection = new JLabel("Section");
        txtName = new JTextField();
        txtAddress = new JTextField();
        txtBatch = new JTextField();
        txtSection = new JTextField();
        btnSend = new JButton("Send");

        lblName.setBounds(25, 25, 80, 25);
        txtName.setBounds(125, 25, 80, 25);
        lblAddress.setBounds(25, 50, 80, 25);
        txtAddress.setBounds(125, 50, 80, 25);
        lblBatch.setBounds(25, 75, 80, 25);
        txtBatch.setBounds(125, 75, 80, 25);
        lblSection.setBounds(25, 100, 80, 25);
        txtSection.setBounds(125, 100, 80, 25);
        btnSend.setBounds(125, 125, 80, 25);

        btnSend.addActionListener(this);

        add(lblName);
        add(txtName);
        add(lblAddress);
        add(txtAddress);
        add(lblBatch);
        add(txtBatch);
        add(lblSection);
        add(txtSection);
        add(btnSend);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Sender();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnSource = (JButton) e.getSource();

        if (btnSource.equals(btnSend)) {
            details[0] = txtName.getText();
            details[1] = txtAddress.getText();
            details[2] = txtBatch.getText();
            details[3] = txtSection.getText();

            new Receiver(details);
            dispose();
        }

    }

}
