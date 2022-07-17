package com.leverx.course;

import com.leverx.course.entity.Figure;
import com.leverx.course.entity.Role;
import com.leverx.course.scanner.InputScanner;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private static final int COUNT = 9;

    private final GamePreparer GAME_PREPARER;
    private final GameBoard GAME_BOARD;
    private final InputScanner<String> BOARD_CELL_NUMBER_SCANNER;
    private final Scanner SCANNER;

    private String[][] boardContent;
    private int row;
    private int column;
    private int count;
    private boolean isComputer;
    private boolean gameOver;

    public GameLogic(GamePreparer gamePreparer, GameBoard gameBoard, InputScanner<String> boardCellNumberScanner, Scanner scanner) {
        this.GAME_PREPARER = gamePreparer;
        this.GAME_BOARD = gameBoard;
        this.BOARD_CELL_NUMBER_SCANNER = boardCellNumberScanner;
        this.SCANNER = scanner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void initFirstStep() {
        Role role = GAME_PREPARER.getCurrentPlayer().getROLE();
        isComputer = Role.COMPUTER.equals(role);
        if (isComputer) {
            GAME_PREPARER.beginPlayerOrComputer();
        } else {
            GAME_PREPARER.beginOneFromPlayers();
        }

        boardContent = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        count = 0;
        gameOver = false;
        GAME_BOARD.drawBoard(boardContent);
    }

    public void startGame() {
        Role role = GAME_PREPARER.getCurrentPlayer().getROLE();
        isComputer = Role.COMPUTER.equals(role);

        boolean flag;
        do {
            flag = false;

            String cellNumber = getPlayerSelectedNumber();

            if (exist(cellNumber)) {
                if (checkWin()) {
                    setWinParams();
                    GAME_BOARD.drawBoard(boardContent);
                    return;
                }
                GAME_PREPARER.swapPlayers();
                GAME_BOARD.drawBoard(boardContent);
                count++;

            } else {
                if (!isComputer) {
                    System.out.println("\n\t\tSelect an empty cell with a number!");
                }
                flag = true;
            }

            if (count == COUNT) {
                System.out.println("\n\tGAME OVER!!!");
                GAME_PREPARER.getCurrentPlayer().setWinner(false);
                GAME_PREPARER.getCurrentOpponent().setWinner(false);
                gameOver = true;
            }
        } while (flag);
    }

    private String getPlayerSelectedNumber() {
        if (!isComputer) {
            String playerName = GAME_PREPARER.getCurrentPlayer().getNAME();
            System.out.printf("\n\t%s your turn%n", playerName.toUpperCase());
            return BOARD_CELL_NUMBER_SCANNER.scan(SCANNER);

        } else {
            Random random = new Random();
            int randomCell = random.nextInt(9) + 1;
            return String.valueOf(randomCell);
        }
    }

    private boolean exist(String cellNumber) {
        for (int i = 0; i < boardContent.length; i++) {
            for (int j = 0; j < boardContent.length; j++) {
                if (cellNumber.equals(boardContent[i][j])) {
                    Figure figure = GAME_PREPARER.getCurrentPlayer().getFigure();
                    boardContent[i][j] = figure.name();
                    row = i;
                    column = j;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWin() {
        if ((row == 0 && column == 1) || (row == 1 && column == 0) ||
                (row == 1 && column == 2) || (row == 2 && column == 1)) {

            return checkTwoDirections();

        } else if ((row == 0 && column == 0) || (row == 0 && column == 2) ||
                (row == 2 && column == 0) || (row == 2 && column == 2)) {

            return checkThreeDirections();

        } else if (row ==1 && column == 1) {
            return checkFourDirections();
        }

        return false;
    }

    private boolean checkTwoDirections() {
        int count = 0;
        for (int i = 0; i < boardContent.length - 1; i++) {
            if (boardContent[row][i].equals(boardContent[row][i + 1])) {
                count ++;
            }
        }

        if (count != boardContent.length - 1) {
            count = 0;
            for (int i = 0; i < boardContent.length - 1; i++) {
                if (boardContent[i][column].equals(boardContent[i + 1][column])) {
                    count ++;
                }
            }
        }
        return count == boardContent.length - 1;
    }

    private boolean checkThreeDirections() {
        boolean winFlag = checkTwoDirections();
        if (winFlag) {
            return true;

        } else {
            int count = 0;
            if (row == column) {
                for (int i = 0; i < boardContent.length - 1; i++) {
                    if (boardContent[i][i].equals(boardContent[i + 1][i + 1])) {
                        count++;
                    }
                }
            } else {
                int j = boardContent.length - 1;
                for (int i = 0; i < boardContent.length - 1; i++, j--) {
                    if (boardContent[i][j].equals(boardContent[i + 1][j - 1])) {
                        count++;
                    }
                }
            }
            return count == boardContent.length - 1;
        }
    }

    private boolean checkFourDirections() {
        return checkTwoDirections() || checkThreeDirections();
    }

    private void setWinParams() {
        String playerName = GAME_PREPARER.getCurrentPlayer().getNAME();
        System.out.printf("\n\t%s WINNER, CONGRATULATION!!!%n", playerName.toUpperCase());

        GAME_PREPARER.getCurrentPlayer().setWinner(true);
        GAME_PREPARER.getCurrentOpponent().setWinner(false);
        gameOver = true;
    }

    public void resetIfComputerIsWinner() {
        Role role = GAME_PREPARER.getCurrentPlayer().getROLE();
        isComputer = Role.COMPUTER.equals(role);
        if (isComputer) {
            GAME_PREPARER.getCurrentPlayer().setWinner(false);
            GAME_PREPARER.swapPlayers();
        }
    }
}
