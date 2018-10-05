package com.allan.algorithm.taolu.tree;

/*

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.


The idea here is to do a recursive call finding the height of the left subtree and the right subtree and adding them.

height(root.left) + height(root.right)

then you find the maximum between the diameters.

max(diameter, diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)


We need to define some helper function. Like Height()

for finding the height, we need to check for the following base cases.

1) if root is null - return 0
2) if root.left is null and root.right is null - return 1
3) return the max of height(root.left), height(root.right) + 1


for finding the diameter, you need the following base cases.

1) if root is null - return 0
2) if root.right is null - return height(root.left)
3) if root.left is null - return height(root.right)
4) diameter = height(root.left) + height(root.right)

5) get the max of diamter, diameterOfBinaryTree(root.left) and diameterOfBinaryTree(root.right)

 */

public class DiameterOfBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        int diameter = diameterOfBinaryTree(root);
        System.out.println(diameter);
    }

    public static int height(TreeNode root) {
        if( root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }


    public static int diameterOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        if (root.right == null) return height(root.left);
        if (root.left == null) return height(root.right);

        int diameter = height(root.left) + height(root.right);

        int maximumOfLeftOrRight = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(diameter, maximumOfLeftOrRight);

    }



}
