import java.util.Objects;

public class Card {

    private int cardRank;

    private String cardSuit;

    boolean is_black;

    boolean is_face_up;


    public Card(int rank, String suit){

        cardRank = rank;

        cardSuit = suit;

        if (suit.equals("S") || suit.equals("C")){
            is_black = true;
        }

    }

    public String getCardSuit(){
        return cardSuit;
    }

    public int getCardRank(){
        return cardRank;
    }

    public boolean getCardDirection(){
        return is_face_up;
    }

    public void setCardDirection(Boolean flipped){
        is_face_up = flipped;
    }



}
