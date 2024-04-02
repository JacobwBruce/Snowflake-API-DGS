package com.amex.snowflake.authentication;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.servlet.http.HttpServletRequest;

public class AuthenticationService {

    private static String API_KEY = "abc";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader("Authorization");

        if(apiKey == null || apiKey.isEmpty() || !apiKey.equals("Key " + API_KEY)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
