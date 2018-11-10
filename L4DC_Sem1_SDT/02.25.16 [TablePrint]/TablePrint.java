import java.util.Scanner;

public class TablePrint{
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    int calc=0;
    int counter;
    
    System.out.print("Enter a Number");
    int userinput = scan.nextInt();
    
    for (counter=1; counter<11; counter++){
      calc = userinput*counter;
      System.out.println(userinput+"*"+counter+"="+calc);
    }
    
    String y = "y";
    String n= "n";
    
    System.out.println("Do you want to enter another number? Enter y or n");
    String userinput2 = scan.next();
      if (userinput2.equals ("y")){
      System.out.println ("asd");
    }
    System.out.println("Thats all.");
  }
}