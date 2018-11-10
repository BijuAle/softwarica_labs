/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgets;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Biju Ale
 */
public class PanelTransactions extends JPanel implements ActionListener {

    JButton btnNew, btnEdit, btnDelete, btnTrigger;
    JTable tableTransaction;
    JScrollPane scrollPane; //Scroll bar 
    boolean isFormOpen; //Form is open or not? True or False
    FormTransaction frmTransaction;

    PanelTransactions() {
        setLayout(new FlowLayout());

        btnNew = new JButton("New");
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnTrigger = new JButton("New Trigger");

        //Blank table initiation
        String[] columnHeadings = {"DATE", "DESCRIPTION", "AMOUNT", "TRANSACTION TYPE"};

        //Making table anonymous class to override isCellEditable method to false so that cell data is locked
        tableTransaction = new JTable(new DefaultTableModel(columnHeadings, 20)) {
            @Override
            public boolean isCellEditable(int data, int column) {
                return false;
            }
        };

        tableTransaction.setPreferredScrollableViewportSize(new Dimension(500, 500)); //Size that shows before scroll bar appears
        tableTransaction.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tableTransaction);

        btnNew.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnTrigger.addActionListener(this);

        add(btnNew);
        add(btnEdit);
        add(btnDelete);
        add(scrollPane);

        setVisible(true);
        frmTransaction = new FormTransaction();
        isFormOpen = false;

        //Anonymous class to override close operation. New button click garda ek choti matra form khulos. If feri new click garyo bhane 2 wota form khuldaina. Tesko lagi ho yo.
        frmTransaction.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frmTransaction.setVisible(false);
                frmTransaction.dispose();
                isFormOpen = false;
            }
        });

        //Load file's data & load to table
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSource = (JButton) e.getSource();

        if (btnSource.equals(btnNew) & ((isFormOpen == false))) {
            frmTransaction.btnReset.doClick(); //Reset all fields
            frmTransaction.setVisible(true);
            isFormOpen = true;
        }
    }

    public JTable getTableTransaction() {
        return tableTransaction;
    }
}
