package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.dice.Dice;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessDice extends Dice {
//    public int win;
//    public int Dice1;
//    public int Dice2;
//
//    // constructor
//    public NumberGuessDice(){
//        this.win = 0;
//        this.Dice1 = 0;
//        this.Dice2 = 0;
//    }
//
//    public void roll(){
//        Random random = new Random();
//        this.Dice1 = random.nextInt(6)+1;
//        this.Dice2 = random.nextInt(6)+1;
//
//    }
//    // some getters and setters
//    public void setWin(){
//        this.win++;
//    }
//    public int getRoll(){
//        return this.Dice1 + Dice2;
//    }
//    public int getWin(){
//        return this.win;
//    }
//
//    @Override
//    public int amountOfDice() {
//        return 2;
//    }

    public NumberGuessDice() {
        super(2);
    }

    @Override
    public int amountOfDice() {
        return 2;
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