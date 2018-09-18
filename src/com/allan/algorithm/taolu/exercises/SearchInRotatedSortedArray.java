package com.allan.algorithm.taolu.exercises;

public class SearchInRotatedSortedArray {

/**

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4


 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1

 ------------

 Okay, the naive approach to this is just walk thru the array and do a comparison until you find the target output.
 But this will yield a runtime of O(n) and space of O(n).

 We need to take advantage of the fact that the array is sorted.

 But since the array is rotated, the first thing to do is to find the index of the rotation pivot.

 in this example, the pivot is 4.

 [4,5,6,7,0,1,2]
          ^

 Now, once you found this pivot, you can use binary search to the left or the right of pivot.


 binary search( 4, 5,6, 7) and binary search( 0, 1, 2).


 To find a pivot you need the following steps.


first check if array is rotated:

 1) if array[0] <= array[lengh of array - 1], it means that the array is not rotated, so return 0.
 2) initialize start = 0 and end = length of array -1.
 3) do a loop until start <= end

 a) set mid = (start+end)/2
 b) check if mid > mid+1, if true, then mid+1 is pivot
 c) check if array[start] <= array[mid], it means from start to mid, all elements are in sorted order.
    set start = mid + 1, so that we look for pivot in second half of the array.
 d) else set end = mid - 1, to look for pivot in the first half.

 eventually we will find that 4 is our pivot, then since target binary search to the right, the start is equals to
 4 and end is 6.

 The steps to do binary search is:

 1) loop until start <= end
    a) set mid = (start + end )/ 2
    b) check if array[mid] == number, then return mid
    c) if num < array[mid], set end = mid - 1
    d) else set start = mid + 1

 2) return -1 (not found)


 */
    public static void main(String[] args) {
        int[] input =  {4,5,6,7,0,1,2};
        int output = searchRotatedSortedArray(input, 0);
        System.out.println("the output is: " + output);

        output = searchRotatedSortedArray(input, 5);
        System.out.println("the output is: " + output);

        int output3 = searchRotatedSortedArray(new int[] {1,3}, 0);
        System.out.println("the output is: " + output3); // 0
    }

    public static int searchRotatedSortedArray(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) {
            return 1;
        } else if (nums.length == 0 || nums[0] <= nums[nums.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        int pivot = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                pivot = mid + 1;
                break;
            } else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (pivot < target) {
            return binarySearch(nums, start, pivot, target);
        } else {
            return binarySearch(nums, pivot, end, target);
        }
    }


    public static int binarySearch(int[] input, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (input[mid] == target) {
                return mid; // return index
            } else if (target < input[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}
