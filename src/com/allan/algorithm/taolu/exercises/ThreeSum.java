package com.allan.algorithm.taolu.exercises;

import java.util.*;

public class ThreeSum {

    /**
     *

     Given a list of integers, write a function that returns all sets of 3 numbers in the list, a, b, and c so that
     a + b + c == 0

The naive approach is to use 3 pointers and loop thru each combination to get the highest value. But that
 would give us O(n^3).


We can optimize our solution using 2 pointer, instead of 3. In order for us to do this 2 pointers, we need to sort our input first. e.g.

     [-4, -1, -1, 0, 1, 2]


     after sorting, we loop thru the array, then we need two pointers. start and end.


     [-4, -1, -1, 0, 1, 2]
       ^   ^            ^
       |   |            |
       i  start         end

while start < end, we check if:


  if    num[i] + num[start] + num[end] = 0

     store the 3 values in the result:


  if nums[i] + nums[start] + nums[end] < 0

     we then increment start

   else
      we then increment end

     */
    public static void main(String[] args) {
        List<List<Integer>> results = threeSum(new int[] {-1, 0, 1, 2, -1, -4});

        results.stream().forEach(
                rs -> rs.stream().forEach(
                        r -> System.out.println(r)
                )
        );
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i <= nums.length - 2; i++) {
            int start = i+1;
            int end = nums.length - 1;

            while( start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    List<Integer> tsumList = new ArrayList<>();
                    tsumList.add(nums[i]);
                    tsumList.add(nums[start]);
                    tsumList.add(nums[end]);
                    results.add(tsumList);
                }

                if (nums[i] + nums[start] + nums[end] < 0) {
                    int currentj = start;
                    while (nums[start] == nums[currentj] && start < end) {
                        start++;
                    }
                    start++;
                } else {
                    int currentk = end;
                    while (nums[end] == nums[currentk] && start < end) {
                        end--;
                    }
                    end--;
                }
            }
        }
        return new ArrayList<>(results);
    }
}
