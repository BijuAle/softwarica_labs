/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructor;
import javax.swing.*;

/**
 *
 * @author NCC
 */
public class MyFrame {
    
    public MyFrame(){
        JFrame frame = new JFrame("first window");
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }
    
}
