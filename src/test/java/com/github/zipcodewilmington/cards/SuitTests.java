package com.github.zipcodewilmington.cards;

import com.github.zipcodewilmington.casino.cards.Suit;
import org.junit.Assert;
import org.junit.Test;

public class SuitTests {

    @Test
    public void testSuitGetColor(){
        Assert.assertEquals("red", Suit.HEARTS.getColor());
        Assert.assertEquals("red", Suit.DIAMONDS.getColor());
        Assert.assertEquals("black", Suit.CLUBS.getColor());
        Assert.assertEquals("black", Suit.SPADES.getColor());
    }
}
