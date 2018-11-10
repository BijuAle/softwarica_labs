

package myfirstapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
               
public class MyFirstApp {
    JLabel jl1 ;
    JTextField jt1;
    JLabel jl2 ;
     JTextField jt2;
     JButton jb1;
     JButton jb2;
    public static void main(String[] args) {
      MyFirstApp obj = new MyFirstApp();
    }
    MyFirstApp()
    {
       JFrame jf = new JFrame("My first frame");
       jf.setSize(400,500);
       
        jl1 = new JLabel("Enter first number");
        jt1 = new JTextField(25);
        jl2 = new JLabel("Enter second number");
        jt2 = new JTextField(25);
       
        jb1 = new JButton("SUM");
       
      
        jb2 = new JButton("CLOSE");
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       jb1.addActionListener(new SumListner());
       jb2.addActionListener(new SumListner());
       jf.setLayout(new FlowLayout());
       jf.add(jl1);
       jf.add(jt1);
       jf.add(jl2);
       jf.add(jt2);
       jf.add(jb1);
       jf.add(jb2);
       jf.pack();
       jf.setVisible(true);
    }
    private class SumListner implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton myAction =(JButton) e.getSource();
            if(myAction == jb1)
            {
                JOptionPane.showMessageDialog(null,"SUM");
            }
            else if(myAction == jb2)
            {
                JOptionPane.showMessageDialog(null,"Close");
            }
        }
        
    }
}
