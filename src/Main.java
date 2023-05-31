import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Deck deckInstance = new Deck();
        deckInstance.createDeck();

        int startingCount = 0;

        Pile[] tablePiles = new Pile[7];

        for (int i = 0; i <= 6; i++) {
            Pile tablePile1 = new Pile(deckInstance, i);
            tablePiles[i] = tablePile1;

        }

        for (int counter = 0; counter <= 7; counter++) {
            System.out.println(tablePiles[counter]);
        }



        }

    }