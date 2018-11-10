//Simpe Function 2

public class SimpleFunction2{
  
  public static void main(String[]args){
    
    String name = namePrinter();
    int age = agePrinter();
    String address = addPrinter();
    
    System.out.println("Your name is "+name);
    System.out.println("Your age is "+age);
    System.out.println("Your address is "+address);
  }

  public static String namePrinter(){
    String name = "Biju Ale";
    return name;
  }
  
  public static int agePrinter(){
    int age = 77;
    return age;
  }
  
    public static String addPrinter(){
    String add = "Gyaneswor";
    return add;
  }
  
}