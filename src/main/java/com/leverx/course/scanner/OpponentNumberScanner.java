package com.leverx.course.scanner;

import com.leverx.course.entity.Role;
import com.leverx.course.validator.Validator;

import java.util.Scanner;

public class OpponentNumberScanner implements InputScanner<Role> {
    private final Validator OPPONENT_NUMBER_VALIDATOR;

    public OpponentNumberScanner(Validator OPPONENT_NUMBER_VALIDATOR) {
        this.OPPONENT_NUMBER_VALIDATOR = OPPONENT_NUMBER_VALIDATOR;
    }

    @Override
    public Role scan(Scanner scanner) {
        boolean flag;
        do {
            flag = false;

            System.out.println("\t1 -> play with FRIEND");
            System.out.println("\t2 -> play with COMPUTER");

            String value = scanner.nextLine();

            boolean isValid = OPPONENT_NUMBER_VALIDATOR.isValid(value);

            if (isValid) {
                return ("1".equals(value)) ? Role.PLAYER : Role.COMPUTER;
            } else {
                System.out.println("\n\t\tEnter 1 or 2");
                flag = true;
            }
        } while (flag);

        return Role.UNKNOWN;
    }
}
