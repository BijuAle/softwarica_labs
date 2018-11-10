/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication14;

/**
 *
 * @author NCC
 */
public class Student {
String name;
int age;
/* Student(String n,int a)
{
    name=n;
    age=a;
    
}  */
void display()
{
    System.out.println("name:"+name +"   age:"+age);
}
   
    public static void main(String[] args) {
        
        Student st=new Student();
        st.display();
    }
    
}
