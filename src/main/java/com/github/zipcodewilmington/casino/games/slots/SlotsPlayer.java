package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface, GamblingInterface {
    CasinoAccount casinoAccount;

    public SlotsPlayer(CasinoAccount casinoAccount){
        this.casinoAccount = casinoAccount;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }

    @Override
    public Boolean play() {
        return false;
    }

    @Override
    public Double placeBets(double moneyToBet) {
        return moneyToBet;
    }
}