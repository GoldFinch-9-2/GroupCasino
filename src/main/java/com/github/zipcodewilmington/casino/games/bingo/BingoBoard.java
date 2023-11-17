package com.github.zipcodewilmington.casino.games.bingo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class BingoBoard {
    Integer[][] bingoBoard = new Integer[5][5];
    Random rand = new Random();
    public BingoBoard() {
        this.bingoBoard = populateColumn();
    }

    public Integer[][] populateColumn() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingoBoard[i][j] = rand.nextInt(15) + 1 + (15 * j); // Make sure numbers don't repeat
                for (int k = i; k >= 0; k--) {
                    while (true) {
                        if (Objects.equals(bingoBoard[k][j], bingoBoard[i][j])) {
                            bingoBoard[i][j] = rand.nextInt(15) + 1 + (15 * j);
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return bingoBoard;
    }

    public Integer[][] getBingoBoard() {
        return this.bingoBoard;
    }

}