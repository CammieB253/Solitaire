/**
 * Deck class
 * Contains method for create main deck of cards
 * Contains method for drawing cards from main deck
 *
 * @author Cameron Buchan
 */

import java.util.Collections;
import java.util.ArrayList;

public class Deck {


    public Deck() {


    }

    // array of cards within the deck
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


    /**
     * method for drawing the top card from the main deck
     * Used for making table piles and drawing from waste pile
     * @return the card that has been drawn
     */
    public Card pullTopCard() {

        Card drawnCard = cardDeck.remove(cardDeck.size() - 1);

        return drawnCard;
    }

    /**
     * Get the array of cards that make up the deck
     * @return the deck's array of cards
     */
    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }



}


