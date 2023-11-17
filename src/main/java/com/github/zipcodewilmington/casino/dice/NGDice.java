package com.github.zipcodewilmington.casino.dice;

import java.util.Random;

public class NGDice extends Dice {

    public NGDice(int numOfDice) {
        super(2);
    }

    @Override
    public Integer[] toss() {
        Integer dice1 = 0;
        Integer dice2 = 0;
        Integer[] numbers = new Integer[2];


        Random random = new Random();
        dice1 += random.nextInt(6) + 1;
        dice2 += random.nextInt(6) + 1;
        numbers[0] = dice1;
        numbers[1] = dice2;

        Integer[] numbers1 = numbers;
        return numbers1;
    }
}
