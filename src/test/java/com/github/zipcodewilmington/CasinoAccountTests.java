package com.github.zipcodewilmington;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountTests {

    @Test
    public void testCasinoAccountConstructor(){
        String username = "username";
        String password = "password";

        CasinoAccount casinoAccount = new CasinoAccount(username, password);

        Assert.assertNotNull(casinoAccount);
        Assert.assertEquals(username, casinoAccount.getUsername());
        Assert.assertEquals(password, casinoAccount.getPassword());
    }

    @Test
    public void testCasinoAccountConstructor2(){
        String username = "username";
        String password = "password";
        double startingBalance = 100.00;

        CasinoAccount casinoAccount = new CasinoAccount(username, password, startingBalance);

        Assert.assertNotNull(casinoAccount);
        Assert.assertEquals(username, casinoAccount.getUsername());
        Assert.assertEquals(password, casinoAccount.getPassword());
        Assert.assertEquals(startingBalance, casinoAccount.getBalance(), 2);
    }

    @Test
    public void testSetBalance(){
        String username = "username";
        String password = "password";
        double balance = 200.00;

        CasinoAccount casinoAccount = new CasinoAccount(username, password);
        casinoAccount.setBalance(balance);

        Assert.assertEquals(balance, casinoAccount.getBalance(), 2);

    }

    @Test
    public void testGetBalance(){
        String username = "username";
        String password = "password";
        double startingBalance = 100.0;

        CasinoAccount casinoAccount = new CasinoAccount(username, password, startingBalance);

        double actual = casinoAccount.getBalance();

        Assert.assertEquals(startingBalance, actual, 1);
    }
}
