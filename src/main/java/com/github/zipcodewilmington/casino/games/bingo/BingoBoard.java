package com.github.zipcodewilmington.casino.games.bingo;

import java.util.Random;

public class BingoBoard {
    Integer[][] bingoBoard = new Integer[5][5];
    Random rand = new Random();

    public Integer[][] populateColumn(int col) {
//        for (int i = 0; i < 5; i++) {
//            if (bingoBoard[i][col] == )
//                bingoBoard[i][col] = rand.nextInt(15) + 1 + (15 * col); // Make sure numbers don't repeat
//
//        }
        return bingoBoard;
    }

    public boolean checkDuplicate(int col, int assignedNum) {
//        for (int i = 0; i < 5; i++) {
//            if (bingoBoard[i][col] == bin) {
//
//            }
//        }
        return true;
    }

    public Integer[][] getBingoBoard() {
        return this.bingoBoard;
    }

    public Integer[][] populateBoard() { //Help here
        for (int i = 0; i < 5; i++) {
            populateColumn(i);

        }
//        }return bingoBoard;
//    }  for (int j = 0; j < 5;j++){
//        populateRow(j);
        return null;
    }
}