
package Inherti;

public class Bike extends Vehicle{
   public final int noOfgear=34;
   public void displayFeatures()
    {
        System.out.println("My no of gear is" + noOfgear);
        System.out.println("My color is "+ super.color);
        System.out.println("my weitht is " + super.weight);
        super.displayFeatures();
    }
    public static void main(String[] args) {
        Bike obj = new Bike();
        obj.color = "Red";
        obj.noOfgear = 2;
        obj.weight=4;
        obj.displayFeatures();
    }
}
