import java.util.Scanner;

public class BinarySearch{

  public static void main(String[]args){
  
    Scanner scan = new Scanner(System.in);
    System.out.println("How many numbers do you want to sort?");      
    int size = scan.nextInt();
    
   int[] elements = new int[size];
    for (int index = 0; index < elements.length; index++){
         
      System.out.println("Enter number."); 
      elements[index] = scan.nextInt();
    }

    System.out.println("Enter search term");
    int SearchTerm = scan.nextInt();
    
    int found = BinarySearcher (elements, SearchTerm);
    if (found == -1){
      System.out.println(SearchTerm + " is not present in the array.");
    }
    else
      System.out.println(SearchTerm + " was found in " + found);
  }
  
  static int BinarySearcher (int[] elements, int SearchTerm){
  
    int min = 0;
    int max = elements.length -1;
    
    while (min <=max)   {
      int mid = (min + max) / 2;
      if (SearchTerm == elements[mid]) {      
        return mid;
      }
      else if (SearchTerm > elements[mid]){
        min = mid +1;        
      }
      else if (SearchTerm < elements[mid]) {
        max = mid -1;  
      }          
} 
    return -1;
}
}