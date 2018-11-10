

package abs_class;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class Teacher extends JFrame {
    
    public Teacher(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("you click "+ e.getX()+","+e.getY());   
            }

            @Override
            public void mousePressed(MouseEvent e) {
                 }

            @Override
            public void mouseReleased(MouseEvent e) {
                 }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                  }
        });
    }
   
        public static void main(String[] args) {
        Teacher obj = new Teacher();
        obj.setVisible(true);
    }
}
