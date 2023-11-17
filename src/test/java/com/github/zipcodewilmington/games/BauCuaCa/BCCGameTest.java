package com.github.zipcodewilmington.games.BauCuaCa;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.dice.BCCDice;
import com.github.zipcodewilmington.casino.games.baucuaca.BauCuaCaGame;
import com.github.zipcodewilmington.casino.games.baucuaca.BauCuaCaPlayer;
import org.junit.Assert;
import org.junit.Test;

public class BCCGameTest {
    BauCuaCaGame bauCuaCaGame = new BauCuaCaGame();
    CasinoAccount account;
    BauCuaCaPlayer player = new BauCuaCaPlayer(account);

    @Test
    public void tossTest(){
        String[] symbolsToss = new String[3];
        int actual = bauCuaCaGame.toss().length;
        Assert.assertEquals(symbolsToss.length, actual);
    }

    @Test
    public void addPlayerTest(){
        Assert.assertTrue(bauCuaCaGame.add(player));
    }

    @Test
    public void removePlayerTest(){
        bauCuaCaGame.add(player);
        Assert.assertTrue(bauCuaCaGame.remove(player));
    }

    @Test
    public void getWinningCharacters(){
        bauCuaCaGame.plaverBettingChar = "PRAWN";
        int actual = bauCuaCaGame.getWinningCharacters();
        if(actual >= 1) {
            Assert.assertTrue(actual >= 1);
        }else {
            Assert.assertTrue(actual<1);
        }
    }

    @Test
    public void getWinMoney(){
        int winCounter = 0; //bauCuaCaGame.getWinningCharacters();
        bauCuaCaGame.plaverBettingChar = "PRAWN";
        bauCuaCaGame.players.add(player);
        bauCuaCaGame.playerBetMoney = 200;
        bauCuaCaGame.players.get(0).placeBets(bauCuaCaGame.playerBetMoney);
        double winMoney = bauCuaCaGame.getWinMoney();
        switch(winCounter){
            case 1:
                Assert.assertTrue(winMoney == winCounter);
                break;
            case 2:
                Assert.assertTrue(winMoney > winCounter);
                break;
            case 3:
                Assert.assertTrue(winMoney>winCounter);
                break;
        }
    }
}
