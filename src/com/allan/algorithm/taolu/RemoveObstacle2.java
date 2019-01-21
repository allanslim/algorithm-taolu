package com.allan.algorithm.taolu;

import java.util.ArrayList;
import java.util.List;

public class RemoveObstacle2 {

    public static int removeObstacleX(int numRows, int numColumns, List<List<Integer>> lot) {

        int dist = removeObstacle(0, 0, numRows, numColumns, lot, 0);
        return dist;
    }

    private static int removeObstacle(int i, int j, int numRows, int numColumns, List<List<Integer>> lot, int dist) {
        if (i < 0 && i >= numRows && j < 0 && j >= numColumns && lot.get(i).get(j) == 0) {
            return 0;
        }
        if (lot.get(i).get(j) == 9) {
            return dist;
        }
        dist = removeObstacle(i + 1, j, numRows, numColumns, lot, dist);
        dist = removeObstacle(i - 1, j, numRows, numColumns, lot, dist);
        dist = removeObstacle(i, j + 1, numRows, numColumns, lot, dist);
        dist = removeObstacle(i, j - 1, numRows, numColumns, lot, dist);

        return dist + 1;
    }

    public static void main(String[] args) {
        int numRows = 5;
        int numColumns = 4;
        List<List<Integer>> lot = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        row1.add(1);
        row1.add(1);
        lot.add(row1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(1);
        row2.add(1);
        row2.add(1);
        lot.add(row2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(1);
        row3.add(0);
        row3.add(1);
        lot.add(row3);
        List<Integer> row4 = new ArrayList<>();
        row4.add(1);
        row4.add(1);
        row4.add(9);
        row4.add(1);
        lot.add(row4);
        List<Integer> row5 = new ArrayList<>();
        row5.add(0);
        row5.add(0);
        row5.add(1);
        row5.add(1);
        lot.add(row5);
        int minimumDistance = removeObstacleX(numRows, numColumns, lot);
        System.out.println(minimumDistance);
    }
}
