package com.allan.algorithm.taolu.exercises;

/*

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.

Solution:

The simplest way to solve this is to iterate thru the array, and do a comparison, but this will yield a runtime of n.

Considering that we are looking for a peak, it always be the case that the at any given number, the left and the right side will always be smaller
than the number.

assuming at kth number.

k - 1 < k < k + 1

we can use a modified binary search algorithm to find the peak.


 */
public class FindPeakElement {

    public static void main(String[] args) {

        int value = findPeakElement(new int[]{1, 2, 3, 1});
        System.out.println(value);

        int value2 = findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        System.out.println(value2);
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while( left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;

    }
}
