package com.game.snakeladder.bean.dice;

import java.util.Random;

public class CrookedDice implements Dice {
    private Random random = new Random();

    @Override
    public int roll() {
        int nextInt = random.nextInt(6);
        if (nextInt == 0) {
            return nextInt + 2;
        } else if (nextInt % 2 == 0) {
            return nextInt;
        } else {
            return nextInt + 1;
        }
    }
}
