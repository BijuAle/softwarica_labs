package calcsi;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CalcSI extends JFrame {
    //create TextFields for principal, rate and time

    private JTextField principal = new JTextField();
    private JTextField rate = new JTextField();
    private JTextField time = new JTextField();
    private JTextField simpleInterest = new JTextField();
    // calculate JButton
    private JButton clear = new JButton("Clear");
    private JButton calculate = new JButton("Calculate");
    //private JButton clear = new JButton("Clear");
//    //create JTextArea
//    JTextArea area = new JTextArea(1, 1);

    public CalcSI() {
        // panel panel to hold labels and text fields
        JPanel panel1 = new JPanel(new GridLayout(4, 2));
        panel1.add(new JLabel("Enter Principal"));
        panel1.add(principal);
        panel1.add(new JLabel("Enter Rate"));
        panel1.add(rate);
        panel1.add(new JLabel("Enter Time"));
        panel1.add(time);
        panel1.add(new JLabel("Simple Interest"));
        panel1.add(simpleInterest);
        panel1.setBorder(new TitledBorder("Enter Principal, Rate (as decimal e.g 0.1 for 10%) and Time."));

        principal.setBorder(BorderFactory.createEtchedBorder());
        rate.setBorder(BorderFactory.createEtchedBorder());
        time.setBorder(BorderFactory.createEtchedBorder());
        simpleInterest.setBorder(BorderFactory.createEtchedBorder());
        simpleInterest.setEditable(false);
        simpleInterest.setForeground(Color.RED);

        // Panel p2 to hold the button
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        //panel2.add(clear);
        panel2.add(clear);
        panel2.add(calculate);

        // Add the panels to the frame
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

//        area.setForeground(Color.BLACK);
//        area.setBackground(Color.WHITE);
//        area.setLineWrap(true);
//        area.setWrapStyleWord(true);
//        area.setEditable(false);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from text fields
                try {
                    double amount = Double.parseDouble(principal.getText());
                    double rateOfInterest = Double.parseDouble(rate.getText());
                    double year = Double.parseDouble(time.getText());

                    String interest = "" + (amount * rateOfInterest * year);
                    // Display simple interest
                    simpleInterest.setText((interest));
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(rootPane, "ERROR: " + (f.getMessage()));
                }

                String amountField = principal.getText();
                String rateOfInterestField = rate.getText();
                String yearField = time.getText();

                if (e.getSource() == calculate) {

                    if ("".equals(amountField) || "".equals(rateOfInterestField) || "".equals(yearField)) {
                        String emptyFieldWarning;
                        emptyFieldWarning = "One or more fields is/are empty!";
                        JOptionPane.showMessageDialog(rootPane, emptyFieldWarning);
                    }
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from text fields
                try {
                    principal.setText("");
                    rate.setText("");
                    time.setText("");
                    simpleInterest.setText("");
                } catch (Exception f) {
                }
            }
        });
    }
    //create main method to run application

    public static void main(String[] args) {

        CalcSI calculator = new CalcSI();
        calculator.setSize(360, 200);
        calculator.setTitle(" Simple Interest Calculator ");
      //  calculator.setResizable(false);
        calculator.setVisible(true);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setLocationRelativeTo(null);
    }
}
