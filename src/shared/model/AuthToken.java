package shared.model;

import java.util.UUID;

public class AuthToken {
    private final String token;

    private AuthToken(){
        token = UUID.randomUUID().toString();
    }

    public static AuthToken generateAuthToken() {
        return new AuthToken();
    }

    public String getToken() {
        return token;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        final AuthToken other = (AuthToken) obj;
        return this.token.equals(other.getToken());
    }
}
