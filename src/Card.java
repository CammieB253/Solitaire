/**
 * Card class
 * Contains Constructor for card objects
 * Contains getters and setters for card objects
 *
 * @author Cameron Buchan
 */

import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

public class Card {

    public int cardRank;

    public String cardSuit;

    boolean is_black;

    boolean is_face_up;

    /**
     * Constructor for generating individual cards
     * @param rank card rank (1-13)
     * @param suit card suit (S, C, H, D)
     */
    public Card(int rank, String suit) {

        cardRank = rank;

        cardSuit = suit;

        // colour can be differentiated by suit (S & C = Spades & Clubs)
        if (suit.equals("S") || suit.equals("C")) {
            is_black = true;
        }

        is_face_up = false;
    }


    /**
     * gets suit of a card
     * @return returns card suit (S, C, H, D)
     */
    public String getCardSuit() {
        return cardSuit;
    }

    /**
     * gets rank of a card
     * @return card rank (1-13)
     */
    public int getCardRank() {
        return cardRank;
    }

    /**
     * gets colour of a card
     * @return Whether or not the card is black
     */
    public boolean getCardColour() {
        return is_black;
    }

    /**
     * get whether or not a card is flipped
     * @return card's direction
     */
    public boolean getCardDirection() {
        return is_face_up;
    }

    /**
     * Method for flipping a card
     */
    public void flip() {
        is_face_up = getCardDirection();
        is_face_up = !is_face_up;
    }


    /**
     * toString override for printing cards
     * @return Suit and rank of the card as string values
     */

    public String toString() {
        if (!is_face_up){
            return "XX";
        }

        return cardSuit + cardRank;
    }




    }
