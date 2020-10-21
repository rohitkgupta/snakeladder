package com.game.snakeladder.bean.board;

import com.game.snakeladder.bean.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String, Integer> playerPieces;

    public Board(int size, List<Player> players) {
        this.size = size;
        playerPieces = new HashMap<>();
        if (players != null) {
            for (Player player : players) {
                playerPieces.put(player.getName(), 1);
            }
        }
    }

    public int move(String playerName, int steps) {
        if (playerPieces.containsKey(playerName)) {
            int currentPosition = playerPieces.get(playerName);
            int newPosition = currentPosition + steps;
            if (newPosition > size) {
                //Player can not move due to insufficient steps remaining in the board
                return currentPosition;
            } else {
                int newPositionAfterGoingThroughSnakesAndLadders = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
                playerPieces.put(playerName, newPositionAfterGoingThroughSnakesAndLadders);
                return newPositionAfterGoingThroughSnakesAndLadders;
            }

        }
        return -1;
    }

    public int getPlayerPosition(String playerName) {
        return playerPieces.getOrDefault(playerName, -1);
    }

    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        if (snakes != null) {
            for (Snake snake : snakes) {
                if (newPosition == snake.getStart()) {
                    return snake.getEnd();
                }
            }
        }

        if (ladders != null) {
            for (Ladder ladder : ladders) {
                if (newPosition == ladder.getStart()) {
                    return ladder.getEnd();
                }
            }
        }

        return newPosition;
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }
}
