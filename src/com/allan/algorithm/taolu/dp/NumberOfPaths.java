package com.allan.algorithm.taolu.dp;

/*

The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints
that from each cell you can either move only to right or down.

Examples:

Input :  m = 2, n = 2;
Output : 2
There are two paths
(0, 0) -> (0, 1) -> (1, 1)
(0, 0) -> (1, 0) -> (1, 1)

Input :  m = 2, n = 3;
Output : 3
There are three paths
(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)


 */
public class NumberOfPaths {

    public static void main(String[] args) {
        int paths = numberOfPaths(5,5);
        System.out.println(paths);
        paths = numberOfPaths(2,3);
        System.out.println(paths);
    }

    // Returns count of possible paths to reach
    // cell at row number m and column number n
    // from the topmost leftmost cell (cell at 1, 1)
    private static int numberOfPaths(int m, int n) {

        // If either given row number is first or
        // given column number is first
        if ( m == 1 || n == 1) {
            return 1;
        }

        // If diagonal movements are allowed then
        // the last addition is required.
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        // + numberOfPaths(m-1,n-1);
    }
}
