/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgets;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Biju Ale
 */
public class MainGUI extends JFrame {

    JTabbedPane tabbedPane;
    PanelTransactions pnlTransactions;
    PanelTrigger pnlTrigger;

    PanelNetSummary pnlNetSummary;

    MainGUI() {

        //STATES (Define components that will be added to the Main GUI)
        tabbedPane = new JTabbedPane();
        pnlTransactions = new PanelTransactions();
        pnlNetSummary = new PanelNetSummary(pnlTransactions);//
        pnlTrigger = new PanelTrigger();

        Container c = getContentPane();

        setTitle("Home Budgetting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 600);
        setLocationRelativeTo(null);
        c.setLayout(new BorderLayout());

        tabbedPane.addTab("Transactions", pnlTransactions);
        tabbedPane.addTab("Trigger", (JPanel) pnlTrigger);

        c.add(tabbedPane, BorderLayout.CENTER);
        c.add(pnlNetSummary, BorderLayout.PAGE_END);

        setVisible(true);
    }

    public static void main(String[] args) {
        MainGUI myMainGUI = new MainGUI();
    }
}
