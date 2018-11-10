/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package add;

import commonFunction.SI;
import javax.swing.JOptionPane;

/**
 *
 * @author NCC
 */
public class parvati {
    public static void main(String[] args) {
        float p,r,t;
        p=234.57f;
        r=13;
        t=2.5f;
        
         SI sathi = new SI();
            float si = sathi.simpleMachine (p,r,t);
        JOptionPane.showMessageDialog(null, si);
    }
}
