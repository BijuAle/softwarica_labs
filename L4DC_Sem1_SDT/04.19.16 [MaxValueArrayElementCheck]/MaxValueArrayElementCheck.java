// Maximum element in an array

import java.util.Scanner;

public class MaxValueArrayElementCheck{
  public static void main(String[]args){
  
    Scanner scan = new Scanner(System.in);
    int[] bag = new int[5];
    
    for (int i = 0; i<bag.length; i++){
    
      System.out.println((i+1)+". Enter number.");
      bag[i] = scan.nextInt();
    
  }
    
//for (int printObject: bag){
//      System.out.println(printObject);
//}   
    
int max = 0;
for (int j = 0; j<bag.length; j++){
  
  if(bag[j]>max){
    max = bag[j];
  }
  
}    
System.out.println("The greatest no is: "+max);
  
  }
 
}