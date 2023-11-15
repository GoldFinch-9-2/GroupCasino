package com.github.zipcodewilmington.casino.dice;

public abstract class Dice {
    int numberOfDice;
    int numberOfSides;
    public Dice(){
        this.numberOfDice = 1;
        this.numberOfSides = 6;
    }
}
