package com.github.zipcodewilmington.cards;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.cards.Card;
import com.github.zipcodewilmington.casino.cards.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class DeckTests {

    @Test
    public void testDeckConstructor(){
        Deck deck = new Deck();

        Assert.assertNotNull(deck);
        Assert.assertFalse(deck.empty());
        Assert.assertEquals(52, deck.size());
    }

    @Test
    public void testDeckRemoveCard(){
        Deck deck = new Deck();
        Card actual = deck.removeCard();

        Assert.assertNotNull(actual);
        Assert.assertEquals(51, deck.size());
    }

    @Test
    public void testDeckShuffle(){

        // this test is sometimes failing because sometimes
        // one is at the top even after shuffling
        Deck deck = new Deck();

        deck.shuffle();

        Assert.assertNotEquals(1, deck.pop().getFace().getCardValue());
    }
}
