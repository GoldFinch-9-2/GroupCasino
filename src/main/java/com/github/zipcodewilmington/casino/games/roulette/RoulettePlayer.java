package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface, GamblingInterface {
    CasinoAccount account;
    double bet;
    public RoulettePlayer(CasinoAccount account){
        this.account = account;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return account;
    }

    @Override
    public Boolean play() {
        return null;
    }

    @Override
    public double placeBets(double moneyToBet) {
        return this.bet = moneyToBet;
    }
}
