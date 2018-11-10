/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgets;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Biju Ale
 */
public class PanelNetSummary extends JPanel {

    JLabel incomeHome, incomePersonal, outcomeHome, outcomePersonal, netIncomeHome, netIncomePersonal;
    PanelTransactions pnlTransaction;

    PanelNetSummary(PanelTransactions pnlTransaction) {
        this.pnlTransaction = pnlTransaction;

        setLayout(new GridLayout(4, 3));

        incomeHome = new JLabel("");
        outcomeHome = new JLabel("");

        incomePersonal = new JLabel(Double.toString(sumIncomePersonal()));
        outcomePersonal = new JLabel(Double.toString(sumOutcomePersonal()));

        netIncomeHome = new JLabel("");
        netIncomePersonal = new JLabel(Double.toString(sumIncomePersonal() - sumOutcomePersonal()));

        add(new JLabel(""));
        add(new JLabel("Home (Aggregated)"));
        add(new JLabel("Personal"));

        add(new JLabel("Income"));
        add(incomeHome);
        add(incomePersonal);

        add(new JLabel("Outcome/Expense"));
        add(outcomeHome);
        add(outcomePersonal);

        add(new JLabel("Net Income"));
        add(netIncomeHome);
        add(netIncomePersonal);

    }

    double sumIncomePersonal() {
        return 0; //Ahile lai estai chodeu. (Just know that you class ko behavior ma calculation ni parcha)
    }

    double sumOutcomePersonal() {
        return 0;//Ahile lai estai chodeu. (Just know that you class ko behavior ma calculation ni parcha)
    }

    double sumIncomeHome() {
        return 0;//Ahile lai estai chodeu. (Just know that you class ko behavior ma calculation ni parcha)
    }

    double sumOutcomeHome() {
        return 0;//Ahile lai estai chodeu. (Just know that you class ko behavior ma calculation ni parcha)
    }
}
