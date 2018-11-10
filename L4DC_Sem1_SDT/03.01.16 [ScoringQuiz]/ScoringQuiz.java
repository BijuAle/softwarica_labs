//Score calculation for quiz

import java.util.Scanner;

public class ScoringQuiz{
  
  public static void main (String[]args){
    //int height = 8848;
    String president = "Obama";
    Scanner scan = new Scanner(System.in);
    
    System.out.println("What is the height of Mt. Everest in meter?");
    int userans1 = scan.nextInt();
    
    System.out.println("Who is the president of America?");
    String userans2 = scan.next();
    
    int counter = 0;
    
    if (userans1 == 8848 && userans2.equals("Obama")){
      counter=2;
    }
    else if (userans1 != 8848 && userans2.equals("Obama") || (userans1 == 8848 && userans2.equals("Obama1"))){ //need .equals = false
      counter=1;
    }
    else {
      counter=0;
    }
  System.out.println("You got " +counter+" points");
  }
}