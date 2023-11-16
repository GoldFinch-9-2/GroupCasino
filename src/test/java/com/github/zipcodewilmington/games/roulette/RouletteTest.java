package com.github.zipcodewilmington.games.roulette;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteTest {
    private RouletteBoard board;
    @Before
    public void setup() {
        this.board = new RouletteBoard(populateBoard());
    }

    @Test
    public void isRedTest1(){
        Assert.assertTrue(board.isRed(1)); // Make all params Strings?
    }

    @Test
    public void isRedTest17(){
        Assert.assertFalse(board.isRed(17));
    }

    @Test
    public void isRedTest36(){
        Assert.assertTrue(board.isRed(36));
    }

    @Test
    public void isOddTest1(){
        Assert.assertTrue(board.isOdd(1));
    }

    @Test
    public void isOddTest17(){
        Assert.assertTrue(board.isOdd(17));
    }

    @Test
    public void isOddTest36(){
        Assert.assertFalse(board.isOdd(36));
    }

    @Test
    public void isFirstHalfTest1(){
        Assert.assertTrue(board.isFirstHalf(1));
    }

    @Test
    public void isFirstHalfTest17(){
        Assert.assertTrue(board.isFirstHalf(17));
    }

    @Test
    public void isFirstHalfTest36(){
        Assert.assertFalse(board.isFirstHalf(36));
    }

    @Test
    public void isFirstThirdTest1(){
        Assert.assertTrue(board.isFirstThird(1));
    }

    @Test
    public void isFirstThirdTest17(){
        Assert.assertFalse(board.isFirstThird(17));
    }

    @Test
    public void isFirstThirdTest36(){
        Assert.assertFalse(board.isFirstThird(36));
    }

    @Test
    public void isSecondThirdTest1(){
        Assert.assertFalse(board.isSecondThird(1));
    }

    @Test
    public void isSecondThirdTest17(){
        Assert.assertTrue(board.isSecondThird(17));
    }

    @Test
    public void isSecondThirdTest36(){
        Assert.assertFalse(board.isSecondThird(36));
    }

    @Test
    public void isLastThirdTest1(){
        Assert.assertFalse(board.isLastThird(1));
    }

    @Test
    public void isLastThirdTest17(){
        Assert.assertFalse(board.isLastThird(17));
    }

    @Test
    public void isLastThirdTest36(){
        Assert.assertTrue(board.isLastThird(36));
    }
}
