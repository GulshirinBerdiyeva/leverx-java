package com.leverx.course.scanner;

import com.leverx.course.validator.Validator;

import java.util.Scanner;

public class BoardNumberScanner implements InputScanner<String> {
    private final Validator BOARD_NUMBER_VALIDATOR;

    public BoardNumberScanner(Validator boardNumberValidator) {
        this.BOARD_NUMBER_VALIDATOR = boardNumberValidator;
    }

    @Override
    public String scan(Scanner scanner) {
        String value;
        boolean flag;
        do {
            flag = false;

            System.out.println("\tSelect cell number");

            value = scanner.nextLine();

            boolean isValid = BOARD_NUMBER_VALIDATOR.isValid(value);

            if (!isValid) {
                System.out.println("\n\t\tEnter in range from [1 9]");
                flag = true;
            }
        } while (flag);

        return value;
    }
}
