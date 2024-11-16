package shared.model;

public class Card {
    private Suite suite;
    private CardValue value;

    public Card(Suite suite, CardValue value) {
        this.suite = suite;
        this.value = value;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }

    public Suite getSuite() {
        return suite;
    }
}
