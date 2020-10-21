package com.game.snakeladder.bean.dice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrookedDiceTest {
    private Dice dice;

    @Before
    public void setup() {
        dice = new CrookedDice();
    }

    @Test
    public void testRoll() {
        int diceValue = dice.roll();
        validateDiceValue(diceValue);
    }

    private void validateDiceValue(int diceValue) {
        Assert.assertEquals(0, diceValue % 2);
        Assert.assertTrue(diceValue < 7);
        Assert.assertTrue(diceValue > 0);
    }

    @Test
    public void testRoll1() {
        int diceValue = dice.roll();
        validateDiceValue(diceValue);
    }

    @Test
    public void testRoll2() {
        int diceValue = dice.roll();
        validateDiceValue(diceValue);
    }
}
