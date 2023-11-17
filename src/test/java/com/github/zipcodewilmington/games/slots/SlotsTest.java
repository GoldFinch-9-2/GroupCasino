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
        game.viewSlotsReel();

        Assert.assertNotEquals(0, actual[0].getMultiplier());
        Assert.assertNotEquals(0, actual[1].getMultiplier());
        Assert.assertNotEquals(0, actual[2].getMultiplier());

    }

    @Test
    public void testCheckReel(){
        SlotsGame game = new SlotsGame();
        Icon[] reel = new Icon[] {Icon.BAR, Icon.BAR, Icon.BAR};

        int actual = game.checkReel(reel);

        Assert.assertEquals(Icon.BAR.getMultiplier(), actual);
    }

    @Test
    public void testWinOrLost(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass", 1000.0);
        SlotsPlayer player = new SlotsPlayer(casinoAccount);
        SlotsGame game = new SlotsGame();
        game.add(player);
        double bet = 100.0;
        int multiplier = 2;

        double actual = game.winOrLose(multiplier, bet);

        Assert.assertEquals(1000.0 + (multiplier*bet), actual, 1);
    }

    @Test
    public void testWinOrLost2(){
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass", 1000.0);
        SlotsPlayer player = new SlotsPlayer(casinoAccount);
        SlotsGame game = new SlotsGame();
        game.add(player);
        double bet = 100.0;
        int multiplier = 0;

        double actual = game.winOrLose(multiplier, bet);

        Assert.assertEquals(1000.0 - bet, actual, 1);
    }

    @Test
    public void testQuit(){
        SlotsGame game = new SlotsGame();
        Assert.assertFalse(game.quit());
    }


}
