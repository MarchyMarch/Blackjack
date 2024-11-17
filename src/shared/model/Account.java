package shared.model;

public class Account {
    private User user;
    private String username;
    private String password;
    private double balance;
    private Role role;
    private AuthToken token;

    public Account(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        if(role == Role.DEALER) {
            this.user = new Dealer();
        } else {
            this.user = new Player();
        }
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AuthToken getToken() {
        return token;
    }

    public void setToken(AuthToken token) {
        this.token = token;
    }
}
