package com.github.zipcodewilmington.casino.cards;

public enum Suit {
    HEARTS ("red"),
    DIAMONDS ("red"),
    CLUBS ("black"),
    SPADES ("black");

    String color;

    Suit(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }
}
