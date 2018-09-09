package com.allan.algorithm.taolu.exercises;


//given two unsorted arrays of integers,
// and knowing that the first array has one more unique integers that does not exist in the second array,
// write a function to find that unique element.
//
//

public class FindUniqueElementInArray {
    public static void main(String[] args) {
        int[] input1 = {3, 6, 8, 12, 4};
        int[] input2 = {4, 8, 12, 6};
        System.out.println(" unique integer is: " + findUniqueInteger(input1, input2));
    }

    // number XOR zero = number
    // number XOR number = zero
    // 4 XOR 7 = 3
    // 3 XOR 4 = 7
    // 4 XOR 3 = 7
    // 7 XOR 4 = 3
    private static int findUniqueInteger(int[] input1, int[] input2) {
        int result = 0;

        for(int i = 0; i < Math.min(input1.length, input2.length); i++) {
            int temp =  input1[i] ^ input2[i];
            result ^= temp;

        }
        result = result ^ input1[input1.length - 1];

        return result;
    }
}
