package exercise;
import java.util.Scanner;
  
public class mainClass{
  
  public static void main (String[]args){
  
    groceryStore houstonStore = new groceryStore(534, .99, 429, .87);
    groceryStore seattleStore = new groceryStore(764, .86, 842, .91);
    groceryStore orlandoStore = new groceryStore(402, .77, 298, .79);

    
    //Print info on Houston
    System.out.println ("Apples sold per year in Houston: " + houstonStore.getApplesSoldYearly());
    System.out.println ("Retail price of apple in Houston: " + houstonStore.getAppleRetailPrice());
    System.out.println ("Oranges sold per year in Houston: " + houstonStore.getOrangesSoldYearly());
    System.out.println ("Retail price of orange in Houston: " + houstonStore.getOrangeRetailPrice());
    
    //Print gross revenue
    System.out.println ("\nGross revenue for Houston: " + "$" + houstonStore.calcGrossRevenue());
    System.out.println ("Gross revenue for Seattle: " + "$" + seattleStore.calcGrossRevenue());
    System.out.println ("Gross revenue for Orlando: " + "$" +orlandoStore.calcGrossRevenue());
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("\nWhat is your target revenue, selling apples?");
    int targetRevenueApple = scan.nextInt();
    
    System.out.println("What is your target revenue, selling oranges?");
    int targetRevenueOrange = scan.nextInt();
    
    System.out.println ("For HOUSTON:");
    System.out.println ("You need to sell " + Math.round(houstonStore.calcAppleRevenue(targetRevenueApple)) + " apples");
    System.out.println ("You need to sell " + Math.round(houstonStore.calcOrangeRevenue(targetRevenueOrange))+ " oranges");
    
    System.out.println ("\nFor SEATTLE:");
    System.out.println ("You need to sell " + Math.round(seattleStore.calcAppleRevenue(targetRevenueApple))+ " apples");
    System.out.println ("You need to sell " + Math.round(seattleStore.calcOrangeRevenue(targetRevenueOrange))+ " oranges");
    
    System.out.println ("\nFor ORLANDO:");
    System.out.println ("You need to sell " + Math.round(orlandoStore.calcAppleRevenue(targetRevenueApple))+ " apples");
    System.out.println ("You need to sell " + Math.round(orlandoStore.calcOrangeRevenue(targetRevenueOrange))+ " oranges");    
    
  }
}