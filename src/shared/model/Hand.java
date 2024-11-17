package shared.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private boolean busted;
    private boolean canSplit;
    private boolean canDoubleDown;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public int handValue() {
        int value = 0;

        for (Card card: cards){
            if(card.getValue() == CardValue.ACE){
                if(value + Constants.ACE_HIGH > Constants.MAX_HAND_VALUE) {
                    value += Constants.ACE_LOW;
                } else {
                    value += Constants.ACE_HIGH;
                }
            } else {
                value += card.getNumericalValue();
            }
        }

        return value;
    }

    public void addCard(Card card){
        this.cards.add(card);
        calculateActions();
    }

    public boolean isBusted() {
        return busted;
    }

    public boolean canSplit() {
        return canSplit;
    }

    public boolean canDoubleDown() {
        return canDoubleDown;
    }

    //**** Helper Methods ****
    private void calculateActions(){
        calculateBust();
        calculateDoubleDown();
        calculateCanSplit();
    }

    private void calculateBust(){
        this.busted = handValue() > Constants.MAX_HAND_VALUE;
    }

    private void calculateDoubleDown() {
        if (cards.size() != 2) {
            this.canDoubleDown = false;
            return;
        }

        int value = handValue();

        canDoubleDown = value == 9 || value == 10 || value == 11;
    }

    private void calculateCanSplit(){
        if(cards.size() != 2) {
            this.canSplit = false;
            return;
        }

        Card cardOne = cards.get(0);
        Card cardTwo = cards.get(1);

        canSplit = cardOne.getValue() == cardTwo.getValue();
    }
}
