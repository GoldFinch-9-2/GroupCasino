package com.github.zipcodewilmington.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoulettePlayerTest {
    CasinoAccount account;
    RoulettePlayer player;
    @Before
    public void setup(){
        this.account = new CasinoAccount("USER","PASS");
        this.player = new RoulettePlayer(account);
    }

    @Test
    public void constructorTest() {
        Assert.assertNotNull(player);
    }

    @Test
    public void getArcadeAccountTest() {
        Assert.assertEquals(player.getArcadeAccount(), account);
    }

    @Test
    public void placeBetsTest() {
        Double expected = (double) 200;
        Assert.assertEquals(player.placeBets(200), expected);
    }

    @Test
    public void playTest(){
        Assert.assertTrue(player.play());
    }
}
