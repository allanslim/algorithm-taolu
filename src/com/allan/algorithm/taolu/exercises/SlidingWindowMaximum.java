package com.allan.algorithm.taolu.exercises;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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


 So the idea here is to use a Deque. The deque should have the size of k.
 deque should be storing the index. You use the removeFromHead if the element
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
        if(arr.length == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] results = new int[arr.length - k + 1];
        int count  = 0;

        for (int i = 0; i < arr.length; i++) {
            // remove element out of window
            if(!deque.isEmpty()  && deque.getFirst() == i - k) {
                deque.removeFirst();
            }

            //remove last element if the value is less than the current value
            while(!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
                deque.removeLast();
            }

            // add current value
            deque.addLast(i);

            // if this is the last of the k element add to the results
            if( i >= k - 1) {
                results[count] = arr[deque.getFirst()];
                count++;
            }
        }

        return results;
    }

}
