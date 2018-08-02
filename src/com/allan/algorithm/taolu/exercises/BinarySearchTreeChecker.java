package com.allan.algorithm.taolu.exercises;

import java.util.Stack;

public class BinarySearchTreeChecker {

    static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int value) {
            BinaryTreeNode node = new BinaryTreeNode(value);
            this.left = node;
            return this.left;
        }

        public BinaryTreeNode insertRight(int value) {
            BinaryTreeNode node = new BinaryTreeNode(value);
            this.right = node;
            return this.right;
        }
    }

    static class NodeBound {
        public BinaryTreeNode node;
        public int lowerBound;
        public int upperBound;

        public NodeBound(BinaryTreeNode node, int lowerBound, int upperBound) {
            this.node = node;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }


    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(50);
        BinaryTreeNode right = root.insertRight(80);
        BinaryTreeNode left = root.insertLeft(30);
        left.insertLeft(20);
        left.insertRight(60);
        right.insertLeft(70);
        right.insertRight(90);

        System.out.println(isBinarySearchTree(root));
        System.out.println(isBinarySearchTree2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        root = new BinaryTreeNode(50);
        right = root.insertRight(80);
        left = root.insertLeft(30);
        left.insertLeft(20);
        left.insertRight(35);
        right.insertLeft(70);
        right.insertRight(90);


        System.out.println(isBinarySearchTree(root));
        System.out.println(isBinarySearchTree2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    private static boolean isBinarySearchTree(BinaryTreeNode root) {
        if (root == null) {
            return false;
        }

        Stack<NodeBound> stack = new Stack<>();
        stack.push(new NodeBound(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while( !stack.isEmpty()) {
            NodeBound nodebound = stack.pop();

            BinaryTreeNode node = nodebound.node;
            int lowerBound = nodebound.lowerBound;
            int upperBound = nodebound.upperBound;

            if (node.value <= lowerBound || node.value >= upperBound) {
                return false;
            }

            if(node.left != null) {
                stack.push(new NodeBound(node.left, lowerBound, node.value));
            }

            if(node.right != null) {
                stack.push(new NodeBound(node.right, node.value, upperBound));
            }
        }
        return true;
    }


    private static boolean isBinarySearchTree2(BinaryTreeNode root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }

        if (root.value <= lowerBound || root.value >= upperBound) {
            return false;
        }

        return isBinarySearchTree2(root.left, lowerBound, root.value) && isBinarySearchTree2(root.right, root.value, upperBound);

    }
}
