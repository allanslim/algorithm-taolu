package com.allan.algorithm.taolu.dp;

/*

 Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time complexity - O(W*total items)

 */
public class KnapsackProblem {

    public int findMaximumValue(int[] values, int[] weights, int knapsackWeight) {
        int[][] memo = new int[weights.length + 1][knapsackWeight + 1];

        for(int row = 1; row < weights.length + 1; row++) {
            for( int col = 1; col < knapsackWeight + 1; col++) {
                int index = row - 1;
                if(col - weights[index] >= 0) {
                    memo[row][col] = Math.max(values[index] + memo[index][col - weights[index]], memo[index][col]);
                } else {
                    memo[row][col] = memo[index][col];
                }
                displayMatrix(memo);
            }
        }

        displayMatrix(memo);
        return memo[values.length][knapsackWeight];
    }

    private void displayMatrix(int[][] matrix ) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                System.out.print("|");
                System.out.print(matrix[row][col]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        int[] values = {1, 4, 5, 7};
        int[] weights = {1, 3, 4, 5};
        int knapsackWeight = 7;

        int maximumValue = knapsackProblem.findMaximumValue(values, weights, knapsackWeight);
        System.out.println("The maximum value is: " + maximumValue);
    }
}
