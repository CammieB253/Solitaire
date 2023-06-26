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

    // Constructor for card objects
    public Card(int rank, String suit) {

        cardRank = rank;

        cardSuit = suit;

        // colour can be differentiated by suit (S & C = Spades & Clubs)
        if (suit.equals("S") || suit.equals("C")) {
            is_black = true;
        }

        is_face_up = false;
    }


    // getters and setters for Cards; Suit and Rank are already set by constructor
    public String getCardSuit() {
        return cardSuit;
    }

    public int getCardRank() {
        return cardRank;
    }

    public boolean getCardColour() {
        return is_black;
    }

    public boolean getCardDirection() {
        return is_face_up;
    }

    public void flip() {
        is_face_up = getCardDirection();
        is_face_up = !is_face_up;
    }


    // toString override for printing cards
    public String toString() {
        if (!is_face_up){
            return "XX";
        }

        return cardSuit + cardRank;
    }




    }
