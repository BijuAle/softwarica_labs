/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Biju Ale
 */
public class Card {

    private int cardNo;
    private double frequency;

    Card(int CardNo, double frequency) {
        this.cardNo = cardNo;
        this.frequency = frequency;
    }

    public int getCardNo() {
        return this.cardNo;
    }

    public double getFrequency() {
        return this.frequency;
    }
}
