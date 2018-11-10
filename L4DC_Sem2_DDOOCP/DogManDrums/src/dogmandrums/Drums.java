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
public class Drums {

    //No State (Lets assume Drums have no state (It does but it will still work))
    //Constructor (Creates object from this blueprint)
    Drums(DrumSticks drumSticks) {
    }

    //Behaviors
    void playHighHat(String soundType) {

        if (soundType == "Your ears are dead!") {
            for (int i = 0; i < 20; i++) {
                System.out.println("Ding Ding Tom Tom!");

            }
        } else if (soundType == "Mellow sound") {
            System.out.println("Thiiist Thiiist!");
        }
    }

    void playSnares() {
        System.out.println("Tscha Tscha Tsch!");
    }
}
