package com.github.zipcodewilmington.casino.dice;
import java.util.Arrays;
import java.util.Random;

public class BCCDice extends Dice {

    public String[] symbols = {"FISH", "PRAWN", "CRAB", "ROOSTER", "GOURD", "DEER"};

    public BCCDice(int numOfDice){
        super(numOfDice);
    }

    @Override
    public Object[] toss() {
        Random rand = new Random();
        String[] tossedSymbols = new String[3];
        for(int i = 0; i<3; i++){
            int singleToss = rand.nextInt(6);
            tossedSymbols[i] = symbols[singleToss];
        }
        System.out.println(Arrays.toString(tossedSymbols));
        return tossedSymbols;
    }
}
