//Factorial of a number without using recursive fuction.
import java.util.Scanner;

public class factorial {
  
  public static void main (String...args){
    
     Scanner scan = new Scanner(System.in);
     System.out.println("Enter a whole number to find out its factorial.");
     int userinput = scan.nextInt();
     
     int fact = 1;
     for (int counter = userinput; counter > 0; counter--){
     
       fact = fact * counter;
     }
     
    System.out.println("Factorial of " + userinput + " is " + fact);
  }

}