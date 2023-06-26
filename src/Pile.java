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

    public Pile() {

        tablePile = new LinkedList<Card>();
    }


    public Pile(Deck deckInstance, int startingCount) {

        tablePile = new LinkedList<Card>();

        for (int i = 1; i <= startingCount; i++) {

            tablePile.add(deckInstance.pullTopCard());

        }

    }


    // toString override for printing table piles
    public String toString() {
        return tablePile.toString();
    }


    public int getSize() {
        return tablePile.size();
    }

    public Card get(int index) {
        return tablePile.get(index);
    }

    public void remove(int index){
        tablePile.remove(index);
    }
    public void add(Card movedCard){
        tablePile.add(movedCard);
    }


}



