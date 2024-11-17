package shared.model;

import java.util.UUID;

public class Table {
    private UUID id;
    private int minBet;
    private int minCardBeforeShuffle;
    private Shoe shoe;
    private int numberPlayers;
    private boolean isOpen;

    public Table(){
        this.id = UUID.randomUUID();
    }

    public void joinTable(User user) {

    }

    // **** Getters and Setters ****/

    public UUID getId() {
        return id;
    }

    public int getMinBet() {
        return minBet;
    }

    public void setMinBet(int minBet) {
        this.minBet = minBet;
    }

    public int getMinCardBeforeShuffle() {
        return minCardBeforeShuffle;
    }

    public void setMinCardBeforeShuffle(int minCardBeforeShuffle) {
        this.minCardBeforeShuffle = minCardBeforeShuffle;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public int getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

}
