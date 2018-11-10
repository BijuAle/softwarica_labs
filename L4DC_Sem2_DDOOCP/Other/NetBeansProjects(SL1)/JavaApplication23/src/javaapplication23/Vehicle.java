package javaapplication23;
public class Vehicle
{
    String color;
    int weight;
    int wheel;  
    public void myAttributes()
    {
        System.out.println("my color is" + color);
        System.out.println("my weight is" + weight);
        System.out.println("my no of wheel is" + wheel);
    }        
}
class Car extends Vehicle
{
    int nofgear;
    
     public void myAttributes()
    {
        System.out.println("my color is" + color);
        System.out.println("my weight is" + weight);
        System.out.println("my no of wheel is" + wheel);
        System.out.println("gear is " + nofgear);
       
    }    
     public static void main(String[] args) {
        Car obj = new Car();
        obj.color = "red";
        obj.weight=500;
        obj.wheel=1;
        obj.nofgear=5;
        obj.myAttributes();
    }
}
  


