package com.leverx.course.scanner;

import com.leverx.course.entity.GameStatus;
import com.leverx.course.validator.Validator;

import java.util.Scanner;

public class GameStatusScanner implements InputScanner<GameStatus> {
    private final Validator GAME_STATUS_VALIDATOR;

    public GameStatusScanner(Validator GAME_STATUS_VALIDATOR) {
        this.GAME_STATUS_VALIDATOR = GAME_STATUS_VALIDATOR;
    }

    @Override
    public GameStatus scan(Scanner scanner) {
        boolean flag;
        do {
            flag = false;

            System.out.println("\n\t1 -> CONTINUE");
            System.out.println("\t2 -> CHANGE OPPONENT");
            System.out.println("\t3 -> EXIT");

            String value = scanner.nextLine();

            boolean isValid = GAME_STATUS_VALIDATOR.isValid(value);

            if (isValid) {
                switch (value) {
                    case "1":
                        return GameStatus.CONTINUE;
                    case "2":
                        return GameStatus.CHANGE_OPPONENT;
                    default:
                        return GameStatus.EXIT;
                }

            } else {
                System.out.println("\n\t\tEnter 1, 2 or 3");
                flag = true;
            }
        } while (flag);

        return GameStatus.UNKNOWN;
    }
}
