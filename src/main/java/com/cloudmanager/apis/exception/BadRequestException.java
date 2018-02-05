
package com.cloudmanager.apis.exception;

import javax.ws.rs.ext.Provider;

public class BadRequestException extends RuntimeException {
    private static final String PREFIX = "BAD_REQ: ";


    public BadRequestException(String s, Exception e) {
        super(PREFIX + s, e);
    }

    public BadRequestException(String s) {
        super(PREFIX + s);
    }
}
