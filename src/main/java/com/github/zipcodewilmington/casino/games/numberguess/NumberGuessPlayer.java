package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class NumberGuessPlayer implements PlayerInterface, GamblingInterface {
    //@Override
    CasinoAccount account;

    public NumberGuessPlayer(CasinoAccount account){
        this.account = account;
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return this.account;
    }

    @Override
    public Boolean play() {return false;}

    @Override
    public Double placeBets(double moneyToBet) {
        return moneyToBet;
    }
}