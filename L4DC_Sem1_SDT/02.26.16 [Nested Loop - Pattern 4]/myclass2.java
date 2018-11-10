public class myclass2{
  public static void main(String[]args){    
    //Scope1
    int Z=2;
    while(Z<12){       
    //Scope2
      int A=12;    
      while(A>Z){
        A=A-2;
        System.out.print(A);
      }
    //Scope2    
    Z=Z+2;
    System.out.println("");
    }
    //Scope1
  }  
}