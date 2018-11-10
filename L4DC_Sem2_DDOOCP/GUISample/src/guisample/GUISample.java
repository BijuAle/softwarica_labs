package guisample;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Biju Ale
 */
public class GUISample extends JFrame {  //extends le JFrame ko power(properties) GUISample ma inherit garcha

    //States (Components that will be added to JFrame)
    JTabbedPane tabbedPane;
    PanelTransactions pnlTransactions; //Made in another class - Java file
    PanelTrigger pnlTrigger;//Made in another class - Java file
    PanelNetSummary pnlNetSummary;//Made in another class

    GUISample() {//This is a constructor, one of the behaviors

        //All these are instantiations of objects/states declared above.
        tabbedPane = new JTabbedPane();
        pnlNetSummary = new PanelNetSummary();
        pnlTransactions = new PanelTransactions();
        pnlTrigger = new PanelTrigger();

        Container c = getContentPane();//Yo Frame ko KAGAJ photo frame ko jastai. Aba sabai component "c" bhanne kagaj ma halne

        //Setting JFrame properties
        setTitle("Home Budgetting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 600);
        setLocationRelativeTo(null);
        c.setLayout(new BorderLayout());

        //Adding panels to the tab (Example adding youtube window to youtube tab. Here two windows/panels are added)
        tabbedPane.addTab("Transactions", (JPanel) pnlTransactions);
        tabbedPane.addTab("Trigger", (JPanel) pnlTrigger);

        c.add(tabbedPane, BorderLayout.CENTER);//Sabai tab ra rab bhitra ko window lai center ma
        c.add((JPanel) pnlNetSummary, BorderLayout.PAGE_END); //Tyo summary wala section chai muni fixed

        setVisible(true);//Important code
    }

    public static void main(String[] args) { // Another meethod/behavior that launches the JFrame(calls constructor with new keyword)
        GUISample guisample = new GUISample();
    }
}
