package com.allan.algorithm.taolu.exercises;

/**

 Given an array of integers, and an integer used as an interval. Find the maximum sum in the array.

 [4,1,5,4,7,8,3] and 3

 since the interval is 3, you have

 4,1,5 = 10
 1,5,4 = 10
 5,4,7 = 16
 4,7,8 = 19
 7,8,3 = 18
 8,3 = 11
 3 = 3

 The maximum is 19.


 Example 2:

 [3,4,1,3,4,5] and 2

 3,4 = 7
 4,1 = 5
 1,3 = 4
 3,4 = 7
 4,5 = 9

 The maximum is 9


 So we need to use sliding window technique. start with having left, right variable.



 [4,1,5,4,7,8,3]
  l
  r

 initialize the sum to the first element.

 sum = arr[l]
 max = Integer.MIN_VALUE

 while left is less than array.length and
       right is less than array.length - 1


 [4,1,5,4,7,8,3]
 l
     r


 [4,1,5,4,7,8,3]
    l
       r


 [4,1,5,4,7,8,3]
          l
             r

 */
public class SlidingWindow {
    // Find Max Sum Given Array And an Interval
    // maximum sum of a subarray
    // of size k
    public static void main(String[] args) {
//        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
//        int k = 4;
        int arr[] = {4,1,5,4,7,8,100};
        int k = 3;
        long start = System.nanoTime();
        System.out.print("The maximum sum of subarray of size " + k + " is: " + maxSum(arr, k));
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.print(" -- " + timeElapsed + "\n");

        start = System.nanoTime();
        System.out.print("The maximum sum of subarray of size " + k + " is: " + maxSumBetter(arr, k));
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.print(" -- " + timeElapsed + "\n");
    }


    private static int maxSumBetter(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int sum = arr[left];
        int max = Integer.MIN_VALUE;
        while( left < arr.length &&
               right < arr.length - 1) {
            right += 1; // grow window by 1 every time
            sum += arr[right];
            if( right - left + 1 == k) {
                max = Math.max(max, sum); // calculate max
                sum = sum - arr[left]; // subtract the sum with the value of the left.
                left += 1; // shrink the window after reaching the range
            }
        }
        return max;
    }

    private static int maxSum(int[] arr, int k) {
        int maximumSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - k + 1; i++) {
            int currentSum = 0;
            for( int j = 0; j < k; j++) {
                currentSum = currentSum + arr[i + j];
                maximumSum = Math.max(currentSum, maximumSum);
            }
        }
        return maximumSum;
    }
}
