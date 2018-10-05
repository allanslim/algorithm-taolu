package com.allan.algorithm.taolu.exercises;



import java.util.HashMap;
import java.util.Map;

public class FindSetOfNumbersThatAddUpToACertainNumber {

//    find sets of number that adds up to a certain number.
//    array  = [2,4,6,10]
//    k = 16
//    answer:  2 subsets (6, 10) and (2, 4, 10)

/*

We use dynamic programming to solve this problem. First we can start from empty array.

{}

and starting from the right most element which as the value of 10, we should ask ourselves, shall we include
the value of 10 or not?



   if yes {10}
  /
{}
  \
    if no {}


Then we continue to the next element, which is 6.





       / {10,6}
   {10}
  /    \
{}       {10}
 \
  \    {6}
   \  /
    {}
      \
       {}


 */

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
        // if k is zero, there's only 1 subset that has zero total, that would be the empty subset {}.
        if (k == 0) {
            return 1;
        }
        // if key is negative, then return 0.
        else if (k < 0) {
            return 0;
        }
        // when the index is less than zero.
        else if (index < 0) {
            return 0;
        }
        // if k is less than current item, we need to skip this current item, because there's no way to find a subset including this current item.
        else if (k < input[index]) {
            int currentValue = findNumberOfSubsets(input, k, index - 1, map);
            map.put(key, currentValue);
            return currentValue;
        }
        // the sum of the current subset and the next subset.
        else {
            int currentValue =  findNumberOfSubsets(input, k - input[index], index - 1, map) + findNumberOfSubsets(input, k, index - 1, map );
            map.put(key, currentValue);
            return currentValue;
        }

    }
}
