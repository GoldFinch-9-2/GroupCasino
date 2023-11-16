package com.github.zipcodewilmington.casino.games.numberguess;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends Dice{
    int noOfDice;
    public NumberGuessGame(int numberOfDice){
        this.numberOfDice = numberOfDice;

    }
    public Integer[] toss(){
        Integer dice1 = 0;
        Integer dice2 = 0;
        Integer[] numbers = new numbers;


        Random random = new Random();
        for(int i = 0; i < numbers.length; i++){
            dice1 += random.nextInt(6)+1;
            dice2 += random.nextInt(6)+1 ;
            numbers[0] = dice1;
            numbers[1] = dice2;

        }
        Integer[] numbers1 =  numbers;
        return numbers1;
    }
}