/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dualform;

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
public class Send extends JFrame implements ActionListener {

    JLabel lblName;
    JTextField txtName;
    JButton btnSend;
    String Send;

    public Send() {
        setTitle("Sender");
        setSize(300, 150);
        setLayout(null);
        setDefaultCloseOperation(3);

        lblName = new JLabel("Input Name");
        txtName = new JTextField();
        btnSend = new JButton("Send");

        lblName.setBounds(25, 25, 100, 25);
        txtName.setBounds(125, 25, 100, 25);
        btnSend.setBounds(25, 80, 80, 25);

        add(lblName);
        add(txtName);
        add(btnSend);

        btnSend.addActionListener(this);
    }

    public static void main(String[] args) {
        Send ObjSend = new Send();
        ObjSend.setVisible(true);

        //Receive ObjReceive = new Receive(Send);
        //ObjReceive.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnSource = (JButton) e.getSource();

        if (btnSource.equals(btnSend)) {
            Send = txtName.getText();
            dispose();
            Receive ObjReceive = new Receive(Send);
            ObjReceive.setVisible(true);

        }
    }

}
