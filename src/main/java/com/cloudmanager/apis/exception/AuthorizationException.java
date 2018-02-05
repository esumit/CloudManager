package com.cloudmanager.apis.exception;

import javax.ws.rs.ext.Provider;


public class AuthorizationException extends RuntimeException {


    private static final String PREFIX = "AUTH_REQ: ";


    public AuthorizationException(String s, Exception e) {
        super(PREFIX + s, e);
    }

    public AuthorizationException(String s) {
        super(PREFIX + s);
    }

}
