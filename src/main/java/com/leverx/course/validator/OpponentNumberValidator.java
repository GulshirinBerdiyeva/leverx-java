package com.leverx.course.validator;

import java.util.regex.Pattern;

public class OpponentNumberValidator implements Validator {
    private static final String REGEX = "[12]";

    @Override
    public boolean isValid(String value) {
        return (value != null) && Pattern.matches(REGEX, value);
    }
}
