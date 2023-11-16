package com.github.zipcodewilmington.games.BauCuaCa;

import com.github.zipcodewilmington.casino.dice.BCCDice;
import org.junit.Test;
import org.junit.Assert;

public class BCCDiceTest {

    BCCDice bccDice = new BCCDice(3);

    @Test
    public void constructorTest(){
        int expected = 3;
        BCCDice actual = new BCCDice(3);
        Assert.assertEquals(expected,actual.numberOfDice);
    }
    @Test
    public void tossTest(){
        String[] symbolsToss = new String[3];
        int actual = bccDice.toss().length;
        Assert.assertEquals(symbolsToss.length, actual);
    }

}
