package com.github.zipcodewilmington.casino.games.baucuaca;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.dice.BCCDice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;


public class BauCuaCaGame implements GameInterface {
    BCCDice bccDice = new BCCDice(3);
    String[] bccBoard = {"FISH", "PRAWN", "CRAB", "ROOSTER", "GOURD", "DEER"};
    public ArrayList<BauCuaCaPlayer> players = new ArrayList<>();
    public String plaverBettingChar;
    public double playerBetMoney;
    String resume;

    public String[] toss(){
        return (String[]) bccDice.toss();
    }

    public Integer getWinningCharacters(){
        //counts how many chosen symbols match the tossed symbols
        int count = 0;
        String[] winningChar = toss();
        for(int i = 0; i < 3; i++){
            if(plaverBettingChar.equals(winningChar[i])){
                count++;
            }
        }
        //System.out.println(count);
        return count;
    }

    public Double getWinMoney(){
        //calculates winnings
        double winnings = playerBetMoney * getWinningCharacters();
        //System.out.println(winnings);
        return winnings;
    }

    @Override
    public boolean add(PlayerInterface player) {
        return players.add((BauCuaCaPlayer) player);
    }

    @Override
    public boolean remove(PlayerInterface player) {
        return players.remove((BauCuaCaPlayer)player);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        CasinoAccount player = players.get(0).getArcadeAccount();
        while(true){
            System.out.println("WELCOME TO BAU CUA CAU!");
            System.out.println(Arrays.toString(bccBoard));
            System.out.println("YOUR CURRENT BALANCE IS :" +player.getBalance());
            System.out.println("CHOOSE YOUR CHARACTER!");
            plaverBettingChar = scanner.nextLine().toUpperCase();
            System.out.println("PlACE YOUR BEETS!");
            double bet = scanner.nextDouble();
            playerBetMoney = players.get(0).placeBets(bet);

            Double winOrLose = getWinMoney();
            System.out.println("YOU WON: " + winOrLose);
            if(winOrLose > 0) {
                double win = player.getBalance() + winOrLose;
                player.setBalance(win);
                System.out.println("YOUR NEW BALANCE IS: $" +win);
            } else{
                double loss = player.getBalance() - bet;
                player.setBalance(loss);
                System.out.println("YOUR NEW BALANCE IS: $" + loss);
            }
            scanner.nextLine();
            System.out.println("DO YOU WISH TO CONTINUE?? \n [ resume ] or [ quit ]");
            resume = scanner.nextLine().toLowerCase();
            if(resume.equals("quit")){
                break;
            }
        }
    }

    @Override
    public boolean quit() {
        return true;
    }

    @Override
    public boolean playAgain(String prompt) {
        return false;
    }
}
