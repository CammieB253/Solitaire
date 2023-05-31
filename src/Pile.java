import java.util.*;
public class Pile {
    LinkedList<Card> tablePile;

    public Pile(Deck deckInstance, int startingCount) {

        tablePile = new LinkedList<Card>();

        for (int i = 1; i <= startingCount; i++) {

            tablePile.add(deckInstance.pullTopCard());

        }

    }

    public String toString() {
        return tablePile.toString();
    }

}



