package com.allan.algorithm.taolu.exercises;


/*

Given an array of integers, print all  the subset.

input: [1,2,3]

(empty)
1
2
3
12
13
23
123

Using a smaller set [1,2]

1) start with empty array, then you have two choice. to include 1 or not.



      /{1,2}
  /{1}
{}    \{1}
  \
   \   /{2}
    \{}
       \{}


 There are 2^n subset, and the runtime is also 2^n

 */
public class PowerSetRecursive {

    public static void main(String[] args) {
        int[] input = {1,2,3};
        printPowerSet(input);
    }

    private static void printPowerSet(int[] input) {
        int[] subset = new int[input.length];
        helper(input, subset, 0);
    }

    private static void helper(int[] input, int[] subset, int i) {
        if( i == input.length) {
            printSet(subset);
        }
        else {
            subset[i] = -1;
            helper(input, subset, i + 1);
            subset[i] = input[i];
            helper(input, subset, i + 1);
        }
    }

    private static void printSet(int[] subset) {
        for(int i = 0; i < subset.length; i++) {
            if(subset[i] != -1) {
                System.out.print(subset[i]);
            }
        }
        System.out.println("");
    }
}
