
package com.cloudmanager.apis.exception;

import javax.ws.rs.ext.Provider;

public class DAOException extends Exception {
    public DAOException(String s, Exception e) {
        super(s, e);
    }

    public DAOException(String s) {
        super(s);
    }
}
