package com.github.zipcodewilmington.casino.games.baucuaca;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.dice.BCCDice;


public class BauCuaCaGame implements GameInterface {
    BCCDice bccDice = new BCCDice(3);
    String[] bccBoard = {"fish", "prawn", "crab", "rooster", "gourd", "deer"};
    public String plaverBettingChar = "fish";
    int playerBetMoney = 2;

    public String[] toss(){
        return (String[]) bccDice.toss();
    }

    public Integer getWinningCharacters(){
        int count = 0;
        String[] winningChar = toss();
        for(int i = 0; i < 3; i++){
            if(plaverBettingChar.equals(winningChar[i])){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public Double getWinMoney(){
        double winnings = playerBetMoney * getWinningCharacters();
        System.out.println(winnings);
        return winnings;
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
