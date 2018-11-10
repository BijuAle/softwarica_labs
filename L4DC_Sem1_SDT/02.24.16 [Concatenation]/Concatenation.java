//Concatenation

import java.util.Scanner;

public class Concatenation{
  public static void main (String[]args)
  {    
    int i;
    Scanner userinput = new Scanner(System.in);
    
    System.out.println("What is your first name?");
    String firstname = userinput.next();
    
    System.out.println("What is your last name?");
    String lastname = userinput.next();
    
    
    System.out.println("What is your address?");
    String address = userinput.next();
    
    System.out.println("Your full name is " + firstname + " " + lastname + ".You live in " + " " + address);
   }
};