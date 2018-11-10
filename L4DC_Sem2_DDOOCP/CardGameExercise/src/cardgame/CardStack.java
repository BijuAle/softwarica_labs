
package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author madan
 */
public class CardStack {
    
    private final List<Card> cardList;

    public CardStack() {
        cardList= new ArrayList<>();
    }
    
   public boolean addToStack(Card card){
       for(Card c : cardList){
            if(c.getNumber().equals(card.getNumber())){
               return false;
            }
        }
       
      return cardList.add(card);
   } 
   public boolean removeFromStack(Card card){
        for(Card c : cardList){
            if(c.getNumber().equals(card.getNumber())){
               cardList.remove(c);
               return true;
            }
        }
        
        
        
        return false;
   }
   
   public List<Card> shuffle(){
       Collections.shuffle(cardList);
       return cardList;
   }
   
   public List<Card> getCardStack(){
       return cardList;
   }
   
   
   
   
    
    
}
