package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.Random;

public class RouletteGame implements GameInterface {
    CasinoAccount account = new CasinoAccount("user","pass");

    RouletteBoard board;
    String currentNumber;
    ArrayList<String> allNumbers;

    public RouletteGame(){
        this.board = new RouletteBoard();
//        while(true){ // this goes in run()?
//            currentNumber = spin();
//        }
    }

    public String spin(){
        Random random = new Random();
        allNumbers.add("00");
        for (int i = 0; i <= 36; i++){
            allNumbers.add(Integer.toString(i));
        }
        return allNumbers.get(random.nextInt());
    }

    public boolean isRed(String currentNumber) {
        if (currentNumber.equals("00") || currentNumber.equals("0")){
            return false;
        }
        else{
            return board.redNumbers.contains(Integer.valueOf(currentNumber));
        }
    }

    public boolean isOdd(String currentNumber) {
        if (currentNumber.equals("00") || currentNumber.equals("0")){
            return false;
        }
        else{
            return Integer.parseInt(currentNumber) % 2 != 0;
        }
    }

    public boolean isFirstHalf(String currentNumber) {
        if (currentNumber.equals("00") || currentNumber.equals("0")){
            return false;
        }
        else{
            return Integer.parseInt(currentNumber) <= 18;
        }
    }

    public boolean isFirstThird(String currentNumber) {
        if (currentNumber.equals("00") || currentNumber.equals("0")){
            return false;
        }
        else{
            return Integer.parseInt(currentNumber) <= 12;
        }
    }

    public boolean isSecondThird(String currentNumber) {
        if (currentNumber.equals("00") || currentNumber.equals("0")){
            return false;
        }
        else{
            return Integer.parseInt(currentNumber) >= 13 && Integer.parseInt(currentNumber) <= 24;
        }
    }

    public boolean isLastThird(String currentNumber) {
        if (currentNumber.equals("00") || currentNumber.equals("0")){
            return false;
        }
        else{
            return Integer.parseInt(currentNumber) >= 25 && Integer.parseInt(currentNumber) <= 36;
        }
    }

    @Override
    public boolean add(PlayerInterface player) {

        return false;
    }

    @Override
    public boolean remove(PlayerInterface player) {
        return false;
    }

    @Override
    public void run() {

    }

    @Override
    public boolean quit() {
        return false;
    }

    @Override
    public boolean playAgain(String prompt) {
        return false;
    }
}
