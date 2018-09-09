package com.allan.algorithm.taolu.exercises;

//Given a package with a weight limit limit and an array arr of item weights,
// implement a function getIndicesOfItemWeights that finds two items whose
// sum of weights equals the weight limit limit. Your function should return a pair [i, j]
// of the indices of the item weights, ordered such that i > j.
// If such a pair doesn’t exist, return an empty array.
//
//        Analyze the time and space complexities of your solution.
//
//        Example:
//
//        input:  arr = [4, 6, 10, 15, 16],  lim = 21
//
//        output: [3, 1]

import java.util.HashMap;
import java.util.Map;

public class GetIndexOfItemWeight {

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        Map<Integer, Integer> differeceToIndexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            Integer differenceIndex = differeceToIndexMap.get(limit - value);
            if(differenceIndex != null) {
                return new int[]{i, differenceIndex};
            }
            differeceToIndexMap.put(value, i);
        }

        return new int[]{};

    }

    public static void main(String[] args) {

        int[] arr = new int[]{4, 6, 10, 15, 16};
        int limit = 21;

        int[] result = getIndicesOfItemWeights(arr, limit);

        System.out.println("result:" + result[0] + " and " + result[1]);

        arr = new int[]{4, 4, 1};
        limit = 5;

        result = getIndicesOfItemWeights(arr, limit);

        System.out.println("result:" + result[0] + " and " + result[1]);

    }
}
