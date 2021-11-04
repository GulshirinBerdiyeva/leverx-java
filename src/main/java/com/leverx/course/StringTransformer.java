package com.leverx.course;

import org.apache.commons.lang3.StringUtils;

public class StringTransformer {
    public void transform(String value) {
        System.out.println("Converted to lower case: " + StringUtils.lowerCase(value));

        System.out.println("Converted to upper case: " + StringUtils.upperCase(value));

        System.out.println("Replaced spaces with underscore: " + StringUtils.replace(value, " ", "_"));

        System.out.println("Reversed: " + StringUtils.reverse(value));
    }
}
