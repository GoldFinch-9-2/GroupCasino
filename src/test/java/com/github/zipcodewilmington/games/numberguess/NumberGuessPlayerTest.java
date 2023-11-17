package com.github.zipcodewilmington.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.baucuaca.BauCuaCaPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import org.junit.Assert;
import org.junit.Test;

public class NumberGuessPlayerTest {

        CasinoAccount account = new CasinoAccount("yeet", "YEET");
        NumberGuessPlayer numberGuessPlayer = new NumberGuessPlayer(account);

        @Test
        public void constructorTest(){
            CasinoAccount expected = account;
            NumberGuessPlayer numberGuessPlayer = new NumberGuessPlayer(account);
            CasinoAccount actual = numberGuessPlayer.getArcadeAccount();
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void getArcadeAccountTest(){
            Assert.assertEquals(account, numberGuessPlayer.getArcadeAccount());
        }
        @Test
        public void placeBetsTest(){
            double expected = 200;
            double actual = numberGuessPlayer.placeBets(200);
            Assert.assertEquals(expected, actual, 0);
        }

        @Test
        public void testGetArcadeAccount(){
            Assert.assertEquals(account,numberGuessPlayer.getArcadeAccount());
        }
        @Test
        public void testPlay(){
            Assert.assertFalse(numberGuessPlayer.play());
        }
        @Test
        public void testPlaceBet(){
            Assert.assertEquals(100.0, numberGuessPlayer.placeBets(100.0),1);
        }
    }


