package com.leverx.course;

public class StringTransformer {
    public void transform(String value) {
        System.out.println("Converted to lower case: " + value.toLowerCase());

        System.out.println("Converted to upper case: " + value.toUpperCase());

        System.out.println("Replaced spaces with underscore: " + value.replace(' ', '_'));

        StringBuilder reversedValue = new StringBuilder(value).reverse();

        System.out.println("Reversed: " + reversedValue);
    }
}
