package com.github.zipcodewilmington.casino.games.slots;

public enum Icon {

    SEVEN (10),
    BELL (8),
    BAR (6),
    LEMON (3),
    CHERRY (2);

    private int multiplier;
    Icon (int multiplier){
        this.multiplier = multiplier;
    }

    public int getMultiplier(){
        return this.multiplier;
    }
}
