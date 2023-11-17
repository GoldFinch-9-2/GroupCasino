package com.github.zipcodewilmington.games.roulette;

import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteTest {
    private RouletteGame game;
    @Before
    public void setup() {
        this.game = new RouletteGame();
    }

    @Test
    public void isRedTest1(){
        Assert.assertTrue(game.isRed("1"));
    }

    @Test
    public void isRedTest17(){
        Assert.assertFalse(game.isRed("17"));
    }

    @Test
    public void isRedTest36(){
        Assert.assertTrue(game.isRed("36"));
    }

    @Test
    public void isOddTest1(){
        Assert.assertTrue(game.isOdd("1"));
    }

    @Test
    public void isOddTest17(){
        Assert.assertTrue(game.isOdd("17"));
    }

    @Test
    public void isOddTest36(){
        Assert.assertFalse(game.isOdd("36"));
    }

    @Test
    public void isFirstHalfTest1(){
        Assert.assertTrue(game.isFirstHalf("1"));
    }

    @Test
    public void isFirstHalfTest17(){
        Assert.assertTrue(game.isFirstHalf("17"));
    }

    @Test
    public void isFirstHalfTest36(){
        Assert.assertFalse(game.isFirstHalf("36"));
    }

    @Test
    public void isFirstThirdTest1(){
        Assert.assertTrue(game.isFirstThird("1"));
    }

    @Test
    public void isFirstThirdTest17(){
        Assert.assertFalse(game.isFirstThird("17"));
    }

    @Test
    public void isFirstThirdTest36(){
        Assert.assertFalse(game.isFirstThird("36"));
    }

    @Test
    public void isSecondThirdTest1(){
        Assert.assertFalse(game.isSecondThird("1"));
    }

    @Test
    public void isSecondThirdTest17(){
        Assert.assertTrue(game.isSecondThird("17"));
    }

    @Test
    public void isSecondThirdTest36(){
        Assert.assertFalse(game.isSecondThird("36"));
    }

    @Test
    public void isLastThirdTest1(){
        Assert.assertFalse(game.isLastThird("1"));
    }

    @Test
    public void isLastThirdTest17(){
        Assert.assertFalse(game.isLastThird("17"));
    }

    @Test
    public void isLastThirdTest36(){
        Assert.assertTrue(game.isLastThird("36"));
    }

    @Test
    public void quitTest() {Assert.assertFalse(game.quit());}

    @Test
    public void playAgainTest() {Assert.assertFalse(game.playAgain("POOPY"));}

    @Test
    public void getWinningsTest() {
        Assert.assertEquals(game.getWinnings("RED"), game.getPlayerBet()*2, 0);
    }
}
