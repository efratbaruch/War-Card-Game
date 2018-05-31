import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> deck = new ArrayList<>();
    List<Card> player1 = new ArrayList<>();
    List<Card> player2 = new ArrayList<>();

    void createDeckForGame(){
        generateDeck();
        shuffleDeck();
        splitDeck();
    }

    private void generateDeck(){
        String[] cardType = {"Heart", "Diamond", "Club", "Pike"};
        for(String type: cardType){
            for(int i=1; i<14; i++){
                Card card = new Card(i, type);
                deck.add(card);
            }
        }
    }

    private void shuffleDeck(){
        Collections.shuffle(deck);
    }

    private void splitDeck(){
        player1.addAll(deck.subList(0, 26));
        player2.addAll(deck.subList(26, 52));
    }
}