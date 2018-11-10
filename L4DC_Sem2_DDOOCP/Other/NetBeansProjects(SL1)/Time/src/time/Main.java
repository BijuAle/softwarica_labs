/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package time;

/**
 *
 * @author NCC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Time t;
        
        t=new Time();
        
        t.setHour(8);
        t.setMinute(2);
        t.setSecond(56);
        
        System.out.println(t.getHour());
        System.out.println(t.getMinute());
        System.out.println(t.getSecond());
       
        
    }
    
}
