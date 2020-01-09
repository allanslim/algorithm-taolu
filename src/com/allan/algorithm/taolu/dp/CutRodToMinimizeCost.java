package com.allan.algorithm.taolu.dp;

import java.util.Arrays;

/*

You have to cut a wood stick into pieces. The most affordable company, The Analog Cutting Machinery,
Inc. (ACM), charges money according to the length of the stick being cut. Their procedure of work
requires that they only make one cut at a time.

It is easy to notice that different selections in the order of cutting can led to different prices. For
example, consider a stick of length 10 meters that has to be cut at 2, 4 and 7 meters from one end.
There are several choices. One can be cutting first at 2, then at 4, then at 7. This leads to a price
of 10 + 8 + 6 = 24 because the first stick was of 10 meters, the resulting of 8 and the last one of 6.
Another choice could be cutting at 4, then at 2, then at 7. This would lead to a price of 10 + 4 + 6 =
20, which is a better price.

Your boss trusts your computer abilities to find out the minimum cost for cutting a given stick.

Input
- The input will consist of several input cases. The first line of each test case will contain a positive
number l that represents the length of the stick to be cut. You can assume l < 1000.
- The next line will contain the number n (n < 50) of cuts to be made.
- The next line consists of n positive numbers ci (0 < ci < l) representing the places where the cuts
have to be done, given in strictly increasing order.

An input case with l = 0 will represent the end of the input.

Output
You have to print the cost of the optimal solution of the cutting problem, that is the minimum cost of
cutting the given stick. Format the output as shown below.

Sample Input

100
3
25 50 75

10
4
4 5 7 8


Sample Output
The minimum cutting is 200.
The minimum cutting is 22.

 */
public class CutRodToMinimizeCost {


    public int cutRodToMinimizeCost(int[] markings, int lengthOfRod) {
        int T[][] = new int[lengthOfRod + 1][lengthOfRod + 1];
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                T[i][j] = -1;
            }
        }
        return cutRodToMinimizeCost(markings, 0, lengthOfRod, T);
    }

    private int cutRodToMinimizeCost(int[] markings, int start, int end, int T[][]) {

        displayMatrix(T);

        if (T[start][end] != -1) {
            return T[start][end];
        }

        int i;
        for (i = 0; i < markings.length; i++) {
            if (start < markings[i]) {
                break;
            }
        }

        if (i == markings.length) {
            T[start][end] = 0;
            return 0;
        }

        int j;
        for (j = markings.length - 1; j >= 0; j--) {
            if (end > markings[j]) {
                break;
            }
        }

        if (j == -1) {
            T[start][end] = 0;
            return 0;
        }

        if (i == j) {
            T[start][end] = end - start;
            return end - start;
        }

        int cost = end - start;
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int c1 = cutRodToMinimizeCost(markings, start, markings[k], T);
            int c2 = cutRodToMinimizeCost(markings, markings[k], end, T);

            if (c1 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE) {
                continue;
            }
            if (minCost > c1 + c2) {
                minCost = c1 + c2;
            }
        }

        if (minCost == Integer.MAX_VALUE) {
            T[start][end] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        T[start][end] = cost + minCost;
        return cost + minCost;
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

    public static void main(String args[]) {
        int markings[] = {2, 3, 6, 7};
        CutRodToMinimizeCost cr = new CutRodToMinimizeCost();
//        int cost = cr.cutRodToMinimizeCost(markings, 8);
//        System.out.println(cost);
        int cost2 = cr.cutRodToMinimizeCost(new int[]{2,5}, 8);
        System.out.println(cost2);
    }
}
