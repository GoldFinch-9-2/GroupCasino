package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountManagerTests {

    @Test
    public void testReadFile(){
        CasinoAccountManager manager = new CasinoAccountManager();

        manager.readFile();

        Assert.assertFalse(manager.accountsIsEmpty());
        Assert.assertNotEquals(0, manager.accountsSize());
    }

    @Test
    public void testAccountsIsEmpty(){
        CasinoAccountManager manager = new CasinoAccountManager();

        manager.readFile();

        Assert.assertFalse(manager.accountsIsEmpty());
    }

    @Test
    public void testAccountSize(){
        CasinoAccountManager manager = new CasinoAccountManager();

        manager.readFile();

        Assert.assertNotEquals(0, manager.accountsSize());
    }

    @Test
    public void testGetAccount(){
        String username = "tamdoan";
        String password = "hi12345";
        CasinoAccountManager manager = new CasinoAccountManager();

        manager.readFile();
        CasinoAccount casinoAccount = manager.getAccount(username, password);

        Assert.assertNotNull(casinoAccount);
    }

    @Test
    public void testCreateAccount(){
        String username = "test";
        String password = "passwordTest";
        CasinoAccountManager manager = new CasinoAccountManager();

        CasinoAccount a = manager.createAccount(username, password);

        Assert.assertNotNull(a);

    }


}
