/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author Biju Ale
 */
public class Product {

    public void Product(int a, int b) {
        int result = a * b;
        System.out.println(result);
    }

    public void Product(double a, double b) {
        double result = a * b;
        System.out.println(result);
    }

    public void Product(int a, double b) {
        double result = a * b;
        System.out.println(result);
    }

    public static void main(String[] args) {
        Product obj = new Product();
        obj.Product(43, 54);
        obj.Product(64.7, 345);
        obj.Product(34, 345.6);

    }
}
