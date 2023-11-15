package com.github.zipcodewilmington.casino.dice;

public abstract class Dice {
    public int numberOfDice;
    public int numberOfSides;
    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
        this.numberOfSides = 6;
    }
    public abstract int amountOfDice();
    public abstract Object[] toss();

}
