package shared.model;

public class Card {
    private Suite suit;
    private CardValue value;
    private boolean shown = true;

    public Card(Suite suite, CardValue value) {
        this.suit = suite;
        this.value = value;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public void setSuit(Suite suit) {
        this.suit = suit;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }

    public Suite getSuit() {
        return suit;
    }

    public void toggleIsShown() {
        this.shown = !this.shown;
    }

    public int getNumericalValue() {
        return switch (this.value) {
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case TEN, JACK, QUEEN, KING -> 10;
            default -> 1;
        };
    }

    public String toString() {
        return String.valueOf(getValue()) + "-" +
                getSuit();
    }
}
