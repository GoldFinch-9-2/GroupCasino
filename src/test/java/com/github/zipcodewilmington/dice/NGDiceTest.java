package com.github.zipcodewilmington.dice;

import com.github.zipcodewilmington.casino.dice.Dice;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessDice;
import org.junit.Assert;
import org.junit.Test;

public class NGDiceTest {
    @Test
    public void testDiceConstructor() {
        NumberGuessDice noOfDice = new NumberGuessDice();
        Assert.assertEquals(2, noOfDice.numberOfDice);
    }

    @Test
    public void testToss() {
        int numberOfDice = 2;
        NumberGuessDice numberGuessDice = new NumberGuessDice();
        Integer[] actual = numberGuessDice.toss();
        Assert.assertEquals(2, actual.length);
        Assert.assertTrue(actual[0]>=1 && actual[0]<=6);
        Assert.assertTrue(actual[1]>=1 && actual[1]<=6);
    }


}