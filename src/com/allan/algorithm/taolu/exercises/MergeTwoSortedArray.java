package com.allan.algorithm.taolu.exercises;

import java.util.Arrays;

public class MergeTwoSortedArray {


    /**
     One naive solution, is to combine the array. then sort them. That would be  O (n log n), but that's not the most efficient.


     public static int[] mergeSortedArrays(int[] myArray, int[] alicesArray) {
         int[] mergedArray = Arrays.copyOf(myArray, myArray.length + alicesArray.length);
         System.arraycopy(alicesArray, 0, mergedArray, myArray.length, alicesArray.length);
         Arrays.sort(mergedArray);
         return mergedArray;
     }

     but we should take advantage of the fact that the inputs are already sorted. We know that each have their smallest item
     in the 0th index. So the smallest item overall is the 0th index of one of our input arrays.

     which 0th element is it? Which ever is smaller.

     int[] mergedArray = new int[input1.length + input2.length];

     int headOfInput1 = input1[0];
     int headOfInput2 = input2[0];

     if (headOfInput1 < headOfInput2) {
         mergedArray[0] = headOfInput1;
     } else {
         mergedArray[0] = headOfInput2;
     }

     Then you can loop thru the arrays:

     int[] mergedArray = new int[input1.length + input2.length];

     int currentIndexMerged = 0;
     int currentIndexInput1 = 0;
     int currentIndexInput2 = 0;


     while (currentIndexMerged < mergedArray.length) {
         int firstUnmergedInput1 = input1[currentIndexInput1];
         int firstUnmergedInput2 = input2[currentIndexInput2];

         if (firstUnmergedInput1 < firstUnmergedInput2) {
             mergedArray[currentIndexMerged] = firstUnmergedInput1;
             firstUnmergedInput1++;
         } else {
             mergedArray[currentIndexMerged] = firstUnmergedInput2;
             firstUnmergedInput2++;
         }
         currentIndexMerged++;
     }

     Okay, this algorithm makes sense. To wrap up, we should think about edge cases and check for bugs. What edge cases should we worry about?

     Here are some edge cases:

     One or both of our input arrays is 0 elements or 1 element
     One of our input arrays is longer than the other.
     One of our arrays runs out of elements before we're done merging.

     Actually, (3) will always happen. In the process of merging our arrays, we'll certainly exhaust one before we exhaust the other.

     Does our method handle these cases correctly?

     We'll get an ArrayIndexOutOfBoundsException in all three cases!


     int currentIndexMerged = 0;
     int currentIndexInput1 = 0;
     int currentIndexInput2 = 0;


     while (currentIndexMerged < mergedArray.length) {
         if (currentIndexInput1 >= input1.length) {
             mergedArray[currentIndexMerged] = input2[currentIndexInput2];
             currentIndexInput2++;

         } else if (currentIndexInput2 > input2.length) {
             mergedArray[currentIndexMerged] = input1[currentIndexInput1];
             currentIndexInput1++;

         } else if (input1[currentIndexInput1] < input2[currentIndexInput2]) {
             mergedArray[currentIndexMerged] = input1[currentIndexInput1];
             currentIndexInput1++;

         } else {
             mergedArray[currentIndexMerged] = input2[currentIndexInput2];
             currentIndexInput2++;
         }

         currentIndexMerged++;
     }

     return mergedArray;

     That's not DRY.  Maybe we can avoid repeating ourselves by bringing our code back down to just 2 cases.

     See if you can do this in just one "if else" by combining the conditionals.

     You might try to simply squish the middle cases together:

     if (isAlicesArrayExhausted
     || (myArray[currentIndexMine] < alicesArray[currentIndexAlices])) {
         mergedArray[currentIndexMerged] = myArray[currentIndexMine];
         currentIndexMine++;

     But what happens when myArray is exhausted?

     We'll get an ArrayIndexOutOfBoundsException when we try to access myArray[currentIndexMine]!

     How can we fix this?

     */
    public static void main(String[] args) {
        int[] input1 = {3, 4, 6, 10, 11, 15};
        int[] input2 = {1, 5, 8, 12, 14, 19};

        System.out.println(Arrays.toString(mergeArrays(input1, input2)));
        // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
    }

    private static int[] mergeArrays(int[] input1, int[] input2) {

        int[] mergedArray = new int[input1.length + input2.length];

        int currentIndexMerged = 0;
        int currentIndexInput1 = 0;
        int currentIndexInput2 = 0;


        while (currentIndexMerged < mergedArray.length) {

            boolean input1IsExhausted = currentIndexInput1 >= input1.length;
            boolean index2IsExhausted = currentIndexInput2 >= input2.length;

            // input must not be exhausted, and EITHER:
            // 1) input2's array IS exhausted, or
            // 2) the current element in input1 is less
            //    than the current element in input2's array

            if (!index2IsExhausted &&
                (input1IsExhausted || input1[currentIndexInput1] > input2[currentIndexInput2])) {
                mergedArray[currentIndexMerged] = input2[currentIndexInput2];
                currentIndexInput2++;
            } else if (!input1IsExhausted &&
                      (index2IsExhausted || input1[currentIndexInput1] < input2[currentIndexInput2])) {
                mergedArray[currentIndexMerged] = input1[currentIndexInput1];
                currentIndexInput1++;

            }

            currentIndexMerged++;
        }

        return mergedArray;
    }
}
