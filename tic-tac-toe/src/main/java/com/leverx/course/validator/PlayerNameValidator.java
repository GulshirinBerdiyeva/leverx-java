package com.leverx.course.validator;

import java.util.regex.Pattern;

public class PlayerNameValidator implements Validator {
    private static final String REGEX = "[A-Za-z]{2,20}";

    @Override
    public boolean isValid(String value) {
        return (value != null) && Pattern.matches(REGEX, value);
    }
}
