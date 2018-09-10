package com.allan.algorithm.taolu.exercises;

import java.util.*;

public class ThreeSum {

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
//                    int currentj = start;
//                    while (nums[start] == nums[currentj] && start < end) {
//                        start++;
//                    }
                    start++;
                } else {
//                    int currentk = end;
//                    while (nums[end] == nums[currentk] && start < end) {
//                        end--;
//                    }
                    end--;
                }
            }
        }
        return new ArrayList<>(results);
    }
}
