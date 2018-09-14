package com.allan.algorithm.taolu.exercises;

/**

 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.


 // using kadane's algorithm

 for example, if you have a n array, and given a kth element

 |m  |  kth |  |

 the maximum subarray, as of kth element is either:

 kth or
 m, kth

 Example:
      v
 [-2, 3]

 the maximum sub array is either:

 (3)  = 3   -or-
 (-2, 3) = 1



 pseudocode:

 set your max_current and max_global to the first element

 max_current  = a[0]
 max_global = a[0]

 loop for a[1] to a[n - 1]

    max_current = max(  a[i], max_current + a[i])

    if max_current > max_global
          max_global = max_current

 return max_global
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
