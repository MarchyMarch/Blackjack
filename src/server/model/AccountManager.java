package server.model;

import shared.interfaces.IAuthentication;
import shared.model.Account;
import shared.model.AuthToken;
import shared.model.Role;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AccountManager implements IAuthentication {
    private Map<String, Account> accounts = new HashMap<>();
    private static final String FILE_PATH = "src/server/res/data.txt"; // File to store accounts
    private static AccountManager instance = null;

    private AccountManager() {
        this.accounts = new HashMap<String, Account>();
        loadAccounts();
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }

        return instance;
    }

    public void initialize(){
        loadAccounts();
    };

    private void loadAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String username = parts[0];
                    String password = parts[1];
                    Role role;
                    try {
                        role = Role.valueOf(parts[2].toUpperCase()); // Convert to Uppercase to match enum constants
                    } catch (IllegalArgumentException e) {
                        System.err.println("Invalid role for user " + username + ": " + parts[2]);
                        continue; // Skip this account if the role is invalid
                    }
                    accounts.put(username, new Account(username, password, role));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading accounts: " + e.getMessage());
        }
    }


    @Override
    public AuthToken login(String username, String password) {
        Account account = accounts.get(username);
        boolean isValid = account != null && account.getPassword().equals(password); // Check credentials

        if (isValid) {
            account.setToken(AuthToken.generateAuthToken());
            return account.getToken();
        }

        return null;
    }

    @Override
    public AuthToken register(String username, String password, Role role) throws Exception {
        // TODO: create a way to register new account
        return null;
    }
}

