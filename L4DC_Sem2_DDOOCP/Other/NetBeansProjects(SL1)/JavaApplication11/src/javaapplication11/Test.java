/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication11;

/**
 *
 * @author NCC
 */
public class Test {

   String name;
  static int age;
  static int marks;
   void getName(String n)
   {
      this. name=n;
   }
  static void getMarksage(int a,int m)
   {
       age=a;
       marks=m;
   }
   void display()
   {
       System.out.println(name);
       System.out.println(age);
       System.out.println(marks);
   }
    public static void main(String[] args) {
        Test t=new Test();
        
        Test.age=30;
        t.getName("jack");
        Test.getMarksage(26,67);
        t.display();
    }
    
}
