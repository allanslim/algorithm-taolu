package com.allan.algorithm.taolu.exercises;

/**

 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.

 The naive solution is to do brute force, checking each subarray. But that will yield O(n^2) - quadratic

 There's a better solution, for example:

 [1, -3, 2, 1, -1]
  ^   ^  ^  ^   ^

 Let say, you are trying to solve the maximum so far sum ending at each index.

 so for example, at index 2, so the maximum subarray from previous index would be:

 [1, -3] 2
         ^

 so the interesting idea here is that the local maximum subarray [2] is either the current element or the current
 element combined with the preious maximum subarray.

 [2] -or-
 [1, -3, 2]

 you can compare only those and ignore the rest of the element, and the value is [2].

 and you can do everything at each index, except for the first one. For the first one, you just have to choose.


 pseudocode:

 set your max_current and max_global to the first element

 max_current  = a[0]
 max_global = a[0]

 loop for a[1] to a[n - 1]

    max_current = max(  a[i], max_current + a[i])

    if max_current > max_global
          max_global = max_current

 return max_global

 using kadane's algorithm

 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSubarray = maxSubArray(input);
        System.out.println(maxSubarray); // 6
    }

    private static int maxSubArray(int[] input) {
        if (input.length == 0) {
            return 0;
        }

        int maxCurrent = input[0];
        int maxGlobal = input[0];
        for (int i = 1; i < input.length; i++) {
            maxCurrent = Math.max(input[i], maxCurrent + input[i]);
            if(maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

}
