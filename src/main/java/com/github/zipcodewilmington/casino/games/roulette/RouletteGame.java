package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RouletteGame implements GameInterface {
    RouletteBoard board;
    int currentNumber;

    public RouletteGame(){
        this.board = new RouletteBoard();
        while(true){
            currentNumber = spin();
        }
    }

    public String spin(){

    }
    public boolean isRed(int i) {
        return true;
    }

    public boolean isOdd(int i) {
        return true;
    }

    public boolean isFirstHalf(int i) {
        return true;
    }

    public boolean isFirstThird(int i) {
        return true;
    }

    public boolean isSecondThird(int i) {
        return true;
    }

    public boolean isLastThird(int i) {
        return true;
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
