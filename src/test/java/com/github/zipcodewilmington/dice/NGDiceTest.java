package com.github.zipcodewilmington.dice;

import com.github.zipcodewilmington.casino.dice.NGDice;
import org.junit.Assert;
import org.junit.Test;

public class NGDiceTest {
    @Test
    public void testDiceConstructor() {
        NGDice noOfDice = new NGDice(2);
        Assert.assertEquals(2, noOfDice.numberOfDice);
    }

    @Test
    public void testToss() {
        NGDice ngDice = new NGDice(2);
        Integer[] actual = ngDice.toss();
        Assert.assertEquals(2, actual.length);
        Assert.assertTrue(actual[0]>=1 && actual[0]<=6);
        Assert.assertTrue(actual[1]>=1 && actual[1]<=6);
    }


}