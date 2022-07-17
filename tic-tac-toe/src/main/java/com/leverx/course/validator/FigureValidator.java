package com.leverx.course.validator;

import java.util.regex.Pattern;

public class FigureValidator implements Validator {
    private static final String REGEX = "[XxOo]";

    @Override
    public boolean isValid(String value) {
        return (value != null) && Pattern.matches(REGEX, value);
    }
}
