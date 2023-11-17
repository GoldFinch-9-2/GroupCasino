package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    boolean add(PlayerInterface player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    boolean remove(PlayerInterface player);

    /**
     * specifies how the game will run
     */
    void run();

    /**
     * quits the game
     * @return boolean if quit was successful or not
     */
    boolean quit();

    /**
     * asks the player whether they would like to play again
     * @param prompt a prompt to output
     * @return boolean if player would like to play again
     */
    boolean playAgain(String prompt);
}
