package cardgame;

/**
 *
 * @author madan
 */
public class Card {
    
    private String number;
    private long frequency;
    
    public Card(String number) throws Exception{
        
         if(number.trim().equals("")){
            throw new Exception("card cannot be empty");
        }
        
       try{
          Integer.parseInt(number);
       }catch(NumberFormatException e){
           throw new Exception("Invalid card number. Card Number must be number only");
       }
        this.number=number;
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
        return frequency/100f;
    }

   

    
     
    
    
}
