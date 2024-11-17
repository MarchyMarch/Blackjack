package shared.interfaces;

import shared.model.AuthToken;
import shared.model.Role;

public interface IAuthentication {
    AuthToken login(String username, String password) throws Exception;
    AuthToken register(String username, String password, Role role) throws Exception;
}
