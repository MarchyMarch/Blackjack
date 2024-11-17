package client;

import client.commands.LoginCommand;
import client.network_comm.NetworkCommunication;
import shared.model.Account;
import shared.model.AuthToken;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NetworkCommunication.getInstance();

        // Login Example
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        LoginCommand loginCmd = new LoginCommand(username, password);
        Object token = NetworkCommunication.getInstance().sendCommand(loginCmd);

        System.out.println(token.toString());
    }
}
