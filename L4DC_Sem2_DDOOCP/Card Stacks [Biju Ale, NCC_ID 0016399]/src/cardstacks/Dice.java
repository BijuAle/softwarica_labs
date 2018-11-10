/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstacks;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Biju Ale
 */
public class Dice {

    private String diceName;
    public static final int ROLL_TIMES = 10000;
    private Integer[] Combinations;
    private Integer[] frequencies;
    private int minCombination, maxCombination;

    public Integer[] getCombinations() {
        return Combinations;
    }

    public Integer[] getFrequencies() {
        return frequencies;
    }

    public String getDiceName() {
        return diceName;
    }

    public int getMinCombination() {
        return minCombination;
    }

    public int getMaxCombination() {
        return maxCombination;
    }

    public Dice(NotationReader nreader) throws Exception {
        if (nreader.getToRemove() > (nreader.getNumDices() * nreader.getNumFaces())) {
            throw new Exception("No. of cards to remove cannot exceed total no. of cards. Enter valid notation.\n");
        }
        this.diceName = nreader.getDiceNotation();
        setMinMax(nreader.getNumDices(), nreader.getNumDices() * nreader.getNumFaces());
    }

    //set - min & max Combination
    private  void setMinMax(int minCombination, int maxCombination) {
        this.minCombination = minCombination;
        this.maxCombination = maxCombination;
        populateCombinations();
    }

    //Populate all possible combinations in Combination array
    private  void populateCombinations() {
        Combinations = new Integer[maxCombination - minCombination + 1];
        int index = 0;
        for (int eachCombination = minCombination; eachCombination < maxCombination + 1; eachCombination++) {
            Combinations[index] = eachCombination;
            index++;
        }
        roll(Combinations);
    }

    //Roll the dice & record combinations' frequecnies
    private  void roll(Integer[] Combinations) {
        int randomIndex;

        frequencies = new Integer[Combinations.length];

        Arrays.fill(frequencies, 0);//Reset all indexes
        //Save index frequencies
        Random rdmGenerator = new Random();
        for (int i = 0; i < ROLL_TIMES; i++) {
            randomIndex = rdmGenerator.nextInt(Combinations.length);
            frequencies[randomIndex] += 1;
        }
    }
}
