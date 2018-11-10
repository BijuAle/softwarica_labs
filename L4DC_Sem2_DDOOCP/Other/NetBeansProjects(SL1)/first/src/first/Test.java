/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package first;

/**
 *
 * @author NCC
 */
public class Test {
    String name;
    int roll;
    int marks;
    void getData(String n,int r,int m )
    {
        name=n;
        roll=r;
        marks=m;
    }
    void display()
    {
        System.out.println("i m in test");
        System.out.println("Name:"+name+" roll:"+roll+"marks:"+marks);
    }

   
    
    
}
