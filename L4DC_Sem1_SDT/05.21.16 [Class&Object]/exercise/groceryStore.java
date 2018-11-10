package exercise;

public class groceryStore{

  //Instance variables / Fields
  private int applesSoldYearly;      //number of apples sold per year
  private double appleRetailPrice;    //retail price of apple  
  private int orangesSoldYearly;      //number of oranges sold per year
  private double orangeRetailPrice;    //retail price of orange 
  
 //Getters
 public int getApplesSoldYearly() {
  return applesSoldYearly;
 }
 public double getAppleRetailPrice() {
  return appleRetailPrice;
 } 
 public int getOrangesSoldYearly() {
  return orangesSoldYearly;
 } 
 public double getOrangeRetailPrice() {
  return orangeRetailPrice;
 }
 
 //Setters
 public void setApplesSoldYearly(int applesSoldYearly) {
  this.applesSoldYearly = applesSoldYearly;
 }
 public void setAppleRetailPrice(double appleRetailPrice) {
  this.appleRetailPrice = appleRetailPrice;
 }
 public void setOrangesSoldYearly(int orangesSoldYearly) {
  this.orangesSoldYearly = orangesSoldYearly;
 }
 public void setOrangeRetailPrice(double orangeRetailPrice) {
  this.orangeRetailPrice = orangeRetailPrice;
 }
 
  //Parameterized constructor
    groceryStore(int para_applesSoldYearly, double para_appleRetailPrice, int para_orangesSoldYearly, double para_orangeRetailPrice) {
      applesSoldYearly = para_applesSoldYearly;
      appleRetailPrice = para_appleRetailPrice;
      orangesSoldYearly = para_orangesSoldYearly;
      orangeRetailPrice = para_orangeRetailPrice;
    }
    
  //Default constructor
    groceryStore() {
      applesSoldYearly = 0;
      appleRetailPrice = 0;
      orangesSoldYearly = 0;
      orangeRetailPrice = 0;
    }
    
  //Method: Gross Revenuue
  double calcGrossRevenue() {  
   double grossRevenue = (applesSoldYearly * appleRetailPrice) + (orangesSoldYearly * orangeRetailPrice);
    return grossRevenue;
  }
  
  //Method: Apple Revenue Target
  double calcAppleRevenue(double targetRevenueApple){  
    double targetNoApples = targetRevenueApple / appleRetailPrice; 
    return targetNoApples;
  }
  
  //Method: Orange Revenue Target
   double calcOrangeRevenue(double targetRevenueOrange){
    double targetNoOranges = targetRevenueOrange / orangeRetailPrice; 
    return targetNoOranges;
   }
}