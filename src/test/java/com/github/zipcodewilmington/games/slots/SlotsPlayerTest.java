package com.github.zipcodewilmington.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class SlotsPlayerTest {

    @Test
    public void testSlotsPlayerConstructor(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass");
        SlotsPlayer player = new SlotsPlayer(casinoAccount);

        Assert.assertNotNull(player);
    }

    @Test
    public void testGetAccount(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass");
        SlotsPlayer player = new SlotsPlayer(casinoAccount);

        Assert.assertEquals(casinoAccount, player.getArcadeAccount());
    }

    @Test
    public void testPlay(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass");
        SlotsPlayer player = new SlotsPlayer(casinoAccount);

        Assert.assertFalse(player.play());
    }

    @Test
    public void testPlaceBets(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass");
        SlotsPlayer player = new SlotsPlayer(casinoAccount);
        double expected = 100.0;

        Assert.assertEquals(expected, player.placeBets(expected), 1);
    }

}
