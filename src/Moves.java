import java.util.List;

public class Moves {

    void normalMove(Hand handOfPlayer1, Hand handOfPlayer2, List<Card> cardsOnTable){
        if(handOfPlayer1.hand.isEmpty()||handOfPlayer2.hand.isEmpty()){
            return;
        }
        Card cardP1 = handOfPlayer1.drawCard();
        cardsOnTable.add(cardP1);
        System.out.println(handOfPlayer1.name+" played "+cardP1.cardType+" "+cardP1.cardNumber);
        Card cardP2 = handOfPlayer2.drawCard();
        cardsOnTable.add(cardP2);
        System.out.println(handOfPlayer2.name+" played "+cardP2.cardType+" "+cardP2.cardNumber);
        moveResult(cardP1, cardP2, handOfPlayer1, handOfPlayer2, cardsOnTable);
    }

    private void moveResult(Card cardP1, Card cardP2, Hand handOfPlayer1, Hand handOfPlayer2, List<Card> cardsOnTable){
        if (cardP1.cardNumber>cardP2.cardNumber){
            handOfPlayer1.addCards(cardsOnTable);
            cardsOnTable.clear();
            System.out.println(handOfPlayer1.name+" takes the pot");
        }
        else if(cardP1.cardNumber==cardP2.cardNumber){
            System.out.println("War!");
            warMove(handOfPlayer1, handOfPlayer2,cardsOnTable);
        }
        else {
            handOfPlayer2.addCards(cardsOnTable);
            cardsOnTable.clear();
            System.out.println(handOfPlayer2.name+" takes the pot");
        }
    }

    private void warMove(Hand handOfPlayer1, Hand handOfPlayer2, List<Card> cardsOnTable){
        for(int i=0; i<3; i++){
            if(handOfPlayer1.hand.isEmpty()||handOfPlayer2.hand.isEmpty()){
                break;
            }
            Card cardP1 = handOfPlayer1.drawCard();
            cardsOnTable.add(cardP1);
            System.out.println(handOfPlayer1.name+" played "+cardP1.cardType+" "+cardP1.cardNumber);
            Card cardP2 = handOfPlayer2.drawCard();
            cardsOnTable.add(cardP2);
            System.out.println(handOfPlayer2.name+" played "+cardP2.cardType+" "+cardP2.cardNumber);
        }
        normalMove(handOfPlayer1, handOfPlayer2,cardsOnTable);
    }

}