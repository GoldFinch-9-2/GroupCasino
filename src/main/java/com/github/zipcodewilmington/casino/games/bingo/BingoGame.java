package com.github.zipcodewilmington.casino.games.bingo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BingoGame {
   public Map markedSpots = new HashMap<int[][], Boolean>();
   Random random = new Random();

public BingoGame(){}
   public void markBingoBoard(int numberCalled){
       markedSpots.put(numberCalled, true); // Key should be an int[][] value - we need a method for that
   }

   public int findCoordinate(int numberCalled){
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
