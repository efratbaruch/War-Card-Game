import java.util.List;
import java.util.ArrayList;

public class Game {

    Deck deck;
    Hand handOfPlayer1;
    Hand handOfPlayer2;
    List<Card> cardsOnTable = new ArrayList<>();

    void runGame(){
        readyTheGame();
        startGame();
        play();
        endGame();
    }

    private void readyTheGame(){
        deck = new Deck();
        deck.createDeckForGame();
        handOfPlayer1 = new Hand(deck.player1);
        handOfPlayer2 = new Hand(deck.player2);
    }

    private void startGame(){
        System.out.println("Welcome to the mighty War Game!");
        System.out.println("Lets begin to play!");
        handOfPlayer1.getPlayerName();
        handOfPlayer2.getPlayerName();
    }

    private void play() {
        while (!handOfPlayer1.hand.isEmpty() && !handOfPlayer2.hand.isEmpty()) {
            Moves moves = new Moves();
            moves.normalMove(handOfPlayer1, handOfPlayer2, cardsOnTable);
            System.out.println(handOfPlayer1.hand.size()+" "+handOfPlayer2.hand.size());
        }
    }

    private void endGame(){
        if (handOfPlayer1.hand.isEmpty()){
            System.out.println(handOfPlayer2.name+" is the winner!!!");
        }
        else {
            System.out.println(handOfPlayer1.name+" is the winner!!!");
        }
        System.out.println("Goodbye!");
    }
}