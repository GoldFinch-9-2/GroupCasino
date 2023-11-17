package com.github.zipcodewilmington.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.slots.Icon;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class SlotsTest {
    @Test
    public void testSlotsConstructor(){
        SlotsGame slots = new SlotsGame();
        Assert.assertNotNull(slots);

    }

    @Test
    public void testSlotAddPlayer(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass");
        SlotsPlayer player = new SlotsPlayer(casinoAccount);
        SlotsGame slots = new SlotsGame();

        Assert.assertTrue(slots.add(player));

    }

    @Test
    public void testRemovePlayer(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass");
        SlotsPlayer player = new SlotsPlayer(casinoAccount);
        SlotsGame slots = new SlotsGame();
        slots.add(player);

        Assert.assertTrue(slots.remove(player));
    }

    @Test
    public void testPullLever(){
        SlotsGame game = new SlotsGame();
        Icon[] actual = game.pullLever();

        //Assert.assertTrue();

    }
}
