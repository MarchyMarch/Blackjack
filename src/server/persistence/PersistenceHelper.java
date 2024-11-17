package server.persistence;

public class PersistenceHelper {
    private static PersistenceHelper instance = null;

    private PersistenceHelper() {

    }

    public PersistenceHelper getInstance() {
        if (instance == null) {
            instance = new PersistenceHelper();
        }

        return instance;
    }
}
