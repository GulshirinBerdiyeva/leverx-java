package com.leverx.course.validator;

import java.util.regex.Pattern;

public class GameStatusValidator implements Validator {
    private static final String REGEX = "[123]";

    @Override
    public boolean isValid(String value) {
        return (value != null) && Pattern.matches(REGEX, value);
    }
}
