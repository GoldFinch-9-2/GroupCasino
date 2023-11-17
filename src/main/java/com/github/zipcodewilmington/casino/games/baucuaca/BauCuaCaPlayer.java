package com.github.zipcodewilmington.casino.games.baucuaca;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import java.util.Scanner;
public class BauCuaCaPlayer implements PlayerInterface, GamblingInterface {
    CasinoAccount account;
    double bet;

    public CasinoAccount getAccount() {
        return account;
    }

    public BauCuaCaPlayer(CasinoAccount account){
        this.account = account;
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return this.account;
    }

    @Override
    public Boolean play() {return null;}


    @Override
    public Double placeBets(double moneyToBet) {
        return this.bet = moneyToBet;
    }
}
