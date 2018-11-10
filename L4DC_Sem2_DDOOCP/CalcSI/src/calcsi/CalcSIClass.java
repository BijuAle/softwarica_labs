/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcsi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Biju Ale
 */
public class CalcSIClass extends JFrame implements ActionListener {

    private JTextField txtP, txtT, txtR;
    private JButton btnCalculate, btnReset;
    private JLabel lblResult;

    public CalcSIClass() {

        JPanel panel1 = new JPanel(new GridLayout(4, 2));
        panel1.setBorder(new TitledBorder("Enter the values & press 'Calculate'"));

        txtP = new JTextField(10);
        txtT = new JTextField(10);
        txtR = new JTextField(10);
        lblResult = new JLabel();

        btnCalculate = new JButton("Calculate");
        btnReset = new JButton("Reset");

        setTitle("SI calculator");
        setSize(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
//        setLayout(new FlowLayout());

        add(panel1, BorderLayout.CENTER);
        panel1.add(new JLabel("Principle (P)"));
        panel1.add(txtP);
        panel1.add(new JLabel("Time (year)"));
        panel1.add(txtT);
        panel1.add(new JLabel("Annual Rate (%)"));
        panel1.add(txtR);
        panel1.add(new JLabel("Simple Interest (SI)"));

        panel1.add(lblResult);
        lblResult.setFont(new Font("Seriff", Font.PLAIN, 20));
        lblResult.setForeground(Color.blue);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel2, BorderLayout.SOUTH);
        panel2.add(btnCalculate);
        panel2.add(btnReset);

        btnCalculate.addActionListener(this);
        btnReset.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnSource = (JButton) e.getSource();

        try {

            if (btnSource.equals(btnCalculate)) {

                double P = Double.parseDouble(txtP.getText());
                double T = Double.parseDouble(txtT.getText());
                double R = Double.parseDouble(txtR.getText());
                double SI;

                SI = calcSI(P, T, R);
                lblResult.setText(SI + "");

            } else if (btnSource.equals(btnReset)) {
                txtP.setText("");
                txtT.setText("");
                txtR.setText("");
                lblResult.setText("");
                txtP.requestFocus();
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(null, f.getMessage());
            txtP.requestFocus();
        }

    }

    public double calcSI(double P, double T, double R) {
        double SI = (P * T * R) / 100;
        return SI;
    }
}
