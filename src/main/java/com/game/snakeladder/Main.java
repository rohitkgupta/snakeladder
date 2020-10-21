package com.game.snakeladder;

import com.game.snakeladder.bean.*;
import com.game.snakeladder.bean.board.Board;
import com.game.snakeladder.bean.board.Snake;
import com.game.snakeladder.bean.dice.Dice;
import com.game.snakeladder.bean.dice.NormalDice;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Player1");
        Board board = new Board(100, Collections.singletonList(player));
        Snake snake = new Snake(14, 7);
        board.setSnakes(Collections.singletonList(snake));
        Dice dice = new NormalDice();
        Game game = new Game(board, player, dice);
        game.startGame();
    }
}
