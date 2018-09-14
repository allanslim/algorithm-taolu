package com.allan.algorithm.taolu.exercises;

import com.allan.algorithm.taolu.tree.BinaryTreeNode;


public class LowestCommonAncestor {

//                  107
//            99           110
//          88   102      109   120
//        87  90       108


    public static void main(String[] args) {
        BinaryTreeNode root = buildABinaryTree();

        BinaryTreeNode parent = lca(root, 87, 88);
        System.out.println(parent.value);

        BinaryTreeNode root2 = buildSmallerTree();

        BinaryTreeNode parent2 = lca(root2, 10, 120);
        System.out.println(parent2.value);
    }

    private static BinaryTreeNode lca(BinaryTreeNode root, int leftValue, int rightValue) {
        if(root == null) return null;
        if(root.value == leftValue || root.value == rightValue) {
            return root;
        }
        BinaryTreeNode left = lca(root.left, leftValue, rightValue);
        BinaryTreeNode right = lca(root.right, leftValue, rightValue);

        if(left != null && right != null) {
            return root;
        }else if(left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    private static BinaryTreeNode buildSmallerTree() {
        BinaryTreeNode node1 = new BinaryTreeNode(107);
        node1.right = new BinaryTreeNode(120);
        return node1;
    }

    private static BinaryTreeNode buildABinaryTree() {
        BinaryTreeNode node1 = new BinaryTreeNode(107);
        BinaryTreeNode node2 = new BinaryTreeNode(99);
        BinaryTreeNode node3 = new BinaryTreeNode(110);

        node1.left = node2;
        node1.right = node3;

        BinaryTreeNode node4 = new BinaryTreeNode(88);
        BinaryTreeNode node5 = new BinaryTreeNode(102);
        BinaryTreeNode node7 = new BinaryTreeNode(109);
        BinaryTreeNode node8 = new BinaryTreeNode(120);

        node2.left = node4;
        node2.right = node5;

        node3.left = node7;
        node3.right = node8;

        BinaryTreeNode node9 = new BinaryTreeNode(87);
        BinaryTreeNode node10 = new BinaryTreeNode(90);
        BinaryTreeNode node11 = new BinaryTreeNode(108);

        node7.left = node11;

        node4.left = node9;
        node4.right = node10;
        return node1;
    }
}
