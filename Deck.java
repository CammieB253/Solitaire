public class Deck {



   public Deck(){

   }

    public static void createDeck(){

       Card[] cardDeck = {};

       String[] suitList = {"S", "C", "H", "D"};

       int index = 0;

       for (int i = suitList.length;;){

           for (int x = 14;;){

               cardDeck[index] = new Card(x, suitList[i]);

               index++;
           }
       }


    }













    public static void originalDeck() {

        // fill an array with a deck of cards, either hard coded card generation or CSV file
        // Rank, Suit, Colour can be determined from suit through another method
        // Examples of cards represented in data: 1C (Ace, Clubs), 5H (5, Hearts), 14 (empty space), 12S (Queen, Spades)

        String[] mainDeck = {};

        int i = 0;
        int rank = 0;
        String suit = "A";

        for (i = 0; i == 52; i++) {

            int counter = 0;

            if (counter > 14) {
                counter = 0;
            }

            rank = counter + 1;
            counter++;


            if (i >= 14 && i <= 26) {
                suit = "S";
            } else if (i >= 28 && i <= 39) {
                suit = "H";
            } else if (i >= 40 && i <= 52) {
                suit = "D";
            }

            mainDeck[i] = (rank + suit);

        }

        for (int x = 0; x >= mainDeck.length;) {
            System.out.println(mainDeck[x]) ;
        }


    }






    // method to shuffle the previous array - random number generation, fill a new array with data from last array

}
