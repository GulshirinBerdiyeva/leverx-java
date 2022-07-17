package com.leverx.course;

import com.leverx.course.entity.Figure;
import com.leverx.course.entity.GameStatus;
import com.leverx.course.entity.Role;
import com.leverx.course.entity.Player;
import com.leverx.course.scanner.*;
import com.leverx.course.validator.*;

import java.util.Scanner;

public class GameGenerator {
    private static final InputScanner<String> PLAYER_NAME_SCANNER = new PlayerNameScanner(new PlayerNameValidator());
    private static final InputScanner<Role> OPPONENT_SCANNER = new OpponentNumberScanner(new OpponentNumberValidator());
    private static final InputScanner<Figure> FIGURE_SCANNER = new FigureScanner(new FigureValidator());
    private static final InputScanner<String> BOARD_NUMBER_SCANNER = new BoardNumberScanner(new BoardNumberValidator());
    private static final InputScanner<GameStatus> GAME_STATUS_SCANNER = new GameStatusScanner(new GameStatusValidator());

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final GameBoard GAME_BOARD = new GameBoard();
    private static final GamePreparer GAME_PREPARER = new GamePreparer(PLAYER_NAME_SCANNER, FIGURE_SCANNER, SCANNER);
    private static final GameLogic GAME_LOGIC = new GameLogic(GAME_PREPARER, GAME_BOARD, BOARD_NUMBER_SCANNER, SCANNER);

    public static void main(String[] args) {
        GameStatus gameStatus;
        do {
            System.out.println("\n\t\t\tWELCOME to TIC-TAC-TOE");

            String name = PLAYER_NAME_SCANNER.scan(SCANNER);

            Player firstPlayer = new Player(name);
            GAME_PREPARER.setCurrentPlayer(firstPlayer);

            do {
                String currentPlayerName = GAME_PREPARER.getCurrentPlayer().getNAME();
                System.out.printf("\n\t%s please SELECT your OPPONENT for starting the game!%n", currentPlayerName.toUpperCase());

                Role opponent = OPPONENT_SCANNER.scan(SCANNER);

                GAME_PREPARER.prepare(opponent);

                do {
                    GAME_LOGIC.initFirstStep();

                    do {
                        GAME_LOGIC.startGame();
                    } while (!GAME_LOGIC.isGameOver());

                    GAME_LOGIC.resetIfComputerIsWinner();

                    gameStatus = GAME_STATUS_SCANNER.scan(SCANNER);

                } while (GameStatus.CONTINUE.equals(gameStatus));

            } while (GameStatus.CHANGE_OPPONENT.equals(gameStatus));

        } while (!GameStatus.EXIT.equals(gameStatus));

        SCANNER.close();
    }
}
