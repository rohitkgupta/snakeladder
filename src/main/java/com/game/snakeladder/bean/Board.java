package com.game.snakeladder.bean;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private List<Cell> cells;

    public Board(int size) {
        this.cells = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            cells.add(new Cell(i));
        }
    }
}
