package com.leverx.course;

import com.leverx.course.entity.*;
import com.leverx.course.scanner.InputScanner;

import java.util.Scanner;

public class GamePreparer {
    private final InputScanner<String> PLAYER_NAME_SCANNER;
    private final InputScanner<Figure> FIGURE_SCANNER;
    private final Scanner SCANNER;

    private AbstractRole currentPlayer;
    private AbstractRole currentOpponent;

    public GamePreparer(InputScanner<String> playerNameScanner, InputScanner<Figure> figureScanner, Scanner scanner) {
        this.PLAYER_NAME_SCANNER = playerNameScanner;
        this.FIGURE_SCANNER = figureScanner;
        this.SCANNER = scanner;
    }

    public AbstractRole getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(AbstractRole currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public AbstractRole getCurrentOpponent() {
        return currentOpponent;
    }

    public void prepare(Role opponent) {
        if (Role.PLAYER.equals(opponent)) {
            System.out.print("\n\tSecond player ");

            String secondPlayerName = PLAYER_NAME_SCANNER.scan(SCANNER);

            currentOpponent = new Player(secondPlayerName);
        } else {
            currentOpponent = new Computer();
        }
    }

    protected void beginOneFromPlayers() {
        if (currentOpponent.isWinner()) {
            currentOpponent.setFigure(selectFigure());
            swapPlayers();

        } else {
            currentPlayer.setFigure(selectFigure());
        }

        setOpponentFigure();
    }

    protected void beginPlayerOrComputer() {
        if (currentOpponent.isWinner()) {
            setPlayersFigure(currentOpponent);
            swapPlayers();

        } else {
            setPlayersFigure(currentPlayer);
        }

        setOpponentFigure();
    }

    private Figure selectFigure() {
        System.out.printf("%s please SELECT your Figure for starting the game!%n", currentPlayer.getNAME().toUpperCase());
        return FIGURE_SCANNER.scan(SCANNER);
    }

    protected void swapPlayers() {
        AbstractRole buffer = currentPlayer;
        currentPlayer = currentOpponent;
        currentOpponent = buffer;
    }

    private void setOpponentFigure() {
        Figure figure = currentPlayer.getFigure();

        if (Figure.X.equals(figure)) {
            currentOpponent.setFigure(Figure.O);
        } else {
            currentOpponent.setFigure(Figure.X);
        }
    }

    private void setPlayersFigure(AbstractRole player) {
        if (Role.COMPUTER.equals(player.getROLE())) {
            player.setFigure(Figure.X);
        } else {
            player.setFigure(selectFigure());
        }
    }
}
