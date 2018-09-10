package com.allan.algorithm.taolu.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

first thing to do is to sort the array


 input = {-1, 0, 1, 2, -1, -4}

 sorted = { -4, -1, -1, 0, 1, 2}

loop thru the sorted array ( from zero to length - 3), and use 2 additional variables. start and end.

i  = 0
start = i + 1
end = arraylength - 1


-4, -1, -1, 0, 1, 2
i
     s
                  e

given the value of i as -4, find start and end, where:

 if i + start + end = 0, store the value in the result.

 if i + start + end < 0, increment start until the value is not duplicated.

 uf i + start + end > 0, increment end until the value is not duplicate


 */

public class FindThreeSum {

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<int[]> threeSums = findThreeSum(input);
        threeSums.forEach(sums -> System.out.println(" 3 sums: " + Arrays.toString(sums)));
    }

    private static List<int[]> findThreeSum(int[] input) {
        List<int[]> results = new ArrayList<>();

        Arrays.sort(input); // n log n

        for (int i = 0; i < input.length - 3; i++) {  // n
            int start = i + 1;
            int end = input.length - 1;

            while (start < end) {
                if (input[i] + input[start] + input[end] == 0) {
                    results.add(new int[]{input[i], input[start], input[end]});
                }

                if (input[i] + input[start] + input[end] < 0) {
                    int currentStart = start;
                    while (input[start] == input[currentStart] && start < end) {
                        start++;
                    }
                } else {
                    int currentEnd = end;
                    while (input[end] == input[currentEnd] && start < end) {
                        end--;
                    }
                }
            }
        }
        return results;
    }
}
