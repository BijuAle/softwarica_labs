//Linear search on array of 5 elements using function.

import java.util.Scanner;

public class arrayFunction{
  public static void main(String[]args){
  
    Scanner scan = new Scanner(System.in);
    int userinput[] = new int[5];
    int position;
    int searchTerm; 
    
    for(int index = 0; index<userinput.length; index++){
      System.out.println("Enter number.");
      userinput[index] = scan.nextInt();
    }
    
    System.out.println("Enter search term");
    searchTerm = scan.nextInt();
    
    position = arraySearch(userinput, searchTerm);
    
    if (position!=-1) {
    System.out.println(searchTerm + " is in position/index number -> "+position );
    }  
    else {
    System.out.println(searchTerm + " does not exist in the array." );
    }
  }
  
  
  public static int arraySearch (int [] receivedArray, int searchTerm){
        
    int found = -1;
    
    for(int index = 0; index<receivedArray.length; index++){
      if (receivedArray[index] == searchTerm){
        found = index;
      }
    }
    return found;
  }

}