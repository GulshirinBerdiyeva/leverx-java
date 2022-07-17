package com.leverx.course.validator;

import java.util.regex.Pattern;

public class BoardNumberValidator implements Validator {
    private static final String REGEX = "[1-9]";

    @Override
    public boolean isValid(String value) {
        return (value != null) && Pattern.matches(REGEX, value);
    }
}
