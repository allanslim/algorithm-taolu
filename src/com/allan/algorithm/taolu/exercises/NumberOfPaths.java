package com.allan.algorithm.taolu.exercises;
//
//You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid.
//The car is supposed to get to the opposite, Northeast (top-right), corner of the grid.
//Given n, the size of the grid’s axes, write a function numOfPathsToDest that returns the number of the
//possible paths the driverless car can take.
//
//For convenience, let’s represent every square in the grid as a pair (i,j). The first coordinate in the pair
//denotes the east-to-west axis, and the second coordinate denotes the south-to-north axis.
//The initial state of the car is (0,0), and the destination is (n-1,n-1).
//
//The car must abide by the following two rules: it cannot cross the diagonal border.
//In other words, in every step the position (i,j) needs to maintain i >= j. See the illustration above for n = 5.
//In every step, it may go one square North (up), or one square East (right),
//but not both. E.g. if the car is at (3,1), it may go to (3,2) or (4,1).
//
//Explain the correctness of your function, and analyze its time and space complexities.
//
//+----+----+----+----+
//|    |    |    |4,4 |
//+----+----+----+----+
//|    |    |    |    |
//+----+----+----+----+
//|    |    |    |    |
//+----+----+----+----+
//|0,0 |1,0 |2,0 |    |
//+----+----+----+----+
//
//
//input:  n = 4
//
//output: 5
//# since there are five possibilities:
//# “EEENNN”, “EENENN”, “ENEENN”, “ENENEN”, “EENNEN”,
//# where the 'E' character stands for moving one step
//# East, and the 'N' character stands for moving one step
//# North (so, for instance, the path sequence “EEENNN”
//# stands for the following steps that the car took:
//# East, East, East, North, North, North)
//


public class NumberOfPaths {

    static int numOfPathsToDest(int n) {

        int[][] memo = new int[n][n];

        for(int i = 0; i < n; i++) {
            for( int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return findnumOfPaths(0,0, n - 1, n - 1, memo);

    }

    static int findnumOfPaths(int i, int j, int maxI, int maxJ, int[][] memo) {

        if (i > maxI || j > maxJ) {
            return 0;
        } else if (j > i) {
            memo[i][j] = 0;
        } else if (memo[i][j] != -1) {
            return memo[i][j];
        } else if (i == maxI && j == maxJ) {
            memo[i][j] = 1;
        } else {
            memo[i][j] = findnumOfPaths(i + 1, j, maxI, maxJ, memo) + findnumOfPaths(i, j + 1, maxI, maxJ, memo);
        }


        return memo[i][j];
    }


    public static void main(String[] args) {
        int num = numOfPathsToDest(20);
        System.out.println(num);
    }
}
