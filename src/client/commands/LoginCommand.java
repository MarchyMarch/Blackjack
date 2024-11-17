package client.commands;

import shared.commands.AbstractLoginCommand;
import shared.model.User;

public class LoginCommand extends AbstractLoginCommand {
    public LoginCommand(){};
    public LoginCommand(String usr, String pwd){
        username = usr;
        password = pwd;
    }

    @Override
    public Object execute() throws Exception {
        return true;
    }

    @Override
    public Object execute(User originUser) throws Exception {
        return execute();
    }
}
