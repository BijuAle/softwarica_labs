/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwarica2;

/**
 *
 * @author NCC
 */
public class Student {

   String name;
   int semester;
   
   //constructor
   Student(String nm,int sem)
   {
      name=nm;
      semester=sem;
   }
   /*setter methods
  // void setName(String nm)
   {
       name=nm;
   }
   void setSemester(int sem)
   {
       semester=sem;
   }  */
   //getter methods
   String getName()
   {
       return name;
   }
   int getSemester()
   {
       return semester;
   }
    public static void main(String[] args) {
        Student st=new Student("jonny",2);
        System.out.println(st.getName());
        
       
    
}
}
