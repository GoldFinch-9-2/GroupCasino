package com.github.zipcodewilmington.casino.cards;

import java.util.Collections;
import java.util.Stack;

public class Deck extends Stack<Card> {
    //Stack<Card> deck;

    public Deck(){
        for(Suit s : Suit.values()){
            for(Face f : Face.values()){
                Card c = new Card(s, f);
                this.add(c);
            }
        }
    }

    public Card removeCard(){
        return this.pop();
    }

    public void shuffle(){
        Collections.shuffle(this);
    }

}
