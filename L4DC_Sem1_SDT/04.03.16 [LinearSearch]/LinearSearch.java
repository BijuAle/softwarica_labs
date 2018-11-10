import java.util.Scanner;

public class LinearSearch{

  public static void main (String...args){
  
    Scanner scan = new Scanner (System.in);
    System.out.println("How many names do you want to store?");
    int ArrayLength = scan.nextInt();
    
    String[] names = new String [ArrayLength];
    
    for (int index = 0; index < ArrayLength; index++){
    
      System.out.println(index + " .Enter name.");
      names[index] = scan.next();
    }
    
    System.out.println ("Enter the name that you want to search.");
    String SearchTerm = scan.next();
    
    int FoundIndex = LinearSearcher (names, SearchTerm);
    
    if (FoundIndex == -1){
      System.out.println(SearchTerm + " does not exist in the array.");
    }
    else {
      System.out.println(SearchTerm + ", found in index number "+ FoundIndex);
    }
  }
  
  public static int LinearSearcher (String [] names, String SearchTerm){
  
    for (int index = 0; index < names.length; index++){
    
      if (names[index].equals(SearchTerm)){
      
        return index;
      }
     
    }
    return -1;
  }
}