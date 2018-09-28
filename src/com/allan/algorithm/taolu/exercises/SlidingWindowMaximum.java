package com.allan.algorithm.taolu.exercises;

import java.util.Arrays;

public class SlidingWindowMaximum {
/**

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

 Example:

 Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 Output: [3,3,5,5,6,7]
 Explanation:

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Note:
 You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.


 So the idea here is to use a Deque. The deque holds only the maximum value of a given
 size. That size would be k. You use the removeFromHead if the element
 is out of window, and use the removeFromTail, if the element is lesser
 than the currenet element

 deque = []
 result = []

Loop thru the array and first check if deque is

 1) remove element is out of window.

 2) if the deque tail is less than current element, you pop tail

 3) push current element in the deque.

 4) if reach the k max, push the front to result.

 */

public static void main(String[] args) {
    int[] maxSlidingWindow = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    System.out.println(Arrays.toString(maxSlidingWindow));
}

public static int[] maxSlidingWindow(int[] arr, int k) {
}
