package server.server.commands;

import server.model.AccountManager;
import shared.commands.AbstractCommand;
import shared.commands.AbstractLoginCommand;
import shared.model.AuthToken;
import shared.model.User;

public class LoginCommand extends AbstractLoginCommand {
    public LoginCommand(){};
    public LoginCommand(String usr, String pwd){
        username = usr;
        password = pwd;
    }
    @Override
    public Object execute() throws Exception {
        AuthToken token = AccountManager.getInstance().login(username, password);

        if (token == null)
        {
            throw new Exception("Incorrect username or password");
        }

        System.out.println(username + " has logged in");

        return token;
    }

    @Override
    public Object execute(User originUser) throws Exception {
        return execute();
    }
}
