package com.allan.algorithm.taolu.exercises;


import java.util.PriorityQueue;

//
// K-Messed Array Sort
//        Given an array of integers arr where each element is at most k places away from its sorted position,
//        code an efficient function sortKMessedArray that sorts arr.
//        For instance, for an input array of size 10 and k = 2,
//        an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
//
//        Analyze the time and space complexities of your solution.
//
//        Example:
//
//        input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
//
//        output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//
public class KmessedArraySort {


    static int[] sortKMessedArray(int[] arr, int k) {

        PriorityQueue<Integer> minHeap =  new PriorityQueue<>(k + 1);

        int[] result = new int[arr.length];

        for ( int i = 0; i <= k; i++) {
            minHeap.add(arr[i]);
        }

        int resultIndex = 0;
        for ( int j = k + 1; j < arr.length; j++) {
            int minValue = minHeap.poll();
            result[resultIndex] = minValue;
            resultIndex++;
            minHeap.add(arr[j]);
        }

        for( int i = 0; i <= k; i++) {
            result[resultIndex] = minHeap.poll();
            resultIndex++;
        }

        return result;
    }


    public static void main(String[] args) {

        int[] arr = {1};
        int k = 0;

        System.out.println(" array is: ");
        int[] newArr = sortKMessedArray(arr, k);
        for(int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]);
        }

    }
}
