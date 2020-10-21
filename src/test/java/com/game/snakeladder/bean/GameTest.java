package com.game.snakeladder.bean;

import com.game.snakeladder.bean.board.Board;
import com.game.snakeladder.bean.dice.Dice;
import com.game.snakeladder.bean.dice.NormalDice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

public class GameTest {
    private Game gameWithMockedBoard;
    private Game gameWithoutMockedBoard;
    private Board mockedBoard;
    private Board board;
    private Player player;
    private Dice mockedDice;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setup() {
        player = new Player("testPlayer");
        mockedBoard = Mockito.mock(Board.class);
        mockedDice = Mockito.mock(NormalDice.class);
        board = new Board(6, Collections.singletonList(player));
        gameWithMockedBoard = new Game(mockedBoard, player, mockedDice);
        gameWithoutMockedBoard = new Game(board, player, mockedDice);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testStartGameWith1CellBoard(){
        Mockito.when(mockedBoard.getPlayerPosition(player.getName())).thenReturn(1);
        Mockito.when(mockedBoard.getSize()).thenReturn(1);
        gameWithMockedBoard.startGame();
        Assert.assertTrue(outputStreamCaptor.toString()
                .trim().contains("Game ended after 0 number of turns."));
    }

    @Test
    public void testStartGameWith10CellBoard(){
        Mockito.when(mockedDice.roll()).thenReturn(5);
        Mockito.when(mockedBoard.getPlayerPosition(player.getName())).thenReturn(1);
        Mockito.when(mockedBoard.getSize()).thenReturn(10);
        gameWithMockedBoard.startGame();
        Assert.assertTrue(outputStreamCaptor.toString()
                .trim().contains("Game ended after 100 number of turns."));
    }

    @Test
    public void testStartGameWith6CellBoard(){
        Mockito.when(mockedDice.roll()).thenReturn(5);
        gameWithoutMockedBoard.startGame();
        Assert.assertTrue(outputStreamCaptor.toString()
                .trim().contains("Game ended after 1 number of turns."));
    }

    @Test
    public void testStartGameWith100CellBoard(){
        Mockito.when(mockedDice.roll()).thenReturn(1);
        board = new Board(100, Collections.singletonList(player));
        gameWithoutMockedBoard = new Game(board, player, mockedDice);
        gameWithoutMockedBoard.startGame();
        Assert.assertTrue(outputStreamCaptor.toString()
                .trim().contains("Game ended after 99 number of turns."));
    }

}
