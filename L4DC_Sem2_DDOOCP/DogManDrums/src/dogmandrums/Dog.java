/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogmandrums;

/**
 *
 * @author Biju Ale
 */
public class Dog {

    //State
    String name;
    String breed;
    int tailLength;
    String color;

    //Constructor (Creates object from blueprint)
    Dog(String name, String breed, int tailLength, String color) {
        this.name = name;
        this.breed = breed;
        this.tailLength = tailLength;
        this.color = color;
    }

    //Behaviors
    void bark() {
        //Do something
        System.out.println("Bark! bark! Whooohooo!");
    }

    void wagTail() {
        //Do something again & again
        for (int i = 0; i < 4; i++) {
            System.out.println("Waggy! Waggy!");
        }
    }

    void eat(String foodType) {
        for (int i = 0; i < 4; i++) {
            if (foodType == "Meat") {
                System.out.println("My name is " + this.name + "I am eating piece number: " + i);
            } else {
                System.out.println("Yuck!");
            }
        }
    }
}
