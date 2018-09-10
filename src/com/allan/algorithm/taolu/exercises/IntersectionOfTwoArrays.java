package com.allan.algorithm.taolu.exercises;


import java.util.*;
import java.lang.Integer;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

        System.out.println(Arrays.toString(intersect(new int[] {1,2,2,1}, new int[] {2,2})));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> results = new ArrayList<>();

        for (int n : nums1) {
            if(map.containsKey(n)) {
                map.put(n,map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        for (int n : nums2) {
            if(map.containsKey(n)) {
                if(map.get(n) > 0) {
                    map.put(n, map.get(n) - 1);
                    results.add(n);
                }
            }
        }

        int[] finalResults = new int[results.size()];
        for(int i = 0; i < results.size(); i++) {
            finalResults[i] = results.get(0);
        }
        return finalResults;
    }
}
