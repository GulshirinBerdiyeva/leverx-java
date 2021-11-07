package com.leverx.course.scanner;

import java.util.Scanner;

public interface InputScanner<T> {
    T scan(Scanner scanner);
}
