public class Main {

    public static void main(String[] args){

        Deck deckInstance = new Deck();
        deckInstance.createDeck();


        int startingCount = 0;

        Pile pileInstance = new Pile(deckInstance, startingCount);

        for (int i = 1; i <= 7; i++) {
            Pile tablepile1 = new Pile(deckInstance, i);




    }
}
