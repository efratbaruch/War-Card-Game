import java.util.List;
import java.util.Scanner;

public class Hand {

    String name;
    List<Card> hand;

    Hand(List<Card> hand){
        this.hand = hand;
    }

    void getPlayerName(){
        System.out.println("Player, What is your name?");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.next();
    }

    Card drawCard(){
        if(!hand.isEmpty()) {
            Card currentCard = hand.get(0);
            hand.remove(currentCard);
            return currentCard;
        }
        else return null;
    }

    void addCards(List<Card> winnings){
        hand.addAll(winnings);
    }
}