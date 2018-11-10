/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cardstacks.Dice;
import cardstacks.HistoryDice;
import cardstacks.NotationReader;

/**
 *
 * @author Biju Ale
 */
public class WhiteBxTestHistoryDice {

    public static void main(String[] args) {
        System.out.println("Result of Test Case #1");
        NotationReader nreader = new NotationReader();
        try {
            nreader.parseDiceNotation("4d4");
            Dice dice = new Dice(nreader);
            HistoryDice hd = new HistoryDice();
            System.out.println(hd.addToDiceHistory(dice));

            System.out.println("Result of Test Case #2");
            System.out.println(hd.addToDiceHistory(dice));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
