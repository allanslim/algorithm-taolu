package com.allan.algorithm.taolu.exercises.bit;

public class SumOfArray {


    public static void main(String[] args) {

//        int[] input = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};

//        BinaryIndexedTree bitree = new BinaryIndexedTree(input);


//        System.out.println("total sum at index 2? " + bitree.getSum(2)); // the sum so far at index 2 is 4.
//        System.out.println("total sum at index 5? " + bitree.getSum(5)); // the sum so far at index 2 is 12.

        int[] input = {2,3,9,4,2,1,1,5};

        BinaryIndexedTree bitree = new BinaryIndexedTree(input);

        for (int i = 0; i < 20; i++) {
            System.out.println("" + i + " & " + (-i) + " is: " + (i & -i));
        }



    }
}
