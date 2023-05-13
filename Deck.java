import java.util.Collections;
import java.util.ArrayList;

public class Deck {



   public Deck(){



   }

    ArrayList<Card> cardDeck = new ArrayList<Card>();

    public void createDeck(){


       String[] suitList = {"S", "C", "H", "D"};


       for (var suit : suitList){

           for (int x = 1; x <= 14; x++){

               cardDeck.add(new Card(x, suit));

           }
       }

       System.out.println(cardDeck);

        for(Card c : cardDeck) {
            System.out.println(c.getCardRank() + " " + c.getCardSuit());
        }

       Collections.shuffle(cardDeck);

       for(Card c : cardDeck) {
           System.out.println(c.getCardRank() + " " + c.getCardSuit());

       }
    }

    public Card pullTopCard(){

        Card drawnCard = cardDeck.get(cardDeck.size() -1);

        cardDeck.remove(cardDeck.size() -1);

    return drawnCard;
    }


    public ArrayList <Card> getCardDeck(){return cardDeck;};

}
