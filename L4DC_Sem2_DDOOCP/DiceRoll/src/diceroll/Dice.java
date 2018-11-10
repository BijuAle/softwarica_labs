/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceroll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Biju Ale
 */
public class Dice {

    private ArrayList<Integer> stack;
    private int min, max, times, randomInt;
    private int[] rollStack;

    void setMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    void setTimes(int times) {
        this.times = times;
    }

    void populateStack() {
        stack = new ArrayList();
        for (int i = min; i < (max + 1); i++) {
            stack.add(i);
        }
    }

    int[] roll(int times) {
        setTimes(times);
        rollStack = new int[times];

        for (int i = 0; i < times; i++) {
            randomInt = new Random().nextInt((max + 1) - min) + min;
            rollStack[i] = randomInt;
        }
        return rollStack;
    }

    void sort(int[] rollStack) {
        Arrays.sort(rollStack);
    }

    void displayCount() {
        int count = 0;
        int temp = 0;

        for (int i = 0; i < times; i++) {
            if (i == rollStack.length - 2) {
                count = times - temp;
                System.out.println(rollStack[i] + " occurs " + count + " times.");
                break;
            }
            if (rollStack[i + 1] > rollStack[i]) {
                System.out.println(rollStack[i] + " occurs " + count + " times.");
                temp += count;
                count = 0;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Dice obj = new Dice();
        obj.setMinMax(2, 12);
        obj.populateStack();
        obj.sort(obj.roll(10000));
        obj.displayCount();

    }
}
