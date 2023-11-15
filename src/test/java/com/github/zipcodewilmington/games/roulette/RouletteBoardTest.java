package com.github.zipcodewilmington.games.roulette;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

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

    @Test
    public void isRedTest(){


        Boolean actual = board.isRed(1);
    }
}
