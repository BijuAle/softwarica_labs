/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula;

import java.util.Scanner;

/**
 *
 * @author Biju Ale
 */
public class Biju {

    int r;
    int c;
    int f;


    public void insertr(int r) {
        this.r = r;
    }

    public void insertc(int c) {
        this.c = c;
    }

    public void insertf(int f) {
        this.f = f;
    }

    public double pi() {
        double result = 4 * (22 / 7) * r * r;
        return result;
    }

    public double toFarenheit(double celcius) {
        // double farenheit = (9/5)(celcius)+32;
        double farenheit = ((9 / 5.0) * celcius) + 32;
        return farenheit;
    }

    public double toCelcius(double farenheit) {
        // double celcius = (5/9)(farenheit-32);
        double celcius = (5 / 9.0) * (farenheit - 32);
        return celcius;
    }

    public void displaypiresult() {
        System.out.println("The result of 4*pi*r^2 is " + pi());
    }

    public void displayToFarenheit() {
    System.out.println("Celcius to Farenheit is " + toFarenheit(f));
    }

    public void displayToCelcius() {
        System.out.println("Farenheit to Celcius is " + toCelcius(c));    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Biju b1 = new Biju(), b2 = new Biju();
        System.out.println("Enter r");
        int r = sc.nextInt();
        b1.insertr(r);
        
               
        System.out.println("Enter Celcius value to convert to Farenheit");
        int celcius = sc.nextInt();
        b2.insertc(celcius);
        b2.displayToCelcius();
        
        

    }
}