package shared.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        for(Suite suite: Suite.values()){
            for (CardValue rank: CardValue.values()){
                cards.add(new Card(suite, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String toSting() {
        StringBuilder sb = new StringBuilder("Deck: \n");
        for (Card card : cards){
            sb.append(card.getSuit()).append("\t").append(card.getValue()).append("\n");
        }
        return sb.toString();
    }
}
