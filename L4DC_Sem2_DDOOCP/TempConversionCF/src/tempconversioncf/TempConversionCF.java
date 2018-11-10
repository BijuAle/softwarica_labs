/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempconversioncf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class TempConversionCF extends JFrame implements ActionListener {

    private JPanel panel1;
    private JTextField txtInput;
    private JButton btnCelcius, btnFarhenheit, btnReset;
    private JLabel lblOutput;

    public TempConversionCF() {

        panel1 = new JPanel(new GridLayout(4, 1, 1, 4));
        txtInput = new JTextField(10);
        btnCelcius = new JButton("to Celcius");
        btnFarhenheit = new JButton("to Fahrenheit");
        btnReset = new JButton("Reset");
        lblOutput = new JLabel();

        setLayout(new FlowLayout());
        setSize(210, 200);
        setTitle("Conversion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel1.setBorder(BorderFactory.createEtchedBorder());

        add(panel1, BorderLayout.CENTER);

        panel1.add(txtInput);
        panel1.add(btnCelcius);
        panel1.add(btnFarhenheit);
        panel1.add(btnReset);
        add(lblOutput);

        btnCelcius.addActionListener(this);
        btnFarhenheit.addActionListener(this);
        btnReset.addActionListener(this);

        lblOutput.setFont(new Font("Seriff", Font.ITALIC, 20));
        lblOutput.setForeground(Color.BLUE);
        txtInput.setHorizontalAlignment(JTextField.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();
        double result;
        try {
            if (btnSource.equals(btnCelcius)) {
                result = Math.round((toCelcius(Double.parseDouble(txtInput.getText()))));
                lblOutput.setText(txtInput.getText() + "F " + "= " + result + "C");
                txtInput.selectAll();
                txtInput.requestFocus();
            } else if (btnSource.equals(btnFarhenheit)) {
                result = Math.round(toFarenheit(Double.parseDouble(txtInput.getText())));
                lblOutput.setText(txtInput.getText() + "C" + "= " + result + "F");
                txtInput.selectAll();
                txtInput.requestFocus();
            } else if (btnSource.equals(btnReset)) {
                txtInput.setText("");
                lblOutput.setText("");
                txtInput.requestFocus();
            }

        } catch (Exception f) {
            JOptionPane.showMessageDialog(null, f.getMessage());
            txtInput.requestFocus();
        }
    }

    double toFarenheit(double celcius) {
        // double farenheit = (9/5)(celcius)+32;
        double farenheit = ((9 / 5.0) * celcius) + 32;
        return farenheit;
    }

    double toCelcius(double farenheit) {
        // double celcius = (5/9)(farenheit-32);
        double celcius = (5 / 9.0) * (farenheit - 32);
        return celcius;
    }

}
