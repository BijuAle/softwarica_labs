package cardgame;

/**
 *
 * @author madan
 */
public class Card {

    private String number;
    private long frequency;

    public Card(String number) throws Exception {

        int cardNo;
        if (number.trim().equals("")) {
            throw new Exception("card cannot be empty");
        }

        try {
            cardNo = Integer.parseInt(number);
            if (cardNo < 0) {
                throw new Exception("card cannot be of negative number");
            }
            if (cardNo == 0) {
                throw new Exception("Card must be of number greater than 0");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Invalid card number. Card Number must be number only");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public float getPercentage() {
        return frequency / 100f;
    }

}
