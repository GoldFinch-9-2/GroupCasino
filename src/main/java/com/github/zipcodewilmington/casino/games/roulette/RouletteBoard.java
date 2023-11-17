package com.github.zipcodewilmington.casino.games.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RouletteBoard {
    ArrayList<Integer> redNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
    ArrayList<String> allNumbers = new ArrayList<>();
    HashMap<String, Boolean> numberConditions = new HashMap<>();
    HashMap<String, Map<String, Boolean>> rouletteBoard;

    public RouletteBoard() {
        this.rouletteBoard = populateBoard();
    }

    public HashMap<String,Map<String, Boolean>> populateBoard() {
        HashMap<String, Map<String, Boolean>> board = new HashMap<String, Map<String, Boolean>>();
        for (int i = 1; i <= 36; i++) {
            allNumbers.add(Integer.toString(i));
        }

        for (int i = 0; i < allNumbers.size(); i++) {
            if (redNumbers.contains(Integer.valueOf(allNumbers.get(i)))){
                numberConditions.put("Red", true);
            }
            else {
                numberConditions.put("Red", false);
            }
            if (Integer.valueOf(allNumbers.get(i)) % 2 == 0){
                numberConditions.put("Odd", true);
            }
            else {
                numberConditions.put("Odd", false);
            }
            if (Integer.valueOf(allNumbers.get(i)) <= 12){
                numberConditions.put("FirstThird", true);
            }
            else {
                numberConditions.put("FirstThird", false);
            }
            if (Integer.valueOf(allNumbers.get(i)) <= 18){
                numberConditions.put("FirstHalf", true);
            }
            else {
                numberConditions.put("FirstHalf", false);
            }
            if (Integer.valueOf(allNumbers.get(i)) >= 13 && Integer.valueOf(allNumbers.get(i)) <= 24){
                numberConditions.put("SecondThird", true);
            }
            else {
                numberConditions.put("SecondThird", false);
            }
            if (Integer.valueOf(allNumbers.get(i)) >= 24 && Integer.valueOf(allNumbers.get(i)) <= 36){
                numberConditions.put("LastThird", true);
            }
            else {
                numberConditions.put("LastThird", false);
            }
            board.put(allNumbers.get(i), numberConditions);
        }
        return board;
    }
}
