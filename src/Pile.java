/**
 * Pile class
 * Contains constructor for piles
 * Contains method for creating table piles
 * Contains methods for getting size of piles and cards from piles
 * Contains methods for adding and removing cards from piles
 *
 * @author Cameron Buchan
 */

import java.util.*;
public class Pile {
    LinkedList<Card> tablePile;

    /**
     * Constructor for initialising table piles
     */
    public Pile() {

        tablePile = new LinkedList<Card>();
    }

    /**
     * Method for creating the 7 main table piles
     * @param deckInstance instance of the deck class
     * @param startingCount integer to determine amount of cards in a pile
     */
    public Pile(Deck deckInstance, int startingCount) {

        tablePile = new LinkedList<Card>();

        for (int i = 1; i <= startingCount; i++) {

            tablePile.add(deckInstance.pullTopCard());

        }

    }


    /**
     * toString override for printing contents of table piles
     * @return the contents of the table pile as string values
     */
    public String toString() {
        return tablePile.toString();
    }

    /**
     * gets the size of a table pile
     * @return the size of a table pile
     */
    public int getSize() {
        return tablePile.size();
    }

    /**
     * gets a card from a specified index within a table pile
     * @param index the position of the specified card
     * @return the specified card object
     */
    public Card get(int index) {
        return tablePile.get(index);
    }

    /**
     * removes a card from a specified index within a table pile
     * @param index the position of the specified card
     */
    public void remove(int index){
        tablePile.remove(index);
    }

    /**
     * adds a card to the top of a table pile
     * @param movedCard the card being moved to the top of the table pile
     */
    public void add(Card movedCard){
        tablePile.add(movedCard);
    }


}



