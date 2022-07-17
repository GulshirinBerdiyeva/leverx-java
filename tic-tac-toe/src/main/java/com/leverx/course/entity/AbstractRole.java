package com.leverx.course.entity;

public abstract class AbstractRole {
    private final String NAME;
    private final Role ROLE;
    private Figure figure;
    private boolean winner;

    public AbstractRole(String name, Role role) {
        this.NAME = name;
        this.ROLE = role;
    }

    public String getNAME() {
        return NAME;
    }

    public Role getROLE() {
        return ROLE;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
