package com.leverx.course;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter some short line for manipulating with it :)");
            return;
        }

        String value = String.join(" ", args);

        var stringTransformer = new StringTransformer();

        stringTransformer.transform(value);
    }
}