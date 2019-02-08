package com.allan.algorithm.taolu.exercises.bit;

public class BinaryIndexedTree {

    public static int MAX_SIZE = 1000;

    public int[] bitree;

    public BinaryIndexedTree() {
        this.bitree = new int[MAX_SIZE];
    }

    public BinaryIndexedTree( int[] input) {
        this.bitree = new int[input.length + 1];
        constructTree(input);
    }

    private void constructTree(int[] input) {
        for(int i = 0; i < input.length; i++) {
            bitree[i] = 0;
        }

        for(int i = 0; i < input.length; i++) {
            updateTree(input.length, i, input[i]);
        }
    }

    private void updateTree(int length, int index, int value) {
        int bitreeIndex = index + 1;

        while (bitreeIndex < length) {
            bitree[bitreeIndex] += value;

            bitreeIndex += bitreeIndex & (-bitreeIndex);
        }
    }

    public int getSum(int index) {

        int bitreeIndex = index + 1;

        int sum = 0;
        while ( bitreeIndex > 0) {
            sum += bitree[bitreeIndex];

            bitreeIndex -= bitreeIndex & (-bitreeIndex);

        }
        return sum;
    }
}
