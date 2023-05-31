import java.util.*;
public class Pile {
    LinkedList<Card> tablePile;

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

}



