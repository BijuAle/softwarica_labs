/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcsumdiff;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class CalcSumDiff extends JFrame implements ActionListener {

    FlowLayout layout;
    JLabel lblFirstnum;
    JTextField txtFirstnum;
    JLabel lblSecondnum;
    JTextField txtSecondnum;
    JButton btnSum;
    JButton btnDiff;

    //Difference button:
    /*JButton btnDiff = new JButton(new AbstractAction("Difference") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(txtFirstnum.getText());
            int num2 = Integer.parseInt(txtSecondnum.getText());

            int diff = num1 - num2;
            JOptionPane.showMessageDialog(null, num1 + "  -  " + num2 + "  =  " + diff);
        }
    });*/
    CalcSumDiff() {
        layout = new FlowLayout();
        lblFirstnum = new JLabel("Enter first number.");
        txtFirstnum = new JTextField(5);
        lblSecondnum = new JLabel("Enter second number.");
        txtSecondnum = new JTextField(5);
        btnDiff = new JButton("Difference");
        btnSum = new JButton("Sum");

        super.setLayout(layout);
        super.setTitle("Sum");
        super.setSize(250, 140);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);

        super.add(lblFirstnum);
        super.add(txtFirstnum);
        super.add(lblSecondnum);
        super.add(txtSecondnum);
        super.add(btnSum);
        super.add(btnDiff);

        btnSum.addActionListener(this);
        btnDiff.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        int num1 = Integer.parseInt(txtFirstnum.getText());
        int num2 = Integer.parseInt(txtSecondnum.getText());

        if (btn.equals(btnSum)) {
            int sum = num1 + num2;
            JOptionPane.showMessageDialog(null, num1 + "  +  " + num2 + "  =  " + sum);

        } else if (btn.equals(btnDiff)) {
            int diff = num1 - num2;
            JOptionPane.showMessageDialog(null, num1 + "  -  " + num2 + "  =  " + diff);
        }

    }

}
