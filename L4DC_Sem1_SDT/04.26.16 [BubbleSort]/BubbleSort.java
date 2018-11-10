//BubbleSort

import java.util.Scanner;

public class BubbleSort{

  public static void main(String[]args){
   
    //Getting array's length from user.
    Scanner scan = new Scanner(System.in);
    
    System.out.println("How many numbers do you want to sort? :)");
    int ArrayLength = scan.nextInt();
    
    //Getting unsorted numbers from user & populating them in array.
    int[] unsortedArray = new int[ArrayLength];
    
    for (int index = 0; index < unsortedArray.length; index++){
      System.out.println((index+1) + ". Enter number.");
      unsortedArray[index] = scan.nextInt();
    }
    
    //Invoking sorting function.
    int[] sortedArray = BubbleSorter(unsortedArray, ArrayLength);
    
    //Printing sorted numbers.    
    System.out.println("\n \n FULLY SORTED NUMBER IS: ");
    for (int index = 0; index < ArrayLength; index++){
      System.out.print(" "+sortedArray[index]);
    }
    System.out.println("\n \n (: (: Have a wonderful day! :) :)");
}
  //Sorting function (Ascending order)
  public static int[] BubbleSorter (int[] unsortedArray, int ArrayLength){
    
      int tmp = 0;  
      for (int pass = 1; pass < ArrayLength+1; pass++){
        
        for (int index = 0; index < ArrayLength - pass; index++){
          if (unsortedArray[index] > unsortedArray[index+1]){
            tmp = unsortedArray[index];
            unsortedArray[index] = unsortedArray[index+1];
            unsortedArray[index+1] = tmp;
          }
        }
       
        //Printing partially sorted numbers at each pass.
        System.out.println("\n \n Partial  sort in Pass " + pass +":");
        
        for (int index = 0; index < ArrayLength; index++){
          System.out.print(" "+unsortedArray[index]);
        }    
     }      
      //Returning fully sorted numbers.
      return unsortedArray;            
   }  
}