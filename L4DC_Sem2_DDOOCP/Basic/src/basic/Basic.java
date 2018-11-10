/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author Biju Ale
 */
public class Basic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Do Something
        int x = 3;
        String name = "Joe";
        System.out.println("Joe's  no. is+" + x);

        //Do something again and again
        System.out.println("Joe's list of his favourite numbers:");
        for (int i = 0; i <= 10; i++) {
            System.out.println("Joe's likes " + i);
        }

        //Do something under this condition
        int[] allNumbers = new int[10];
        for (int i = 0; i <= 10; i++) {
            allNumbers[i] = i * 2;
            if (allNumbers[i] <= 10) {
                System.out.println("Joe likes this number: " + allNumbers[i]);
            } else {
                System.out.println("Joe hates this number: " + allNumbers[i]);

            }
        }
    }

}
