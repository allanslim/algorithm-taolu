package com.allan.algorithm.taolu.exercises;


//int[][] matrix ={
//        {1, 1, 0, 0, 1, 0},
//        {0, 1, 1, 0, 1, 1},
//        {0, 0, 0, 1, 0, 0},
//        {1, 1, 0, 1, 0, 0},
//        {1, 1, 1, 0, 0, 1}};

import java.util.HashSet;
import java.util.Set;

public class findNumberOfIslands {

    public static void main(String[] args) {

        int[][] matrix ={
        {1, 1, 0, 0, 1, 1},
        {1, 1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0},
        {1, 1, 0, 1, 0, 0},
        {1, 1, 0, 0, 0, 1}};

        int count = numberOfIslands(matrix);

        System.out.println("The number of Islands is: " + count);
    }

    private static int numberOfIslands(int[][] matrix) {
        int result = 0;
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && !seen.contains(i + "." + j)) {
                    result++;
                    dfs(i, j, matrix, seen);
                }
            }
        }
        return result;
    }

    private static void dfs(int i, int j, int[][] matrix, Set<String> seen) {
        if( i < 0 || j < 0 ||
           i >= matrix.length || j >= matrix[0].length ||
           matrix[i][j] == 0 ||
           seen.contains(i + "." + j)) {
            return;
        }
        seen.add(i + "." + j);
        dfs(i + 1, j, matrix, seen);
        dfs(i - 1, j, matrix, seen);
        dfs(i, j + 1, matrix, seen);
        dfs(i, j - 1, matrix, seen);
    }
}
