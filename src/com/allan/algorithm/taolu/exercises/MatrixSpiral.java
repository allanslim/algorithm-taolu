package com.allan.algorithm.taolu.exercises;


import java.util.Arrays;

//Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values into a
//1D array in a spiral order, clockwise. Your function then should return that array.
//Analyze the time and space complexities of your solution.
//
//example:
//
//        input:  inputMatrix  = [ [1,    2,   3,  4,    5],
//                                 [6,    7,   8,  9,   10],
//                                 [11,  12,  13,  14,  15],
//                                 [16,  17,  18,  19,  20] ]
//
//        output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
//
//
public class MatrixSpiral {

    /*
    analysis:
        [0] --> [1, 2, 3, 4, 5]
        [1] --> [6. 7. 8. 9. 10]
        [3] --> [11. 12, 13, 14, 15]

        int[row][column]

        boundary = 0

        [row][column++]  = [0][0] , [0][1], .. [0][column - boundary]
        [row++] [ MaxColumn - x] [0][
        [MaxRow - x][ column-- - x]
        [MaxRow-- -x][column - x]



     */
    public static void main(String[] args) {
        
        int[][] inputMatrix =  { {1,    2,   3,  4,    5},
                                 {6,    7,   8,  9,   10},
                                 {11,  12,  13,  14,  15},
                                 {16,  17,  18,  19,  20} };


        int[] spiral = spiralCopy(inputMatrix);
        System.out.println(Arrays.toString(spiral));
    }

    private static int[] spiralCopy(int[][] inputMatrix) {
        int[] result = new int[inputMatrix.length * inputMatrix[0].length];
        int maxRow = inputMatrix.length;
        int maxColumn = inputMatrix[0].length;

        int topRow = 0;
        int bottomRow = maxRow - 1;
        int leftColumn = 0;
        int rightColumn = maxColumn - 1;

        int counter = 0;
        while(topRow <= bottomRow && leftColumn <= rightColumn) {

            for(int i = leftColumn; i <= rightColumn; i++) {
                result[counter] = inputMatrix[topRow][i];
                counter++;
            }
            topRow++;

            for(int i = topRow; i <= bottomRow; i++) {
                result[counter] = inputMatrix[i][rightColumn];
                counter++;
            }
            rightColumn--;

            if(topRow <= bottomRow) {
                for( int i = rightColumn; i >= leftColumn; i--) {
                    result[counter] = inputMatrix[bottomRow][i];
                    counter++;
                }
                bottomRow--;
            }

            if(leftColumn <= rightColumn) {
                for( int i = bottomRow; i >= topRow; i--) {
                    result[counter] = inputMatrix[i][leftColumn];
                    counter++;
                }
                leftColumn++;
            }
        }
        return result;
    }
}
