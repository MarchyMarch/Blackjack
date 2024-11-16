package shared.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        for(Suite suite: Suite.values()){
            for (CardValue rank: CardValue.values()){
                cards.add(new Card(suite, rank));
            }
        }
    }

    public String toSting() {
        StringBuilder sb = new StringBuilder("Deck: \n");
        for (Card card : cards){
            sb.append(card.getSuite()).append("\t").append(card.getValue()).append("\n");
        }
        return sb.toString();
    }
}
