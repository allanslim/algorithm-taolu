package com.allan.algorithm.taolu.exercises;



import java.util.HashMap;
import java.util.Map;

public class FindSetOfNumbersThatAddUpToACertainNumber {

//    find sets of number that adds up to a certain number.
//    array  = [2,4,6,10]
//    k = 16
//    answer:  2 subsets (6, 10) and (2, 4, 10)


    public static void main(String[] args) {
        int input[] = {2, 4, 6, 10};
        int k = 16;

        int total = findNumberOfSubsets(input, k);
        System.out.println("the number of subsets is: " + total);

    }

    private static int findNumberOfSubsets(int[] input, int k) {
        Map<String, Integer> map = new HashMap<>();
        return findNumberOfSubsets(input, k, input.length - 1, map);
    }

    private static int findNumberOfSubsets(int[] input, int k, int index, Map<String,Integer> map) {
        String key = k + ":" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (k == 0) {
            return 1;
        } else if (k < 0) {
            return 0;
        } else if (index < 0) {
            return 0;
        } else if (k < input[index]) {
            int currentValue = findNumberOfSubsets(input, k, index - 1, map);
            map.put(key, currentValue);
            return currentValue;
        } else {
            int currentValue =  findNumberOfSubsets(input, k - input[index], index - 1, map) +
                    findNumberOfSubsets(input, k, index - 1, map );
            map.put(key, currentValue);
            return currentValue;
        }

    }
}
