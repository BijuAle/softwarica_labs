/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package add;
import commonFunction.*;
import javax.swing.JOptionPane;
/**
 *
 * @author NCC
 */
public class Sanjay {
    public static void main(String[] args) {
        SI sathi = new SI();
        
        float p,r,t;
        p=20000.57f;
        r=13;
        t=2.5f;
        
        float si = sathi.simpleMachine (p,r,t);
        JOptionPane.showMessageDialog(null, si);
    }
}
