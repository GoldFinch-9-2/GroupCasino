package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.dice.NGDice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public static int playerBet;
    public static Integer toss;
    NumberGuessPlayer numberGuessPlayer ;
    NGDice ngDice ;
    //constructor
    public NumberGuessGame(){
        ngDice = new NGDice(2);

    }

    public int sum(Integer[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }



    public Integer[] toss() {
        return ngDice.toss();
    }

    @Override
    public boolean add(PlayerInterface player) {
        this.numberGuessPlayer = (NumberGuessPlayer) player;
        return this.numberGuessPlayer != null;
    }

    @Override
    public boolean remove(PlayerInterface player) {
        return false;
    }

    @Override
    public void run() {
        System.out.println("Welcome to NumberGuessGame!");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("How Much you like to bet");
            double bet = scanner.nextDouble();
            System.out.println("What is your number ? Guess numbers between 2-12");
            int input = scanner.nextInt();
            Integer[] rolls = toss();
            int sum = sum(rolls);
            System.out.println("The winning number is: " + sum);
            if (input == sum) {
                System.out.println("You Win!");
                numberGuessPlayer.getArcadeAccount().setBalance(numberGuessPlayer.getArcadeAccount().getBalance() + bet);
                System.out.println("Your balance is: " + numberGuessPlayer.getArcadeAccount().getBalance());
            } else {
                System.out.println("You Lose!");
                numberGuessPlayer.getArcadeAccount().setBalance(numberGuessPlayer.getArcadeAccount().getBalance() - bet);
                System.out.println("Your balance is: " + numberGuessPlayer.getArcadeAccount().getBalance());
            }
        }
        while(playAgain("Would you like to play again!"));
    }

    @Override
    public boolean quit() {
        return false;
    }

    @Override
    public boolean playAgain(String prompt) {
        return console.getStringInput(prompt).equalsIgnoreCase("yes");
    }

}