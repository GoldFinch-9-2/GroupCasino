package com.github.zipcodewilmington.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RouletteTest {
    private RouletteGame game;
    ArrayList<RoulettePlayer> players;
    CasinoAccount account;

    @Before
    public void setup() {
        this.game = new RouletteGame();
        this.players = new ArrayList<>();
    }

    @Test
    public void isRedTest(){
        Assert.assertTrue(game.isRed("1"));
        Assert.assertFalse(game.isRed("17"));
        Assert.assertTrue(game.isRed("36"));
        Assert.assertFalse(game.isRed("00"));
    }

    @Test
    public void isOddTest(){
        Assert.assertTrue(game.isOdd("1"));
        Assert.assertTrue(game.isOdd("17"));
        Assert.assertFalse(game.isOdd("36"));
        Assert.assertFalse(game.isOdd("00"));
    }

    @Test
    public void isFirstHalfTest(){
        Assert.assertTrue(game.isFirstHalf("1"));
        Assert.assertTrue(game.isFirstHalf("17"));
        Assert.assertFalse(game.isFirstHalf("36"));
        Assert.assertFalse(game.isFirstHalf("00"));
    }

    @Test
    public void isFirstThirdTest(){
        Assert.assertTrue(game.isFirstThird("1"));
        Assert.assertFalse(game.isFirstThird("17"));
        Assert.assertFalse(game.isFirstThird("36"));
        Assert.assertFalse(game.isFirstThird("00"));
    }

    @Test
    public void isSecondThirdTest(){
        Assert.assertFalse(game.isSecondThird("1"));
        Assert.assertTrue(game.isSecondThird("17"));
        Assert.assertFalse(game.isSecondThird("36"));
        Assert.assertFalse(game.isSecondThird("00"));
    }

    @Test
    public void isLastThirdTest(){
        Assert.assertFalse(game.isLastThird("1"));
        Assert.assertFalse(game.isLastThird("17"));
        Assert.assertTrue(game.isLastThird("36"));
        Assert.assertFalse(game.isLastThird("00"));
    }

    @Test
    public void quitTest() {
        Assert.assertFalse(game.quit());
    }

    @Test
    public void playAgainTest() {
        Assert.assertFalse(game.playAgain("PLAY AGAIN?"));
    }

    @Test
    public void getWinningsTest() {
        Assert.assertEquals(game.getWinnings("RED"), game.getPlayerBet()*2, 0);
        Assert.assertEquals(game.getWinnings("1-18"), game.getPlayerBet()*3, 0);
    }

    @Test
    public void addPlayerTest() {
        players.add(new RoulettePlayer(this.account));
        Assert.assertNotNull(players);
    }

    @Test
    public void removePlayerTest() {
        RoulettePlayer player = new RoulettePlayer(this.account);
        players.add(player);
        players.remove(player);
        Assert.assertEquals(players.size(), 0);
    }
}
