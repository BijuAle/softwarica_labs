
package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {
    
    JLabel jl1,jl2;
    JFrame jf;
    JTextField jtFirst,jtSecond;
    JButton btnSum,btnClose;
    
    GUI()
    {
        jf = new JFrame("Sum of two no");
        jf.setSize(300,400);
        
        jl1 = new JLabel("Enter first no");
        jl2 = new JLabel("Enter second no");
        
        jtFirst = new JTextField(25);
        jtSecond = new JTextField(25);
        
        btnSum = new JButton("Sum");
        btnClose =new JButton("Close");
        
        btnSum.addActionListener(this);
        btnClose.addActionListener(this);
                
        jf.setLayout(new FlowLayout());
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jf.add(jl1);
        jf.add(jtFirst);
        jf.add(jl2);
        jf.add(jtSecond);
        jf.add(btnSum);
        jf.add(btnClose);
        
        
        jf.setVisible(true);
    }
    public static void main(String[] args) 
    {
        GUI obj = new GUI();
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn =(JButton) e.getSource();        
        if(btn == btnSum)
        {
            JOptionPane.showMessageDialog(null,"Sum is clicked");
        }
        else
        {
          System.exit(0);
        }

 
    }
}
