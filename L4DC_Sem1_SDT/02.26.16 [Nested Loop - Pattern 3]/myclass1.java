public class myclass1{
  public static void main(String[]args){    
    //Scope1
    int Z=1;
    while(Z<6){       
    //Scope2
      int A=6;    
      while(A>Z){
        A--;
        System.out.print(A);
      }
    //Scope2    
    Z++;
    System.out.println("");
    }
    //Scope1
  }  
}