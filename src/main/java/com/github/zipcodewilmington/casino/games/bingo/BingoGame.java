package com.github.zipcodewilmington.casino.games.bingo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BingoGame {
   public Map markedSpots = new HashMap<Integer[][], Boolean>();
   Random random = new Random();
   BingoBoard board = new BingoBoard();
   Boolean marked;

    public BingoGame(){
//        markedSpots = new HashMap<board, marked>();
    }
       public void markBingoBoard(int numberCalled){
           markedSpots.put(numberCalled, true); // Key should be an int[][] value - we need a method for that
       }

       public int findCoordinate(int numberCalled){
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board.getBingoBoard()[i][j] == numberCalled) {
                        return 0;
                    }
                }
            }
            return 0;
       }

       public int pickBall(){
            int ball= random.nextInt(75) + 1;
           System.out.println(ball);
           return ball;
       }

       // Method to determine if a board has BINGO
            // Method to check row
            // Method to check column
            // Method to check diagonals
}
