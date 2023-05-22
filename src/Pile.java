import java.util.*;
public class Pile {

    public Pile(Deck deckInstance, int startingCount) {

        LinkedList<Card> tablePile = new LinkedList<Card>();

        for (int i = 1; i <= startingCount; i++) {

            tablePile.add(deckInstance.pullTopCard());

        }

    }

}



