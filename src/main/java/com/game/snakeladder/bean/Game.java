package com.game.snakeladder.bean;

import com.game.snakeladder.bean.board.Board;
import com.game.snakeladder.bean.dice.Dice;

public class Game {
    private Board board;
    private Player player;
    private Dice dice;

    private static final int MAX_NUMBER_OF_TURNS_ALLOWED = 100;

    public Game(Board board, Player player, Dice dice) {
        this.board = board;
        this.player = player;
        this.dice = dice;
    }

    public void startGame() {
        int numberOfTurns = 0;
        while (!isWon(player) && numberOfTurns < MAX_NUMBER_OF_TURNS_ALLOWED) {
            int diceValue = dice.roll();
            System.out.println("Dice value for [" + player.getName() + "] :" + diceValue);
            int playerPosition = board.move(player.getName(), diceValue);
            System.out.println("Player[" + player.getName() + "] position:" + playerPosition);
            numberOfTurns++;
        }
        System.out.println("Game ended after " + numberOfTurns + " number of turns.");
    }

    private boolean isWon(Player player) {
        return board.getPlayerPosition(player.getName()) == board.getSize();
    }
}
