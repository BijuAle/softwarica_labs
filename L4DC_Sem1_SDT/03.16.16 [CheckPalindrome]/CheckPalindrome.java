// Check for palindrome

public class CheckPalindrome{
  
 public static void main(String[]args){

 int i = 1;  
 int x = 0;
 int c = 1;  
 int y = 1;
 int z = 1;
 int num = 5467;
 
 while(y!=0){

   y = num%10;
   num = num/10;   
// System.out.println(y);  
   c++;      
   x = y * i + x;
   i = i* 10;  
 }
 System.out.println(x);
}
}