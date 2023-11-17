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
        System.out.println("Welcome to Slots!");
        String input = console.getStringInput("What would you like to do?\n [ PLAY ], [ QUIT ]\n");
        if(input.equalsIgnoreCase("play")) {
            do {
                System.out.println("Current balance: " + this.player.getArcadeAccount().getBalance());
                double bet = console.getDoubleInput("How much would you like to bet?");
                pullLever();
                int multiplier = checkReel();
                viewSlotsReel();

                if (multiplier != 0) {
                    System.out.println("YOU WIN!");
                    player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() + (multiplier * bet));
                    System.out.println("Your new balance is: " + player.getArcadeAccount().getBalance());
                } else {
                    System.out.println("YOU LOSE!");
                    player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() - bet);
                    System.out.println("Your new balance is: " + player.getArcadeAccount().getBalance());
                }
            }
            while(playAgain("Would you like to play again?\n [ YES ] or [ NO ]\n"));
        }

    }

    @Override
    public boolean quit() {
        return false;
    }

    @Override
    public boolean playAgain(String prompt) {
        return console.getStringInput(prompt).equalsIgnoreCase("yes");
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
        for(int i = 0; i < reel.length; i++){
            reel[i] = icons.get(random.nextInt(6)+1);
        }
        return this.reel;
    }

    public void viewSlotsReel(){
        for(int i = 0; i < reel.length; i++){
            System.out.println("[ " + " ] ");
        }
    }

    public int checkReel(){
        if(reel[0] == reel[1] && reel[1] == reel[2]){
            return reel[0].getMultiplier();
        }
        return 0;
    }
}
