package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {

    ArrayList<Icon> icons = new ArrayList<>();
    Icon[] reel = new Icon[3];
    SlotsPlayer player;
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public SlotsGame(){
        icons.addAll(Arrays.asList(Icon.values()));
    }

    public void run(){
        System.out.println("         d8b                         \n" +
                "         88P            d8P          \n" +
                "        d88          d888888P        \n" +
                " .d888b,888   d8888b   ?88'   .d888b,\n" +
                " ?8b,   ?88  d8P' ?88  88P    ?8b,   \n" +
                "   `?8b  88b 88b  d88  88b      `?8b \n" +
                "`?888P'   88b`?8888P'  `?8b  `?888P' \n" +
                "                                     \n");
        System.out.println("Welcome to Slots!");
        do {
            String start = "?".repeat(5);
            System.out.printf("[ %5s ]  [ %5s ]  [ %5s ] \n", start, start, start);
            System.out.println("Current balance: " + this.player.getArcadeAccount().getBalance());
            double bet = console.getDoubleInput("How much would you like to bet?");
            pullLever();
            int multiplier = checkReel(this.reel);
            viewSlotsReel();

            double balance = winOrLose(multiplier, bet);
        }
        while(playAgain("Would you like to play again?\n [ YES ] or [ NO ]\n"));

    }

    @Override
    public boolean quit() {
        return false;
    }

    @Override
    public boolean playAgain(String prompt) {
        return console.getStringInput(prompt).equalsIgnoreCase("yes");
    }

    public double winOrLose(int multiplier, double bet){
        if (multiplier != 0) {
            System.out.println("YOU WIN!");
            player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() + (multiplier * bet));
            System.out.println("Your new balance is: " + player.getArcadeAccount().getBalance());
        } else {
            System.out.println("YOU LOSE!");
            player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() - bet);
            System.out.println("Your new balance is: " + player.getArcadeAccount().getBalance());
        }

        return player.getArcadeAccount().getBalance();
    }
    public boolean add(PlayerInterface player){
        this.player = (SlotsPlayer) player;
        return this.player != null;
    }

    @Override
    public boolean remove(PlayerInterface player) {
        this.player = null;
        return this.player == null;
    }

    public Icon[] pullLever(){
        Random random = new Random();
        for(int i = 0; i < 3; i++){
            reel[i] = icons.get(random.nextInt(5));
        }
        return this.reel;
    }

    public void viewSlotsReel(){
        System.out.println("\n");
        for(int i = 0; i < reel.length; i++){
            System.out.printf("[ %5s ]  ", reel[i].toString());
        }
        System.out.println("\n");
    }

    public int checkReel(Icon[] reel){
        if(reel[0] == reel[1] && reel[1] == reel[2]){
            return reel[0].getMultiplier();
        }
        return 0;
    }
}
