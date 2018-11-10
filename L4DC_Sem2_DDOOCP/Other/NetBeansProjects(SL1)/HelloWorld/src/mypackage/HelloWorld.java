/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import java.util.Scanner;
/**
 *
 * @author NCC
 */
public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first no");
        int first = sc.nextInt();
        System.out.println("Enter second no");
        int second = sc.nextInt();
        int sum = first + second;
        System.out.println("Sum of two no is " + sum);
    }
    
}
