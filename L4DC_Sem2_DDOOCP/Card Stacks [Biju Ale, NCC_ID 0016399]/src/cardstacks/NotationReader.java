/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstacks;

import java.util.regex.Pattern;

/**
 *
 * @author Biju Ale
 */
public class NotationReader {

    private int numDices, numFaces, toRemove;
    private String diceNotation;

    public int getNumDices() {
        return numDices;
    }

    public int getNumFaces() {
        return numFaces;
    }

    public int getToRemove() {
        return toRemove;
    }

    public String getDiceNotation() {
        return diceNotation;
    }

    public void parseDiceNotation(String diceNotation) throws Exception {
        String[] parts;
        //Main part in Regex Pattern: (1|[1-9][0-9]*) [Matches any number without leading zeros.]
        if (Pattern.matches("((1|[1-9][0-9]*)d(1|[1-9][0-9]*))|((1|[1-9][0-9]*)d(1|[1-9][0-9]*)[-](1|[1-9][0-9]*))", diceNotation)) {
            parts = diceNotation.split("d|-");
            this.diceNotation = diceNotation;
            this.numDices = Integer.parseInt(parts[0]);
            this.numFaces = Integer.parseInt(parts[1]);
            this.toRemove = (diceNotation.contains("-")) ? Integer.parseInt(parts[2]) : 0; //Ternary Operator
        } else {
            throw new Exception("\n\nINVALID DICE NOTATION!");
        }
    }
}
