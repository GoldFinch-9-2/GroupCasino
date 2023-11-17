package com.github.zipcodewilmington.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackPlayerTest {

    @Test
    public void testBPJInstanceOfPlayerInterface(){
        CasinoAccount acc = new CasinoAccount("user", "pass");
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);

        Assert.assertTrue(bjPlayer instanceof PlayerInterface);
    }

    @Test
    public void testBJPConstructor(){
        CasinoAccount acc = new CasinoAccount("user", "pass");
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);

        Assert.assertNotNull(bjPlayer);
    }

    @Test
    public void testGetArcadeAccount(){
        CasinoAccount acc = new CasinoAccount("user", "pass");
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);

        CasinoAccount actual = bjPlayer.getArcadeAccount();

        Assert.assertEquals(acc, actual);
    }

    @Test
    public void testBPJCashOut(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 1000.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);

        double winnings = 100.00;

        bjPlayer.cashOut(winnings);

        Assert.assertEquals(acc.getBalance() + winnings, bjPlayer.cashOut(winnings), 2);

    }

    @Test
    public void testPlay(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 1000.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);

        Assert.assertTrue(bjPlayer.play());
    }

    @Test
    public void testStand(){
        int sum = 20;
        CasinoAccount acc = new CasinoAccount("user", "pass", 1000.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        bjPlayer.setSumOfCards(sum);

        Assert.assertEquals(sum, bjPlayer.stand());
    }

    @Test
    public void testGetStand(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 1000.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);

        Assert.assertFalse(bjPlayer.getStand());
    }

    @Test
    public void testPlaceBets(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 1000.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        double bet = 100.0;

        Assert.assertEquals(bet, bjPlayer.placeBets(bet), 2);

    }


}
