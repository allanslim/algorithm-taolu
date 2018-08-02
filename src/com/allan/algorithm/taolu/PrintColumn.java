package com.allan.algorithm.taolu;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**

 Given the root of a binary tree containing integers, print the columns of the tree in order with the nodes in each column printed top-to-bottom.
Input:
         6
        /  \
       3    4
     / \     \
    5   1    0
  /  \      /
 9   2    8
      \
       7

          0
       -1     1
    -2    0      2
-3     -1     1      3


        Output:
        9 5 3 2 6 1 7 4 8 0

 printColumn(root, key, map,

    if(root == null ) {
      return;
    }

    if(root != null )
       map.put(key, root.value)


    printColumn(root.left, key - 1, map)
    printColumn(root, key, map)
    printColumn(root.right, key + 1, map)

 **/

public class PrintColumn {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    private static void printColumn(Node root, Integer key, Map<Integer, List<Integer>> map) {
        if(root == null) {
            return;
        } else {
            if(map.containsKey(key)) {
                List<Integer> integers = map.get(key);
                integers.add(root.value);
                map.put(key, integers);
            } else {
                List<Integer> integers = new LinkedList<>();
                integers.add(root.value);
                map.put(key, integers);
            }

            printColumn(root.left, key - 1, map);
            printColumn(root.right, key + 1, map);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(6);

        Node seven = new Node(7);
        Node two = new Node(2);
        two.right = seven;

        Node nine = new Node(9);

        Node five = new Node(5);
        five.left = nine;
        five.right = two;

        Node one = new Node(1);

        Node three = new Node(3);
        three.left = five;
        three.right = one;

        root.left = three;

        Node eight = new Node(8);
        Node zero = new Node(0);
        zero.left = eight;

        Node four = new Node(4);
        four.right = zero;

        root.right = four;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        printColumn(root, 0, map);
        map.values()
                .forEach(
                        v -> v.forEach( e -> System.out.print(" " + e))
                );
    }


}
