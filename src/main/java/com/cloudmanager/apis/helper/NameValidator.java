package com.cloudmanager.apis.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * it should be a single word, only letters and with at
 * least 3 characters and at top 30 characers.
 */
public class NameValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String NAME_PATTERN =
            "[a-zA-Z0-9]{3,60}";

    public NameValidator() {
        pattern = Pattern.compile(NAME_PATTERN);
    }

    /**
     * Validate password with regular expression
     *
     * @param password password for validation
     * @return true valid password, false invalid password
     */
    public boolean validate(final String password) {

        matcher = pattern.matcher(password);
        return matcher.matches();

    }
}
