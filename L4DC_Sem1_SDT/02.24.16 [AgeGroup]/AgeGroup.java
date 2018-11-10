//Age group check

import java.util.Scanner;
  
public class AgeGroup{
  public static void main (String[]args){
    
    int flag;
    Scanner scan = new Scanner(System.in);
    
    for (flag=0; flag>=0 ; flag++){
    System.out.println("Enter age");
    int age = scan.nextInt();
    
    if (age<20){
    System.out.println("You are under age");
    }
    else if (age>20 && age<45){
    System.out.println("You are OK");
    }
    else{
    System.out.println("You are not between 20 & 45, not below 20");
    }     
    }
    flag=1;
  }

}