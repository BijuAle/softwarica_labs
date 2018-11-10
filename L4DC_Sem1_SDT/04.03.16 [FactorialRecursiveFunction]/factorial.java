// Factorial of a number using recursive function
import java.util.Scanner;
public class factorial {

  public static void main(String...args){
  
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number to find its factorial.");
    int userinput = scan.nextInt();
    
    long fact = CalcFact(userinput);
    System.out.println("The factorial of " + userinput + " is " + fact);
    
  }
  
  static long CalcFact(int input){
  
    if (input > 0){
    long  fact = input * CalcFact(input -1); 
    return fact;  
    }    
    else return 1;        
  }
}