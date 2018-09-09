package com.allan.algorithm.taolu.exercises.lexicographical;

//
//Given a binary tree, you need to compute the length of the diameter of the tree.
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
//This path may or may not pass through the root.
//
//Example:
//Given a binary tree
//      1
//     / \
//    2   3
//   / \
//  4   5
//
// Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//Note: The length of path between two nodes is represented by the number of edges between them.

public class DiameterOfBinaryTree {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node3 = new Node(3);
        Node node2 = new Node(2);

        node2.left = node4;
        node2.right = node5;

        root.left = node2;
        root.right = node3;

        int diameter = findDiameter(root);
        System.out.println("diameter: " + diameter);
    }

    private static int findDiameter(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);

        /* Return max of following three
         1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    private static int findHeight(Node root) {
        if(root == null) {
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left height and right heights */
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

}
