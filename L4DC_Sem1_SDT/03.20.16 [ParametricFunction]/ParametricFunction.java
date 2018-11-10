//Function with parameter
import java.util.Scanner;

public class ParametricFunction{
  public static void main(String[]args){
 
    Scanner scan = new Scanner(System.in);
    
    System.out.println("What is the length of rectangle?");
    int userinput = scan.nextInt();
    
    System.out.println("What is the breadth of rectangle?");
    int userinput2 = scan.nextInt();
       
    int area = areacalc(userinput, userinput2);
    System.out.println("The area of rectangle is "+ area);
  }
    
  public static int areacalc(int length, int breadth){
      int area = length*breadth;
      return area;
  }

  
 }