package com.github.zipcodewilmington.games.bingo;

import com.github.zipcodewilmington.casino.games.bingo.BingoBoard;
import org.junit.Test;

import java.util.Arrays;

public class BingoBoardTest {
    @Test
    public void bingoBoingoTest(){
        BingoBoard bb = new BingoBoard();
        System.out.println(Arrays.deepToString(bb.populateColumn()));
    }
}
