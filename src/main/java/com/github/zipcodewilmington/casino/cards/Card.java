package com.github.zipcodewilmington.casino.cards;

public class Card {
    Suit suit;
    Face face;

    public Card(Suit suit, Face face){
        this.suit = suit;
        this.face = face;
    }

    public Face getFace() {
        return this.face;
    }


    public Suit getSuit() {
        return this.suit;
    }
}
