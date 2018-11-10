//Simple Function

public class SimpleFunction{
  
  public static void main(String[]args){
  
    String b = coke();
    String p = pizza();
    double c = cost();
    
    System.out.println(b);
    System.out.println(p);
    System.out.println("Your bill is "+c);
        
  }

  public static String coke(){
   String a = "Coke is ready";
   return a;
  }
  
  public static String pizza(){
    String p = "Pizza is ready";
    return p;
  }
  
  public static double cost(){
    double c = 79.67;
    return c;
  }
}