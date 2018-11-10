//Simple array declaration & elements printing

import java.util.Scanner;

public class SimpleArray{
  public static void main (String[]args){
  
   String[] day = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
     
   
   for (int i=0; i<day.length; i++){
     if (day[i] != "Tue") {
     System.out.println(day[i]);
      }
   }
}  

}
  
