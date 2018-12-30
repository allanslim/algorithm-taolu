package com.allan.algorithm.taolu.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedInts = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        boolean found = findNumber(10, sortedInts);
        System.out.println(found);
    }

    // recursive solution
    private static boolean findNumber(int x, int[] input) {
//        return binarySearchRecursive(x, input, 0, input.length);
        return binarySearchIterative(x, input);
    }

    private static boolean binarySearchRecursive(int x, int[] input, int left, int right) {
        if(left > right) {
            return false;
        }
        int mid = left + ((right - left) / 2);
        if( x == input[mid]) {
            return true;
        }
        else if( x < input[mid]) {
            return binarySearchRecursive(x, input, left, mid - 1);
        } else {
            return binarySearchRecursive(x, input, mid + 1, right);
        }
    }

    private static boolean binarySearchIterative(int x, int[] input) {
        int left = 0;
        int right = input.length;

        while( left <= right) {
            int mid = left + ((right - left) / 2);
            if( x == input[mid]) {
                return true;
            }
            else if( x < input[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
