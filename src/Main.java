import java.util.*;

public class Main {
    static Pile[] tablePiles;

    public static void main(String[] args) {

        Deck deckInstance = new Deck();
        deckInstance.createDeck();

        LinkedList<Card> drawPile = new LinkedList<Card>();

        tablePiles = new Pile[7];

        // uses the constructor from the Pile class to create a new pile (singleTablePile)
        // "i" determines the amount of cards to be placed in each pile
        // "tablePiles" array stores each of our singleTablePile arraylists
        for (int i = 1; i <= 7; i++) {
            Pile singleTablePile = new Pile(deckInstance, i);
            tablePiles[i - 1] = singleTablePile;

        }

        for (int i = 1; i <= 7; i++) {

            Card topCard = tablePiles[i-1].get(tablePiles[i-1].getSize());
            tablePiles[i-1].remove(tablePiles[i-1].getSize());
            topCard.flip();
            tablePiles[i-1].add(topCard);
        }

        System.out.println(deckInstance.cardDeck);

        Pile[] acePiles = new Pile[4];

        for (int i = 0; i <= 3; i++) {

            Pile aceSpace = new Pile();

            acePiles[i] = aceSpace;
        }


        Card movedCard;
        Card locationCard;


        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println();
            //currentBoard.describe();

            // @@PRINT LOOP@@

            String out = "";

            for (int counter = 1; counter < 7+1; counter++) {
                out += "P" + counter + "\t \t" ;
            }
            out += "\n";

            for (int currentRow = 0 ; currentRow < tablePiles.length ; currentRow++ ) {
                for (Pile currentPile : tablePiles) {
                 if(currentRow < currentPile.getSize()) {
                        out +=  currentPile.get(currentRow).toString() + "\t \t";
                    }
                }
                out += "\n";
            }

            System.out.println(out);

            // @@PRINT LOOP@@

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

                System.out.println("Which pile do you want to move this card to?");
                System.out.println("(Only type the pile you want to move to, such as P6 or A2)");

                String dest = input.nextLine();
                int destinationPile = Integer.parseInt(String.valueOf(dest.charAt(1)));
                String pileDifferentiator = String.valueOf(dest.charAt(0));

                Main mainInstance = new Main();
                mainInstance.moveCard(sourceIndex - 1, sourcePile - 1, destinationPile - 1, pileDifferentiator);

            } else if (command.equals("draw")){
                Main mainInstance = new Main();
                mainInstance.wastePileDraw(drawPile, deckInstance);
                System.out.println(drawPile);

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
                System.out.println("Unknown command entered");
            }
        }


    }

    public void moveCard(int sourceIndex, int sourcePile, int destinationPile, String pileDifferentiator) {

        Pile specifiedPile = tablePiles[sourcePile];
        Card movedCard = specifiedPile.get(sourceIndex);

        Boolean validMove = validateMove(sourceIndex, sourcePile, destinationPile, movedCard, pileDifferentiator);

        if (validMove) {
            specifiedPile.remove(sourceIndex);
            specifiedPile = tablePiles[destinationPile];
            specifiedPile.add(movedCard);
        }else{
            System.out.println("Invalid move");
        }
    }


    public Boolean validateMove(int sourceIndex, int sourcePile, int destinationPile, Card movedCard, String pileDifferentiator) {

        Boolean valid = false;

        Pile specifiedPile = tablePiles[destinationPile];
        Card destinationCard = specifiedPile.get(specifiedPile.getSize() - 1);

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


        if (Objects.equals(pileDifferentiator, "A")) {

        } else if (!Objects.equals(movedSuit, destinationSuit)) {
            valid = false;

        } else if ((destinationRank + 1) != movedRank) {
            valid = false;


        } else if (Objects.equals(pileDifferentiator, "P")) {

            if (destinationColour == movedColour) {
                valid = false;

            } else if ((destinationRank - 1) != movedRank) {
                valid = false;
            }

        } return valid;
    }

    public LinkedList<Card> wastePileDraw (LinkedList<Card> drawPile, Deck deckInstance){

        Card drawnCard = deckInstance.pullTopCard();

        drawPile.add(drawnCard);

        if (drawPile.size() > 3){
            deckInstance.cardDeck.add(0, drawPile.get(0));
            drawPile.remove(0);
        }

        return drawPile;
    }
}



