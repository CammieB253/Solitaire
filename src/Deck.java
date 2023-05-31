import java.util.Collections;
import java.util.ArrayList;

public class Deck {


    public Deck() {


    }

    ArrayList<Card> cardDeck = new ArrayList<Card>();



    /**
     * Method for generating and shuffling a deck of 52 cards; Creates new card objects using the Card class.
     * Cards are represented by rank (1-13) and Suit (S, C, H, D) e.g 12D (Queen of diamonds) or 1S (Ace of Spades)
     * Rank 14 represents an empty space
     **/
    public void createDeck() {


        String[] suitList = {"S", "C", "H", "D"};


        for (String suit : suitList) {

            for (int x = 1; x <= 14; x++) {

                cardDeck.add(new Card(x, suit));

            }
        }

        Collections.shuffle(cardDeck);

    }


    // method for taking a card from the main deck; Used for creating the 7 table piles
    public Card pullTopCard() {

        Card drawnCard = cardDeck.get(cardDeck.size() - 1);

        cardDeck.remove(cardDeck.size() - 1);

        return drawnCard;
    }

    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }



}


