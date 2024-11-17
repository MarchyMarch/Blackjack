package server.server;

import server.model.AccountManager;

public class Main {
    public static void main(String[] args){
        AccountManager.getInstance().initialize();
        ServerCommunicator.getInstance().start();
    }
}
