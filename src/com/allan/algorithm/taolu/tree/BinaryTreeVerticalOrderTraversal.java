package com.allan.algorithm.taolu.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples 1:

 Input: [3,9,20,null,null,15,7]

 3
 /\
 /  \
 9  20
 /\
 /  \
 15   7

 Output:

 [
 [9],
 [3,15],
 [20],
 [7]
 ]

 */
public class BinaryTreeVerticalOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { this.val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> nodesInVerticalOrder = verticalOrder(root);

        nodesInVerticalOrder.stream()
                .forEach( nodes -> {
                    nodes.stream().forEach( node -> System.out.print(node + ",") );
                    System.out.println("");
                    }
                );

    }

    private static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        helper(root, map, 0);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }

    private static void helper(TreeNode root, Map<Integer, List<Integer>> map, Integer distance) {
        if(root != null) {
            if(map.containsKey(distance)) {
                map.get(distance).add(root.val);
            } else {
                List<Integer> nodes = new LinkedList<>();
                nodes.add(root.val);
                map.put(distance, nodes);
            }

            if(root.left != null) {
                helper(root.left, map, distance - 1);
            }
            if(root.right != null) {
                helper(root.right, map, distance + 1);
            }
        }
    }
}
