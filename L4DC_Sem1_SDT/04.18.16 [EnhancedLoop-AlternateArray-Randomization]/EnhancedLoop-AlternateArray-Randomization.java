//Enhanced 'for-loop', alternate array declaration, & Randomization

import java.util.Scanner;

public class EnhancedLoop-AlternateArray-Randomization{
  
  public static void main (String[]args){
  
//    String [] names = {"Douglas", "William", "Ravi", "Norman", "Greg"};
//    
//    for (int i = 0; i<names.length; i++ ){
//    System.out.println (names[i]);
//    
//    }
//    
//    for (String name: names){
//       System.out.println (name);
//    }
      
//      Scanner scan = new Scanner(System.in);
//      
//      String [] names = new String [5];
//      
//      for (int i = 0; i<names.length; i++){
//      
//        System.out.println("Enter a name.");
//        names  [i] = scan.next();
//                
//      }
//       
//    for (String name: names){
//      System.out.println(name);
//    }    
//      
    
    
    String prediction[] = {"France", "German", "Nepal", "America"};
    Scanner sc = new Scanner(System.in);
    
    Sytem.out.println("Please enter your name");
    name = sc.next();
    
    Random rdm = new Random (name.length());
    int num = rdm.nextInt(10);
    System.out.print(name+ "your lucky "+num)
    
      
    
  }
  
}