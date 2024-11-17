package client.network_comm;

import shared.interfaces.IAuthentication;
import shared.model.AuthToken;
import shared.model.Role;

public class Authentication implements IAuthentication {
    @Override
    public AuthToken login(String username, String password) throws Exception {
        return null;
    }

    @Override
    public AuthToken register(String username, String password, Role role) throws Exception {
        return null;
    }
}
