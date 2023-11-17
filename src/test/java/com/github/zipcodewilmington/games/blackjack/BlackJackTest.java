package com.github.zipcodewilmington.games.blackjack;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.cards.Card;
import com.github.zipcodewilmington.casino.cards.Face;
import com.github.zipcodewilmington.casino.cards.Suit;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class BlackJackTest {

    @Test
    public void testBlackJackInstanceOfGameInterface(){
        BlackJackGame bj = new BlackJackGame();

        Assert.assertTrue(bj instanceof GameInterface);
    }

    @Test
    public void testBlackJackGameConstructor(){
        BlackJackGame bj = new BlackJackGame();

        Assert.assertNotNull(bj);
    }

    @Test
    public void testBlackJackAddPlayer(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        boolean actual = bj.add(bjPlayer);

        Assert.assertTrue(actual);

    }

    @Test
    public void testBlackJackRemovePlayer(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        CasinoAccount acc2 = new CasinoAccount("user2", "pass2", 200.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackPlayer bjPlayer2 = new BlackJackPlayer(acc2);
        BlackJackGame bj = new BlackJackGame();

        bj.add(bjPlayer);
        bj.add(bjPlayer2);

        boolean actual = bj.remove(bjPlayer);

        Assert.assertTrue(actual);
    }

    @Test
    public void testBlackJackPlayAgain(){
        BlackJackGame bj = new BlackJackGame();

        //bj.playAgain("Would you like to play again? [ YES ] , [ NO ]");

    }

    @Test
    public void testBlackJackQuit(){
        BlackJackGame bj = new BlackJackGame();

        Assert.assertFalse(bj.quit());
    }

    @Test
    public void testDealHands(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.add(bjPlayer);
        bj.dealHands(bjPlayer);

        Assert.assertEquals(2, bjPlayer.getHand().size());
    }

    @Test
    public void testCheckPlayerCards(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bjPlayer.setSumOfCards(21);

        Assert.assertFalse(bj.checkPlayerCards(bjPlayer));


    }

    @Test
    public void testCheckPlayerCards2(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bjPlayer.setSumOfCards(24);

        Assert.assertFalse(bj.checkPlayerCards(bjPlayer));


    }

    @Test
    public void testCheckPlayerCards3(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bjPlayer.setSumOfCards(20);

        Assert.assertTrue(bj.checkPlayerCards(bjPlayer));


    }

    @Test
    public void testDetermineAfterDealerMove(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.getDealer().setSumOfCards(24);
        bjPlayer.setSumOfCards(20);

        Assert.assertFalse(bj.determineAfterDealerMove(bjPlayer));

    }

    @Test
    public void testDetermineAfterDealerMove2(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.getDealer().setSumOfCards(21);
        bjPlayer.setSumOfCards(20);

        Assert.assertFalse(bj.determineAfterDealerMove(bjPlayer));

    }

    @Test
    public void testDetermineAfterDealerMove3(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.getDealer().setSumOfCards(19);
        bjPlayer.setSumOfCards(20);

        Assert.assertTrue(bj.determineAfterDealerMove(bjPlayer));

    }

    @Test
    public void testGetWinner(){
        double bet = 100.00;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.getDealer().setSumOfCards(24);
        bjPlayer.setSumOfCards(20);
        bj.determineWinner(bjPlayer, bet);

        Assert.assertEquals(200.00,acc.getBalance() , 2);

    }

    @Test
    public void testGetWinner2(){
        double bet = 100.00;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.getDealer().setSumOfCards(19);
        bjPlayer.setSumOfCards(21);
        bj.determineWinner(bjPlayer, bet);

        Assert.assertEquals(200.00,acc.getBalance() , 2);

    }

    @Test
    public void testGetWinner3(){
        double bet = 100.00;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.getDealer().setSumOfCards(18);
        bjPlayer.setSumOfCards(20);
        bj.determineWinner(bjPlayer, bet);

        Assert.assertEquals(200.00,acc.getBalance() , 2);

    }

    @Test
    public void testGetWinner4(){
        double bet = 100.00;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();

        bj.getDealer().setSumOfCards(19);
        bjPlayer.setSumOfCards(24);
        bj.determineWinner(bjPlayer, bet);

        Assert.assertEquals(0.00,acc.getBalance() , 2);

    }

    @Test
    public void testClearGame(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();
        bj.add(bjPlayer);
        bj.dealHands(bjPlayer);
        bj.printHands(bjPlayer);

        bj.clearGame(bjPlayer);

        Assert.assertEquals(0, bj.getDealer().getHand().size());
        Assert.assertEquals(0, bjPlayer.getHand().size());

    }

    @Test
    public void testHit(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();
        bj.getDealer().setSumOfCards(20);
        bjPlayer.setSumOfCards(10);

        Assert.assertTrue(bj.hit(bjPlayer));
    }

    @Test
    public void testHit2(){
        CasinoAccount acc = new CasinoAccount("user", "pass", 100.00);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackGame bj = new BlackJackGame();
        bj.getDealer().stand();
        bj.getDealer().setSumOfCards(20);
        bjPlayer.setSumOfCards(10);

        Assert.assertTrue(bj.hit(bjPlayer));
    }


}
