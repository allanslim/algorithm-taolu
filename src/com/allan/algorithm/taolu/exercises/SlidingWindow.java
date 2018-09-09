package com.allan.algorithm.taolu.exercises;

public class SlidingWindow {
    // maximum sum of a subarray
    // of size k
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println("The maximum sum of subarray of size " + k + " is: " + maxSum(arr, k));
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
