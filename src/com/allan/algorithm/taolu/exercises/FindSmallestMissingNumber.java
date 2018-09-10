package com.allan.algorithm.taolu.exercises;

public class FindSmallestMissingNumber {


    /*

     0  1  2  3  4
     0, 1, 2, 6, 9


    startIndex = 0
    endIndex = 5


    0 1 2  3
    4 5 10 11

    startIndex = 0
    endIndex = 4


     */
    public static void main(String[] args) {
        int smallestMissingNumber = findSmallestMissingNumber(new int[]{0, 1, 2, 6, 9}, 0, 5);
        System.out.println(smallestMissingNumber); // 3

        smallestMissingNumber = findSmallestMissingNumber(new int[]{4, 5, 10, 11}, 0, 4);
        System.out.println(smallestMissingNumber); // 3
    }

    private static int findSmallestMissingNumber(int[] input, int startIndex, int endIndex) {

        if(startIndex > endIndex) {
            return endIndex + 1;
        }

        if(startIndex != input[startIndex]) {
            return startIndex;
        }

        int middleIndex = ( startIndex + endIndex ) / 2;

        // left half has all elements from 0 to middleIndex
        if(input[middleIndex] == middleIndex) {
            return findSmallestMissingNumber(input, middleIndex + 1, endIndex);
        }

        return findSmallestMissingNumber(input, startIndex, middleIndex);

    }
}
