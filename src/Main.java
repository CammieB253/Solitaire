import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Deck deckInstance = new Deck();
        deckInstance.createDeck();

        Pile[] tablePiles = new Pile[7];

        // uses the constructor from the Pile class to create a new pile (singleTablePile)
        // "i" determines the amount of cards to be placed in each pile
        // "tablePiles" array stores each of our singleTablePile arraylists
        for (int i = 1; i <= 7; i++) {
            Pile singleTablePile = new Pile(deckInstance, i);
            tablePiles[i-1] = singleTablePile;

        }

        // print loop for testing
        for (int counter = 0; counter <= 7; counter++) {
            System.out.println(tablePiles[counter]);
        }



    }
}

