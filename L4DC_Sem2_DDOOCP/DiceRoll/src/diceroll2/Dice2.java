/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceroll2;

/**
 *
 * @author Biju Ale
 */
import java.util.Random;

public class Dice2 {

    public static void main(String[] args) {
        Random rdm = new Random();
        int cards[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int freq[] = new int[cards.length];
        for (int i = 0; i < 10000; i++) {
            int roll = rdm.nextInt(cards.length);
            freq[roll]++;
        }

        int sum = 0;
        double sum2 = 0d;
        for (int i = 0; i < cards.length; i++) {
            System.out.println("Card: " + cards[i] + "\tfrequency:" + freq[i] + "\tPer " + ((double) freq[i] / 100));

            sum += freq[i];
            sum2 += freq[i]/100d;
        }

        System.out.println("sum:" + sum);
        System.out.println("sum percent:" + sum2);
    }

}
