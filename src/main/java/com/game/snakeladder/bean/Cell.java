package com.game.snakeladder.bean;

public class Cell {
    private int number;
    private Cell gotoCell;

    public Cell(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Cell getGotoCell() {
        return gotoCell;
    }

    public void setGotoCell(Cell gotoCell) {
        this.gotoCell = gotoCell;
    }
}
