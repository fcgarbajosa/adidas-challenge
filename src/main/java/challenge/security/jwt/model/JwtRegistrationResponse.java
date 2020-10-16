package challenge.security.jwt.model;

import java.io.Serializable;

public class JwtRegistrationResponse implements Serializable {

    private static final long serialVersionUID = -4309567358824249222L;

    private String username;

    public JwtRegistrationResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
