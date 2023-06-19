import java.lang.reflect.Field;
import java.util.Collections;
import java.util.*;

public class Main {
    static Pile[] tablePiles;

    public static void main(String[] args) {

        Deck deckInstance = new Deck();
        deckInstance.createDeck();

        tablePiles = new Pile[7];

        // uses the constructor from the Pile class to create a new pile (singleTablePile)
        // "i" determines the amount of cards to be placed in each pile
        // "tablePiles" array stores each of our singleTablePile arraylists
        for (int i = 1; i <= 7; i++) {
            Pile singleTablePile = new Pile(deckInstance, i);
            tablePiles[i - 1] = singleTablePile;

        }


        Pile[] acePiles = new Pile[4];

        for (int i = 0; i <= 3; i++) {

            Pile aceSpace = new Pile();

            acePiles[i] = aceSpace;
        }

        // print loop for testing
        for (int counter = 0; counter <= 6; counter++) {
            System.out.println("pile " + (counter + 1) + "; ");
            System.out.println(tablePiles[counter]);
        }

        Card movedCard;
        Card locationCard;


        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println();
            //currentBoard.describe();

            // code should display the table and piles in a fashion like this;
            // XX representing face-down card

            //   P1   P2   P3   P4   P5   P6   P7
            //   C5   XX   XX   XX   XX   XX   XX
            //        S8   XX   XX   XX   XX   XX
            //             H3   XX   XX   XX   XX
            //                  C1   XX   XX   XX
            //                       H12  XX   XX
            //                            S7   XX
            //                                 D9

            // user should then be asked which card/pile to move and which card/pile should be the destination
            // i.e S8 P2 to D9 P7

            System.out.print("> ");
            String command = input.nextLine().toLowerCase();


            if (command.equals("move")) {
                System.out.println("Which card do you want to move, and from which pile?");

                Pile requestedTablePile = tablePiles[0];
                int pileLength = requestedTablePile.getSize();

                System.out.println("type the card's position in the pile first: ");

                int sourceIndex = Integer.parseInt(input.nextLine());

                System.out.println("Now type which pile this card is in: ");
                String src = input.nextLine();
                int sourcePile = Integer.parseInt(String.valueOf(src.charAt(1)));


                // line for testing
                System.out.println("Card is at position " + sourceIndex + " within " + sourcePile);

                System.out.println("Which pile do you want to move this card to?");
                System.out.println("(Only type the pile you want to move to, such as P6 or A2)");

                String dest = input.nextLine();
                int destinationPile = Integer.parseInt(String.valueOf(dest.charAt(1)));
                System.out.println(destinationPile);

                Main mainInstance = new Main();
                mainInstance.moveCard(sourceIndex-1, sourcePile-1, destinationPile-1);


                // print loop for testing
                for (int counter = 0; counter <= 6; counter++) {
                    System.out.println("pile " + (counter + 1) + "; ");
                    System.out.println(tablePiles[counter]);
                }

            } else if (command.equals("exit")) {
                // Ask user if they really want to quit
                System.out.print("Are you sure you want to quit? ");
                String choice = input.nextLine().toLowerCase();

                if (choice.equals("yes") || choice.equals("y")) {
                    // They choose to quit
                    System.out.println("Exiting game...");
                    System.exit(0);
                }


            } else {
                // Unknown command entered
                System.out.println("Unknown command entered \nPlease enter one of the on-screen options");
            }
        }


    }

    public void moveCard(int sourceIndex, int sourcePile, int destinationPile) {

        Pile specifiedPile = tablePiles[sourcePile];
        Card movedCard = specifiedPile.get(sourceIndex);
        Boolean validMove = validateMove(sourceIndex, sourcePile, destinationPile, movedCard);

        if (validMove = true) {
            specifiedPile.remove(sourceIndex);
            specifiedPile = tablePiles[destinationPile];
            specifiedPile.add(movedCard);
        }
    }


    public Boolean validateMove(int sourceIndex, int sourcePile, int destinationPile, Card movedCard) {

        Boolean valid = true;

        Pile specifiedPile = tablePiles[destinationPile];
        Card destinationCard = specifiedPile.get(specifiedPile.getSize()-1);

        // get suit and rank of the card being moved
        String movedSuit = movedCard.getCardSuit();
        int movedRank = movedCard.getCardRank();
        Boolean movedColour = movedCard.getCardColour();

        // get attributes of top card
        // no visual code set up, therefore data structure only
        // moves will have to be done through commands
        // user will type where they want the card to be moved to, designated "location"

        String destinationSuit = destinationCard.getCardSuit();
        int destinationRank = destinationCard.getCardRank();
        Boolean destinationColour = destinationCard.getCardColour();

        // pseudocode //

        // Ace Space
        if ((destinationRank == 0) || (movedRank == 1)) {
            valid = true;
        }

        // if card is being moved to ace space; - create method for moving cards, replace pseudocode
        if (!Objects.equals(movedSuit, destinationSuit)) {
            valid = false;
        } else if ((destinationRank + 1) != movedRank) {
            valid = false;
        }

        // if card is being moved to regular pile; - create method for moving cards, replace pseudocode
        if (destinationColour == movedColour) {
            valid = false;
        } else if ((destinationRank - 1) != movedRank) {
            valid = false;
        }

        return valid;
    }
}


