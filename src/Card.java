import java.util.Objects;

public class Card {

    public int cardRank;

    public String cardSuit;

    boolean is_black;

    boolean is_face_up;

    // Constructor for card objects
    public Card(int rank, String suit){

        cardRank = rank;

        cardSuit = suit;

        // colour can be differentiated by suit (S & C = Spades & Clubs)
        if (suit.equals("S") || suit.equals("C")){
            is_black = true;
        }

    }


    // getters and setters for Cards; Suit and Rank are already set by constructor
    public String getCardSuit(){
        return cardSuit;
    }

    public int getCardRank(){return cardRank;}

    public boolean getCardDirection(){
        return is_face_up;
    }

    public void setCardDirection(Boolean flipped){
        is_face_up = flipped;
    }


    public String toString() {
        return cardSuit + cardRank;
    }

}
