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
//Main class pulls together all class & contains main function (psvm) which is the first thing that runs
public class MainClass {

    public static void main(String[] args) {

        Man AnuzTheTombRaider = new Man();
        System.out.println("-------Task 1-------");
        AnuzTheTombRaider.takeDogForWalk();
        System.out.println("-------Task 2-------");
        AnuzTheTombRaider.feedTheDog();
        System.out.println("-------Task 3-------");
        AnuzTheTombRaider.playDrums();
    }

}
