/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Biju Ale
 */
public class Animation extends JFrame implements ActionListener {

    private JButton btn1, btn2, btn3;
    private JLabel lblTitle;
    private Timer myTimer;
    private int x = 25;
    private int y = 50;
    private int xt = 0;
    private boolean reverse;

    Animation() {
        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container c = getContentPane();
        c.setLayout(null);

        lblTitle = new JLabel("Welcome to the Game - Moving Objects");
        btn1 = new JButton("A");
        btn2 = new JButton("B");
        btn3 = new JButton("C");

        lblTitle.setBounds(25, 10, 240, 25);
        btn1.setBounds(x, y, 55, 25);
        btn2.setBounds(x, y, 55, 25);
        btn3.setBounds(x, y, 55, 25);

        c.add(lblTitle);
        c.add(btn1);
        c.add(btn2);
        c.add(btn3);

        myTimer = new Timer(60, this);
        myTimer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x > getWidth() || y > getHeight() ) {
            reverse = true;
        }
        if (x < 50) {
            reverse = false;
        }
        moveTitle(1);
        moveA(5);
        moveB(5, 5);
        moveC(5);

    }

    void moveTitle(int tx) {
        if (reverse == false) {
            xt += tx;
        } else if (reverse == true) {
            xt -= tx;
        }
        lblTitle.setLocation(xt, 10);
    }

    void moveA(int ax) {
        if (reverse == false) {
            x += ax;
        } else if (reverse == true) {
            x -= ax;
        }
        btn1.setLocation(x, 50);
    }

    void moveB(int bx, int by) {
        if (reverse == false) {
            x += bx;
            y += by;
        } else if (reverse == true) {
            x -= bx;
            y -= by;
        }
        btn2.setLocation(x, y);
    }

    void moveC(int cy) {
        if (reverse == false) {
            y += cy;
        } else if (reverse == true) {
            y -= cy;
        }
        btn3.setLocation(25, y);
    }

    public static void main(String[] args) {
        new Animation().setVisible(true);
    }

}
