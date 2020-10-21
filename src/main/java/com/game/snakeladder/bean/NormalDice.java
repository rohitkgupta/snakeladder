package com.game.snakeladder.bean;

import java.util.Random;

public class NormalDice implements Dice {
    private Random random = new Random();

    @Override
    public int roll() {
        int nextInt = random.nextInt(7);
        return nextInt;
    }
}
