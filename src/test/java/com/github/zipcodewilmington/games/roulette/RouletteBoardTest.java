package com.github.zipcodewilmington.games.roulette;

import com.github.zipcodewilmington.casino.games.roulette.RouletteBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteBoardTest {

    private RouletteBoard board;
    @Before
    public void setup() {
        this.board = new RouletteBoard();
    }

    @Test
    public void rouletteBoardConstructorTest() {
        Assert.assertNotNull(board);
    }
}
