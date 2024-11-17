package shared.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
    private List<Card> cards;

    public Shoe(){
        this.cards = new ArrayList<Card>();

        for (int i = 0; i < Constants.NUMBER_OF_DECKS; i++){
            this.cards.addAll(new Deck().getCards());
        }

        this.shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addDeck() {
        this.cards.addAll(new Deck().getCards());
        this.shuffle();
    }

    public int size() {
        return this.cards.size();
    }

    public Card dealCard(){
        return cards.remove(0);
    }
}
