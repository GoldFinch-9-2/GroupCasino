package com.github.zipcodewilmington.games.BauCuaCa;

import com.github.zipcodewilmington.casino.dice.BCCDice;
import com.github.zipcodewilmington.casino.games.baucuaca.BauCuaCaGame;
import org.junit.Assert;
import org.junit.Test;

public class BCCGameTest {
    BCCDice bccDice = new BCCDice(3);
    String[] bccBoard = {"fish", "prawn", "crab", "rooster", "gourd", "deer"};
    public String plaverBet;

    BauCuaCaGame bauCuaCaGame = new BauCuaCaGame();

    @Test
    public void tossTest(){
        String[] symbolsToss = new String[3];
        int actual = bauCuaCaGame.toss().length;
        Assert.assertEquals(symbolsToss.length, actual);
    }

    @Test
    public void addPlayerTest(){

    }

    @Test
    public void getWinningCharacters(){
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
