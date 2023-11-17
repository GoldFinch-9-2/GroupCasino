package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RouletteGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    Random random = new Random();
    ArrayList<RoulettePlayer> players = new ArrayList<>();
    ArrayList<Integer> redNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
    String currentNumber;
    ArrayList<String> allNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"));;
    ArrayList<String> TripleMultiplier = new ArrayList<>(Arrays.asList("1-12", "13-24", "25-36"));
    double playerBet;
    public RouletteGame(){
//        this.board = new RouletteBoard();
    }

    public String spin(){
        return allNumbers.get(random.nextInt(36) + 1);
    }

    public boolean isRed(String currentNumber) {
        if (currentNumber.equals("00") || currentNumber.equals("0")){
            return false;
        }
        else{
            return redNumbers.contains(Integer.valueOf(currentNumber));
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

    public boolean checkCondition(String condition){
        switch (condition) {
            case "1-12":
                return isFirstThird(currentNumber);
            case "13-24":
                return isSecondThird(currentNumber);
            case "25-36":
                return isLastThird(currentNumber);
            case "1-18":
                return isFirstHalf(currentNumber);
            case "19-36":
                return !isFirstHalf(currentNumber);
            case "RED":
                return isRed(currentNumber);
            case "BLACK":
                return !isRed(currentNumber);
            case "ODD":
                return isOdd(currentNumber);
            case "EVEN":
                return !isOdd(currentNumber);
        }
        return false;
    }

    public double getWinnings(String condition){
        if (TripleMultiplier.contains(condition)){
            return playerBet * 3;
        }
        else{
            return playerBet * 2;
        }
    }

    @Override
    public boolean add(PlayerInterface player) {
        players.add((RoulettePlayer) player);
        return true;
    }

    @Override
    public boolean remove(PlayerInterface player) {
        players.remove((RoulettePlayer) player);
        return true;
    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("          WELCOME TO ROULETTE!");
            System.out.println("         [1-12] [13-24] [25-36]");
            System.out.println("[1-18] [EVEN] [RED] [BLACK] [ODD] [19-36]");
            System.out.println("                [QUIT]\n");
            // players bet
            System.out.println("CHOOSE A CONDITION: ");
            String condition = scan.next().toUpperCase();
            if (condition.equals("QUIT")){
                System.out.println("YOUR NEW BALANCE IS: " + players.get(0).getArcadeAccount().getBalance());
                System.out.println("GOODBYE!");
                break;
            }
            System.out.println("PLACE YOUR BET: ");
            this.playerBet = scan.nextDouble();
            players.get(0).placeBets(playerBet);
            this.currentNumber = spin();
            System.out.println("THE NUMBER IS: " + currentNumber);
            // determine win or lose round
            if (checkCondition(condition)){
                System.out.println("YOU WON $" + getWinnings(condition) + "!\n");
                players.get(0).getArcadeAccount().setBalance(players.get(0).getArcadeAccount().getBalance() + getWinnings(condition));
            }
            else {
                System.out.println("YOU LOST!");
                players.get(0).getArcadeAccount().setBalance(players.get(0).getArcadeAccount().getBalance() - playerBet);
            }
        }
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
