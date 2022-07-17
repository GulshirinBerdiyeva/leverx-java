package com.leverx.course.scanner;

import com.leverx.course.validator.Validator;

import java.util.Scanner;

public class PlayerNameScanner implements InputScanner<String> {
    private final Validator PLAYER_NAME_VALIDATOR;

    public PlayerNameScanner(Validator PLAYER_NAME_VALIDATOR) {
        this.PLAYER_NAME_VALIDATOR = PLAYER_NAME_VALIDATOR;
    }

    @Override
    public String scan(Scanner scanner) {
        String name;
        boolean flag;
        do {
            System.out.println("Enter your name: ");

            flag = false;
            name = scanner.nextLine();

            boolean isValid = PLAYER_NAME_VALIDATOR.isValid(name);

            if (!isValid) {
                flag = true;
                System.out.println("\n\t\tName format: only LETTERS in range from [2 20]");
            }
        } while (flag);

        return name;
    }
}
