/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class CalcClass extends JFrame implements ActionListener {

    JLabel lblNum1;
    JTextField txtNum1;
    JLabel lblNum2;
    JTextField txtNum2;
    JButton btnSum;
    JButton btnDiff;
    JButton btnProd;
    JButton btnDiv;
    JButton btnMod;
    JLabel lblResult;

    public CalcClass() {
        setTitle("Two number calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 200);

        lblNum1 = new JLabel("Enter first number.");
        txtNum1 = new JTextField(10);

        lblNum2 = new JLabel("Enter second number.");
        txtNum2 = new JTextField(10);

        btnSum = new JButton("Sum");
        btnDiff = new JButton("Difference");
        btnProd = new JButton("Product");
        btnDiv = new JButton("Division");
        btnMod = new JButton("Modulus");

        add(lblNum1);
        add(txtNum1);
        add(lblNum2);
        add(txtNum2);
        add(btnSum);
        add(btnDiff);
        add(btnProd);
        add(btnDiv);
        add(btnMod);

        btnSum.addActionListener(this);
        btnDiff.addActionListener(this);
        btnProd.addActionListener(this);
        btnDiv.addActionListener(this);
        btnMod.addActionListener(this);

        lblResult = new JLabel();
        lblResult.setForeground(Color.red);
        lblResult.setFont(new Font("Serif", Font.PLAIN, 40));
        add(lblResult);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnSource = (JButton) e.getSource();
        double num1 = Double.parseDouble(txtNum1.getText());
        double num2 = Double.parseDouble(txtNum2.getText());

        if (btnSource.equals(btnSum)) {
            lblResult.setText("Sum = " + calcSum(num1, num2));
        } else if (btnSource.equals(btnDiff)) {
            lblResult.setText("Difference = " + calcDiff(num1, num2));
        } else if (btnSource.equals(btnProd)) {
            lblResult.setText("Product = " + calcProd(num1, num2));
        } else if (btnSource.equals(btnDiv)) {
            lblResult.setText("Division = " + calcDiv(num1, num2));
        } else if (btnSource.equals(btnMod)) {
            lblResult.setText("Modulus = " + calcMod(num1, num2));
        }

    }

    public double calcSum(double num1, double num2) {
        double sum = num1 + num2;
        return sum;
    }

    public double calcDiff(double num1, double num2) {
        double diff = num1 - num2;
        return diff;
    }

    public double calcProd(double num1, double num2) {
        double prod = num1 * num2;
        return prod;
    }

    public double calcDiv(double num1, double num2) {
        double div = num1 / num2;
        return div;
    }

    public double calcMod(double num1, double num2) {
        double mod = num1 % num2;
        return mod;
    }
}
