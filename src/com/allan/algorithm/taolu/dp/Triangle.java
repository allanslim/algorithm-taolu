package com.allan.algorithm.taolu.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Triangle {

/*

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).


So the idea here is that, as you go to the next level, you have to always get the minimum. starting from the top,
which is 2, you have the option to find the minimum of the next level.


         [4, 1,  8, 3]
min of     \/ \/   \/
           1   1    3
         + 6  +5   +7
        ----------------
           7  6    10

[7,6,10,3]



 */

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(createList(2));
        triangle.add(createList(3,4));
        triangle.add(createList(6,5,7));
        triangle.add(createList(4,1,8,3));

        int total = minimumTotal(triangle);
        System.out.printf("The total is: " + total);
    }

    private static List<Integer> createList(int ...data) {
        List<Integer> result = new ArrayList<>();
        for (int d : data) {
            result.add(d);
        }
        return result;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // initialize the cache with the data from the base.
        for(int i = 0; i < n; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }

        //start from the second to the last level
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
