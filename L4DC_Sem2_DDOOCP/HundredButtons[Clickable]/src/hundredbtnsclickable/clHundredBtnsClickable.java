/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundredbtnsclickable;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Biju Ale
 */
public class clHundredBtnsClickable extends JFrame implements ActionListener {

    JButton[][] AllButtons;
    JLabel lblClickstatus;
    static int i, j = 0;

    public clHundredBtnsClickable() {

        setTitle("Hundred Buttons Clickable!");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(580, 410);
        setLocationRelativeTo(null);

        AllButtons = new JButton[10][10];
        for (int rowIndex = i; rowIndex < 10; rowIndex++) {
            for (int columnIndex = j; columnIndex < 10; columnIndex++) {
                AllButtons[rowIndex][columnIndex] = new JButton(rowIndex + "," + columnIndex);
                add(AllButtons[rowIndex][columnIndex]);
                AllButtons[rowIndex][columnIndex].addActionListener(this);
            }
        }
        lblClickstatus = new JLabel();
        lblClickstatus.setForeground(Color.red);
        lblClickstatus.setFont(new Font("Serif", Font.PLAIN, 40));
        add(lblClickstatus);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();
        for (int rowIndex = i; rowIndex < 10; rowIndex++) {
            for (int columnIndex = j; columnIndex < 10; columnIndex++) {
                if (btnSource.equals(AllButtons[rowIndex][columnIndex])) {
                    lblClickstatus.setText("You clicked " + rowIndex + "," + columnIndex);

                }
            }
        }
    }

}
