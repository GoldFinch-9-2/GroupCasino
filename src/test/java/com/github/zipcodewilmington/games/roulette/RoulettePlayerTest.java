package com.github.zipcodewilmington.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import org.junit.Assert;
import org.junit.Test;

public class RoulettePlayerTest {
    @Test
    public void constructorTest() {
        CasinoAccount account = new CasinoAccount("USER","PASS");
        RoulettePlayer player = new RoulettePlayer(account);
        Assert.assertNotNull(player);
    }

    @Test
    public void getArcadeAccountTest() {
        CasinoAccount account = new CasinoAccount("USER","PASS");
        RoulettePlayer player = new RoulettePlayer(account);
        Assert.assertEquals(player.getArcadeAccount(), account);
    }

    @Test
    public void placeBetsTest() {
        CasinoAccount account = new CasinoAccount("USER","PASS");
        RoulettePlayer player = new RoulettePlayer(account);
        Double expected = (double) 200;
        Assert.assertEquals(player.placeBets(200), expected);
    }
}
