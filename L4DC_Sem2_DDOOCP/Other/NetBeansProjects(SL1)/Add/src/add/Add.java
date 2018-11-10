/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package add;

import javax.swing.JOptionPane;

public class Add {
    
    public static void main(String[] args) {
       int first,second,sum;
       first = 22;
       second=33;
       sum = add(first,second);
       JOptionPane.showMessageDialog(null, sum);
    }
    
    public static int add(int first,int second)
    {
        return first + second;
    }
}
