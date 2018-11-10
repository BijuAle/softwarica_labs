

package duckhunt;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class DuckHunt extends JFrame {

    JLabel lbl1;
    JLabel lbl2;
    JLabel lblcenter;
    myPanel mp;
    
    Timer t1;
    Timer t2;
    JPanel ptop , plstart , pcenter;
    
    Timer generator;
    Timer moveTimer;
    
    int hit, miss;
    
    ArrayList<MyShapeCircle> list;
     ArrayList<MyRect> list1;
    public DuckHunt() {
        setSize(600,600);
        setTitle("Duck hunt");
        lbl1 = new JLabel("Welcome");
        lbl2 = new JLabel("line start");
        lblcenter = new JLabel("center");
        mp= new myPanel();
        ptop = new JPanel();
        ptop.setPreferredSize(new Dimension(600, 50));
        plstart = new JPanel();
        plstart.setPreferredSize(new Dimension(50, 550));
        pcenter = new JPanel();
        mp.setPreferredSize(new Dimension(550, 550));
        ptop.add(lbl1);
        plstart.add(lbl2);
        pcenter.add(lblcenter);
        Container c = getContentPane();
        
        list= new ArrayList<MyShapeCircle>();
         list1= new ArrayList<MyRect>();
        
        c.add(ptop,BorderLayout.PAGE_START);
        c.add(plstart ,BorderLayout.LINE_START );
        c.add(mp ,BorderLayout.CENTER );
        
        moveTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //move x and y point
               for(MyShapeCircle sh : list){
                   sh.move();
               }
               
               //reset frame of ellipse
              
               for(MyShapeCircle sh : list){
                  sh.getShape().setFrame(sh.x, sh.y, 30, 30);
               }
               
               for(MyRect sh : list1){
                   sh.move();
               }
               
                for(MyRect sh : list1){
                  sh.getShape().setFrame(sh.x, sh.y, 30, 30);
               }
               
               
              mp.repaint();
               
            }
        });
        moveTimer.start();
        
        generator = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rdm = new Random();
                MyShapeCircle sh = new MyShapeCircle(0, 0, 30, 30, rdm.nextInt(4));
                list.add(sh);
                
                MyRect sh1 = new MyRect(0, 0, 35, 45, rdm.nextInt(4));
                list1.add(sh1);
            }
        });
        
        generator.start();
        
    }
    
    public static void main(String[] args) {
      new DuckHunt().setVisible(true);
    }
    
     public class myPanel extends JPanel implements MouseListener{

        public myPanel(){
            this.addMouseListener(this);
        }
        
        public void paintComponent(Graphics g) {
            
            g.clearRect(getX(), getY(), getWidth(), getHeight());
            
            super.paintComponent(g);
            Graphics2D gd = (Graphics2D) g;
           
            
            for(MyShapeCircle s : list){
                 gd.setColor(Color.red);
                gd.fill(s.getShape());
            }
            
            for(MyRect s : list1){
                 gd.setColor(Color.GREEN);
                gd.fill(s.getShape());
            }
            
            
            getToolkit().sync();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int xcor=e.getX();
            int ycor = e.getY();
           
            for(MyShapeCircle s : list){
                
                if(s.getShape().contains(xcor, ycor)){
                    hit++;
                    lbl1.setText(hit+"");
                    list.remove(s);
                    return;
                }
            }
             for(MyRect s : list1){
                
                if(s.getShape().contains(xcor, ycor)){
                    hit++;
                    lbl1.setText(hit+"");
                    list1.remove(s);
                    return;
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
     
     
     private class MyRect
     {
         int x,y,h,w;
         int scheme;
         
         Rectangle2D rect;
         
         public MyRect(int x,int y,int h,int w,int scheme){
             this.x=x;
             this.y=y;
             this.h=h;
             this.w=w;
             this.scheme=scheme;
             
             rect= new Rectangle2D.Double(x, y, w, h);
         }
         
        public void move(){
             switch (scheme) {
                 case 0:
                     x+=5;
                     break;
                 case 1:
                     y+=5;
                     break;
                 case 2:
                     x+=5;
                     y+=5;
                     break;
                 default: x+=5;
                     break;
             }
        } 
        
        public Rectangle2D getShape(){
            return rect;
        }
     }
     
     
     
     private class MyShapeCircle{
         
         int x,y,h,w;
         int scheme;
         
         Ellipse2D ellipse;
         
         public MyShapeCircle(int x,int y,int h,int w,int scheme){
             this.x=x;
             this.y=y;
             this.h=h;
             this.w=w;
             this.scheme=scheme;
             
             ellipse= new Ellipse2D.Double(x, y, w, h);
         }
         
        public void move(){
             switch (scheme) {
                 case 0:
                     x+=5;
                     break;
                 case 1:
                     y+=5;
                     break;
                 case 2:
                     x+=5;
                     y+=5;
                     break;
                 default: x+=5;
                     break;
             }
        } 
        
        public Ellipse2D getShape(){
            return ellipse;
        }
        
        
         
         
         
         
     }
     
     
}
