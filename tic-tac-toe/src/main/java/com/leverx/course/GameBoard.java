package com.leverx.course;

public class GameBoard {
    public void drawBoard(String[][] boardContent) {
        System.out.println("\n\t\t\t ___ ___ ___");
        System.out.printf("\t\t\t| %s | %s | %s |%n",
                boardContent[0][0], boardContent[0][1], boardContent[0][2]);
        System.out.println("\t\t\t|___|___|___|");
        System.out.printf("\t\t\t| %s | %s | %s |%n",
                boardContent[1][0], boardContent[1][1], boardContent[1][2]);
        System.out.println("\t\t\t|___|___|___|");
        System.out.printf("\t\t\t| %s | %s | %s |%n",
                boardContent[2][0], boardContent[2][1], boardContent[2][2]);
        System.out.println("\t\t\t|___|___|___|");
    }
}
