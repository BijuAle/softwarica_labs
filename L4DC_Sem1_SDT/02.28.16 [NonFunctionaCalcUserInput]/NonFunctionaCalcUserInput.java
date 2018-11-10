//Calculations on 2 numbers & operation input by user

import java.util.Scanner;
  
  public class NonFunctionaCalcUserInput{
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Enter a Number.");
    double num1 = scan.nextDouble();
    
    System.out.println("Enter another Number.");
    double num2 = scan.nextDouble();
    
    double sum = num1+num2; 
    double diff = num1-num2;
    double prod = num1*num2;
    double mod = num1%num2;
    double div = num1/num2;
    
    System.out.println("Enter action");
    String action = scan.next();
    
    if (action.equals("+")){
      System.out.println("The sum is " +sum);
    }
    else if (action.equals("-")){
      System.out.println("The difference is " + diff);
    }
    else if (action.equals("*")){
      System.out.println("The product is " + prod);
    }
    else if (action.equals ("/")){
      System.out.println("The division is " + div);
    }    
  }
}