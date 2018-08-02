package com.allan.algorithm.taolu.exercises;

public class RotatedArray {

    public static void main(String[] args) {
        int[] input = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        int target = 1;
        int index = findIndexOf(input, target);
        System.out.println("The index is: " + index);
    }

    private static int findIndexOf(int[] input, int target) {
        int start = 0;
        int end = input.length;
        int mid;

        while (start < end) {
            mid = Math.floorDiv(start + end, 2);

            if (input[mid] == target) {
                return mid;
            }

            if (input[start] < input[mid]) {
                if (target >= input[start] && target < input[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= input[start] || target < input[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
