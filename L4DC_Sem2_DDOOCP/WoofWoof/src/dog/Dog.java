/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dog;

/**
 *
 * @author Biju Ale
 */
public class Dog {

    //State
    String name;
    String breed;
    int size;

    //Constructor (Bihana yo thiena. Check this out. Compare bihan ko ra ahileko. Bihan laamo method, this choto method.)
    Dog(String name, String breed, int size) {
        this.name = name;
        this.breed = breed;
        this.size = size;
    }

    //Behavior
    void bark(int Size) {
        if (size == 30) {
            System.out.println("Woof! Woof!");
        } else if (size == 20) {
            System.out.println("Ruff! Ruff!");
        } else if (size == 10) {
            System.out.println("Yip! Yip!");

        }
    }
}
