package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends NumberGuessDice{

    public static int playerBet;
    public static Integer toss;


    //constructor
    public NumberGuessGame(){

    }

    public int sum(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }

//        player = new player();
//        numberOfGames = games;
//        play();
//        displayResults(guessPlayer.getWin());


    @Override
    public Integer[] toss() {
        Integer dice1 = 0;
        Integer dice2 = 0;
        Integer[] numbers = new Integer[2];


        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            dice1 += random.nextInt(6) + 1;
            dice2 += random.nextInt(6) + 1;
            numbers[0] = dice1;
            numbers[1] = dice2;

        }
        Integer[] numbers1 = numbers;
        return numbers1;
    }

    public boolean getWinner(NumberGuessPlayer player){
        player
    }
}