// Sum of elements/numbers in an array

import java.util.Scanner;

public class ElementSumInArray{
  public static void main(String[]args){
    
//    String[] myarray = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
//  
//    for (int i = 0; i<myarray.length; i++){
//    System.out.println(myarray[i]);   
  
    
    double total = 0;
    double[] myarray1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    for(int j = 0; j<myarray1.length; j++){
    total = total + myarray1[j];
    }
    System.out.print(total);       
        
 }
}