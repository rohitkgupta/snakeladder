package com.game.snakeladder.bean.board;

import com.game.snakeladder.bean.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class BoardTest {
    private Board board;
    private Player testPlayer;

    @Before
    public void setup() {
        testPlayer = new Player("testPlayer");
        board = new Board(100, Collections.singletonList(testPlayer));
        board.setSnakes(Arrays.asList(new Snake(10, 1), new Snake(8, 2)));
        board.setLadders(Arrays.asList(new Ladder(24, 30), new Ladder(11, 22)));
    }

    @Test
    public void testMove() {
        Assert.assertEquals(1, board.move(testPlayer.getName(), 100));
        Assert.assertEquals(1, board.move(testPlayer.getName(), 200));
        Assert.assertEquals(100, board.move(testPlayer.getName(), 99));
    }

    @Test
    public void testMoveWithSnakePositions() {
        Assert.assertEquals(7, board.move(testPlayer.getName(), 6));
        Assert.assertEquals(2, board.move(testPlayer.getName(), 1));
        Assert.assertEquals(1, board.move(testPlayer.getName(), 8));
    }

    @Test
    public void testMoveWithLadderPositions() {
        Assert.assertEquals(7, board.move(testPlayer.getName(), 6));
        Assert.assertEquals(22, board.move(testPlayer.getName(), 4));
        Assert.assertEquals(30, board.move(testPlayer.getName(), 2));
    }

    @Test
    public void testMoveWithSnakeAndLadderPositions(){
        Assert.assertEquals(1, board.move(testPlayer.getName(), 9));
        Assert.assertEquals(22, board.move(testPlayer.getName(), 10));
        Assert.assertEquals(91, board.move(testPlayer.getName(), 69));
        Assert.assertEquals(91, board.move(testPlayer.getName(), 10));
        Assert.assertEquals(99, board.move(testPlayer.getName(), 8));
        Assert.assertEquals(99, board.move(testPlayer.getName(), 2));
        Assert.assertEquals(100, board.move(testPlayer.getName(), 1));
    }

    @Test
    public void testGetPlayerPosition() {
        board.move(testPlayer.getName(), 6);
        Assert.assertEquals(7, board.getPlayerPosition(testPlayer.getName()));
        board.move(testPlayer.getName(), 2);
        Assert.assertEquals(9, board.getPlayerPosition(testPlayer.getName()));
    }
}
