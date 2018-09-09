package com.allan.algorithm.taolu.exercises;

import java.util.Arrays;

public class NQueens {

    /*

    The n-queens puzzle is the problem of placing n queens on an nxn chessboard such that
    no two queens attack each other.

    given an integer n, return all distinct solutions to the n-queens puzzle.


Array convention is: array[row][column]

+--+--+--+--+--+--+
| *|  | *|  | *|  |
+--+--+--+--+--+--+
|  | *| *| *|  |  |
+--+--+--+--+--+--+
| *| *| Q| *| *| *|
+--+--+--+--+--+--+
|  | *| *| *|  |  |
+--+--+--+--+--+--+
| *|  | *|  | *|  |
+--+--+--+--+--+--+
|  |  | *|  |  | *|
+--+--+--+--+--+--+

The queen can attack in the following directions, vertical, horizontal and diagonal.

analysis:
vertical - if the column is equal
horizontal - if the row is equal
left diagonal = if (row - col) is equal
right diagonal - if (row + col) is equal



e.g.
if n = 4
+--+--+--+--+
|  |Q |  |  |
+--+--+--+--+
|  |  |  | Q|
+--+--+--+--+
| Q|  |  |  |
+--+--+--+--+
|  |  | Q|  |
+--+--+--+--+


     */


    static class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static Position[] solveNQueen(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solveNQueenHelper(n, 0, positions);
        if (hasSolution) {
            return positions;
        }else {
            return new Position[0];
        }
    }

    private static boolean solveNQueenHelper(int n, int row, Position[] positions) {
        if(n == row) {
            return true;
        }
        int col;
        for(col = 0; col < n; col++) {
            boolean foundSafe = true;

            for(int queen = 0; queen < row; queen++) {
                if(positions[queen].col == col ||
                   positions[queen].row == row ||
                   positions[queen].row - positions[queen].col == row - col ||
                   positions[queen].row + positions[queen].col == row + col ) {
                    foundSafe = false;
                    break;
                }
            }
            if(foundSafe) {
                positions[row] = new Position(row, col);
                if(solveNQueenHelper(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Position[] positions = solveNQueen(4);
        System.out.println(Arrays.toString(positions));
    }
}
