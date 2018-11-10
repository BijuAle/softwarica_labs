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
public class Man {

    //State
    String name;
    String gender;
    String skinTone;
    int age;

    //Constructor (Creates object from blueprint)
    Man() {
        
    }

    //Behaviors
    void takeDogForWalk() {
        Dog ceaser = new Dog("Ceaser", "Siberian Husky", 20, "Black & White");
        System.out.println("I took the dog out for a walk" + ceaser.name + " is happy!");
    }
    
    void playDrums() {
        
        DrumSticks myShinySticks = new DrumSticks();
        Drums myBeautifulDrum = new Drums(myShinySticks);
        
        myBeautifulDrum.playHighHat("Your ears are dead!");
    }
    
    void feedTheDog() {
        Dog ceaser = new Dog("Ceaser", "Siberian Husky", 20, "Black & White");
        System.out.println("I fed the dog");
        ceaser.eat("Meat");
        ceaser.wagTail();
    }
    
    void sleep() {
        System.out.println("ZZZZZZZZZZ!");
    }
    
    void die() {
        System.out.println("Life in Christ is eternal!");
    }
}
