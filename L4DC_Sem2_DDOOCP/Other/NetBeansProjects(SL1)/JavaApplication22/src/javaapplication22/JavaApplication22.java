/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication22;

/**
 *
 * @author NCC
 */
import java.awt.event.*;
import javax.swing.*;
public class JavaApplication22 implements ActionListener{

    /**
     * @param args the command line arguments
     */
    JFrame fr;
    JButton b;
    JTextField tf;
    JavaApplication22()
    {
        fr=new JFrame("MYframe");
        b=new JButton("click");
        tf=new JTextField();
        fr.setLayout(null);
        
        b.setBounds(100,100,100,30);
        tf.setBounds(230,100,200,30);
        
        fr.add(b);
        fr.add(tf);
        b.addActionListener(this);
        fr.setSize(600,600);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            tf.setText("oh !why click.");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new JavaApplication22();
    }
    
}
