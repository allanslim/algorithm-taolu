package com.allan.algorithm.taolu.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSumPair {

    /*


                   Inputs:
                   Target value (integer)
                   List of values (integers)

                   Output:
                   Pairs from list of values that add up to the target value

                   Example:
                   20
                   2, 15, 3, 4, 5, 16, 5, 15, 18, 2

                   Output
                   (15,5)
                   (4,16)
                   (5,15)
                   (2,18)


                   2, 18, 18, 2, 2, 18
                   i
                   j

                   map = {
                   2,18
                   18,2
                   }


                   result=(2,18)

                   (2,18)
                   (18,2)
                   (2,18)



The sum pair is defined as two addends equals the sum.

 addends1 + addends2 = sum

now we can re-arrange this equation to give us:

addends1 = sum - addends2  <-- difference


We can store one of the addends in a data structure for fast lookup. So to do this, we loop thru the array, and put data in a hash set.
this will yield a runtime of O(n).


then loop thru the array again, get the difference (target - arr[i])

 if the difference exist in the cache, that means that the pair exist.
  store the pair in the result.


to avoid duplicate, we need to keep track of the pair that was already found, using another set.


 */
    public static void main(String[] args) {
        int[] input = { 2, 15, 3, 4, 5, 16, 5, 15, 18, 2 };

        int target = 20;

        System.out.println("inputs: " + Arrays.toString(input) + ", " + target);
        List<int[]> output = findPairs(input, target);

        System.out.print("output: \n");
        output.stream().forEach( pair -> System.out.println(Arrays.toString(pair)) );

        int[] input2 = { 2, 18, 18, 2, 2, 18 };

        System.out.println("inputs: " + Arrays.toString(input2) + ", " + target);
        List<int[]> output2 = findPairs(input2, target);

        System.out.print("output: \n");
        output2.stream().forEach( pair -> System.out.println(Arrays.toString(pair)) );

    }

    // time complexity: O(n) Space complexity: O(n)
    public static List<int[]> findPairs(int[] input, int target) {

        List<int[]> results = new ArrayList<>();

        // use Set instead of map and cache the values.
        Set<Integer> cache = new HashSet<>();

        Set<Integer> pairFound = new HashSet<>();
        for(int i = 0; i < input.length; i++) {
            cache.add(input[i]);
        }


        for(int i = 0; i < input.length; i++) {

            if(pairFound.contains(input[i])) {
                continue;
            }

            int difference = target - input[i]; // side note: we may have to use Math.absolute() to avoid issue with negative values.

            if ( cache.contains(difference)) { // pair exist in the list.
                results.add(new int[] {input[i], difference });
                pairFound.add(difference);
            }
        }

        return results;
    }
}
