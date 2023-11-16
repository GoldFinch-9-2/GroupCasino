package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    String username;
    String password;
    double balance;

    public CasinoAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 5000.00;
    }

    public CasinoAccount(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
