package com.auth.Token;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String token;

    public JwtAuthenticationToken(String token) {
        super(null);
        this.token = token;
        setAuthenticated(false);
    }

    public String getToken() { return token; }

    @Override
    public String getCredentials() { return token; }

    @Override
    public String getPrincipal() { return null; }
}
