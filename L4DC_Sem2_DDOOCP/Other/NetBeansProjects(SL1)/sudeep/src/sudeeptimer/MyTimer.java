
package sudeeptimer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MyTimer extends JFrame
{
    int x=5,y=5;
    Timer t;
    SuPanel mp;
    boolean rev=false;
    public MyTimer()
    {
    mp = new SuPanel();
        setSize(550,550);
        this.add(mp);
        t=new Timer(100, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
       
            if(rev==false){
          x=x+5;
            }    
            if(rev==true){
            x=x-5;
            }
            if (x>mp.getWidth()-50)
            {
                rev=true;
            }
            if(x<0)
            {
                rev=false;
            }
            
          mp.repaint();
          
        }
    });
        t.start();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    public class SuPanel extends JPanel
    {
    public void paintComponent(Graphics g)
    {
        //super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;
        g2d.setColor(Color.green);
        g2d.fillOval(x, y, 50,50);
        
                
    }
            
    }
    public static void main(String[] args)
    {       
    new MyTimer().setVisible(true);
    }
            
    
    
}



