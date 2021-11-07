package com.leverx.course.scanner;

import com.leverx.course.entity.Figure;
import com.leverx.course.validator.Validator;

import java.util.Scanner;

public class FigureScanner implements InputScanner<Figure> {
    private final Validator FIGURE_VALIDATOR;

    public FigureScanner(Validator FIGURE_VALIDATOR) {
        this.FIGURE_VALIDATOR = FIGURE_VALIDATOR;
    }

    @Override
    public Figure scan(Scanner scanner) {
        Figure figure = Figure.UNKNOWN;
        boolean flag;
        do {
            flag = false;

            System.out.println("\tEnter X or O");

            String value = scanner.nextLine();

            boolean isValid = FIGURE_VALIDATOR.isValid(value);

            if (isValid) {
                return Figure.valueOf(value.toUpperCase());
            } else {
                flag = true;
            }
        } while (flag);

        return figure;
    }
}
