package com.github.zipcodewilmington.games.BauCuaCa;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.baucuaca.BauCuaCaPlayer;
import org.junit.Assert;
import org.junit.Test;
public class BCCPlayerTest {
    CasinoAccount account = new CasinoAccount("yeet", "YEET");
    BauCuaCaPlayer bauCuaCaPlayer = new BauCuaCaPlayer(account);

    @Test
    public void constructorTest(){
        CasinoAccount expected = account;
        BauCuaCaPlayer bauCuaCaPlayer1 = new BauCuaCaPlayer(account);
        CasinoAccount actual = bauCuaCaPlayer1.getAccount();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getArcadeAccountTest(){
        Assert.assertEquals(account, bauCuaCaPlayer.getArcadeAccount());
    }
    @Test
    public void placeBetsTest(){
        double expected = 200;
        double actual = bauCuaCaPlayer.placeBets(200);
        Assert.assertEquals(expected, actual, 0);
    }
}
