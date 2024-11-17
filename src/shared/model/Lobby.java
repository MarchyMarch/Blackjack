package shared.model;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private List<Table> tables;
    private int numTables;
    private int availableDealer;

    public Lobby() {
        this.tables = new ArrayList<Table>();
    }

    public int getAvailableDealer() {
        return availableDealer;
    }

    public void setAvailableDealer(int availableDealer) {
        this.availableDealer = availableDealer;
    }

    public int getNumTables() {
        return tables.size();
    }

    public List<Table> getTables() {
        return tables;
    }
}
