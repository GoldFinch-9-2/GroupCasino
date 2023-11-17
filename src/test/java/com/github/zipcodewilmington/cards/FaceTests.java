package com.github.zipcodewilmington.cards;

import com.github.zipcodewilmington.casino.cards.Face;
import org.junit.Assert;
import org.junit.Test;

public class FaceTests {

    @Test
    public void testFaceGetCardValue(){
        Assert.assertEquals(2, Face.TWO.getCardValue());
        Assert.assertEquals(3, Face.THREE.getCardValue());
        Assert.assertEquals(4, Face.FOUR.getCardValue());
        Assert.assertEquals(5, Face.FIVE.getCardValue());
        Assert.assertEquals(6, Face.SIX.getCardValue());
        Assert.assertEquals(7, Face.SEVEN.getCardValue());
        Assert.assertEquals(8, Face.EIGHT.getCardValue());
        Assert.assertEquals(9, Face.NINE.getCardValue());
        Assert.assertEquals(10, Face.TEN.getCardValue());
        Assert.assertEquals(10, Face.JACK.getCardValue());
        Assert.assertEquals(10, Face.QUEEN.getCardValue());
        Assert.assertEquals(10, Face.KING.getCardValue());
        Assert.assertEquals(1, Face.ACE.getCardValue());

    }
}
