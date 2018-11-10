/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundredbtns;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Biju Ale
 */
public class HundredBtns {

    public static void main(String[] args) {
                 
        JFrame jf = new JFrame();
        FlowLayout layout = new FlowLayout();

        jf.setTitle("Hundred Buttons");
        jf.setSize(500, 500);
        jf.setLayout(layout);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        //Using 1-D Array        
        //JButton[] AllButtons = new JButton[100];

        /*int counter = 1;
        for (JButton EachButton : AllButtons) {
            EachButton = new JButton("Button " + counter);
            jf.add(EachButton);
            counter++;
        }*/
        JButton[][] AllButtons = new JButton[10][10];

        for (int ri = 0; ri < AllButtons.length; ri++) {
            for (int ci = 0; ci < AllButtons[1].length; ci++) {
                AllButtons[ri][ci] = new JButton(ri + ", " + ci);
                jf.add(AllButtons[ri][ci]);
            }

        }

    }
}
