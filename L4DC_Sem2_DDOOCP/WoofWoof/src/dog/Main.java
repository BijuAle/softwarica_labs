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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog[] dogBasket = new Dog[3];
        dogBasket[0] = new Dog("Ceaser", "Doberman", 30);
        dogBasket[1] = new Dog("Max", "Fox Terrier", 20);
        dogBasket[2] = new Dog("Chihuahua", "Doberman", 10);

        //Bihana maile laamo method gareko thie. Tara mathiko method ramro ho. Laamo method esto thyo bihan ko:
        //See the difference.
        //Laamo method esto thyo bihan ko:
        /*  Dog[] dogBasket = new Dog[3];
         
          Dog ceaser = new Dog();
          ceaser.name = "Ceaser";
          ceaser.breed = "Doberman"
          ceaser.size = 30
      
          Dog max = new Dog();
          ceaser.name = "Suju";
          ceaser.breed = "Fox Terrier"
          ceaser.size = 20
      
          Dog jophnny = new Dog();
          ceaser.name = "Pabin";
          ceaser.breed = "Chihuahua"
          ceaser.size = 10
        
         */
        for (int i = 0; i < dogBasket.length; i++) {
            dogBasket[i].bark(dogBasket[i].size);
        }

    }
}
