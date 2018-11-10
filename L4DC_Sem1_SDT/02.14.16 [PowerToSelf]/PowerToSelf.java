import java.util.Scanner;

public class PowerToSelf{

  public static void main (String[]args){
  
    Scanner scan = new Scanner(System.in);
        
    System.out.println("Enter a number.");
    int userinput = scan.nextInt();
    
    System.out.println(userinput+" raised to the power "+userinput+" is "+powercalc(userinput));
  }

  
  public static int powercalc(int userinput){
  
    int answer = 1;
    
    for(int counter = 1; counter<(userinput+1); counter++){
      answer = answer * userinput;
    }
    return answer;
  }
}