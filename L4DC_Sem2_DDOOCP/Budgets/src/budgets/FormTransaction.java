/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgets;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Biju Ale
 */
public class FormTransaction extends JFrame implements ActionListener { //Form ma button cha so button halna saath Action Listener halne. Formle pani JFrame kai property inherit garcha.

    //STATES. Form ko states bhaneko form ma add hune components.
    JTextField txtDate, txtDescription, txtAmount;
    ButtonGroup transactionType;
    JRadioButton rdoIncome, rdoExpense;
    JButton btnSubmit, btnReset;

    FormTransaction() {

        setTitle("Add new Transaction");
        setAlwaysOnTop(true); //Always displays above all window. Unless form is closed other windows cannot be accessed.
        setSize(330, 240);
        setLayout(new GridLayout(6, 2));

        txtDate = new JTextField(10);
        txtDate.setText(getCurrentDate());

        txtDescription = new JTextField(10);
        txtAmount = new JTextField(10);
        rdoIncome = new JRadioButton("Income");
        rdoExpense = new JRadioButton("Outcome (Expense)");
        transactionType = new ButtonGroup();
        transactionType.add(rdoIncome);
        transactionType.add(rdoExpense);

        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);

        Container c = getContentPane();
        c.add(new JLabel("Date"));
        c.add(txtDate);
        c.add(new JLabel("Description"));
        c.add(txtDescription);
        c.add(new JLabel("Amount"));
        c.add(txtAmount);
        c.add(new JLabel("Transaction Type"));
        c.add(rdoIncome);
        c.add(new JLabel(""));
        c.add(rdoExpense);
        c.add(btnReset);
        c.add(btnSubmit);

        setLocationRelativeTo(null); //Position the form to center of screen when it displays.
    }

    String getCurrentDate() { //This behavior returns current date and throws it in Date textfield
        LocalDate localDate = LocalDate.now();
        return (DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate));
    }

    @Override //Button click bhae pachi ke kaam garne. Remember GUI ko arko behavior is ActionListener ko method.
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();

        if (btnSource.equals(btnSubmit)) {

        } else if (btnSource.equals(btnReset)) {
            txtDate.setText(getCurrentDate());
            txtDescription.setText("");
            txtAmount.setText("");
        }
    }

    String getSelectedTransactionType() { //This method returns kun radio button select bhayo
        for (Enumeration<AbstractButton> buttons = transactionType.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
