import java.util.*;
public class Table {

    public Table(Deck _deck, int startingCount){

       LinkedList <Card> tablePile = new LinkedList<Card>();

       for (int i = 1; i <= startingCount; i++){

               tablePile.add(_deck.pullTopCard());

           }

       }





       public static void createTablePiles(){

           for (int i = 1; i <= 7; i++){
               Table tablepile1 = new Table(,i);

       }






    }



