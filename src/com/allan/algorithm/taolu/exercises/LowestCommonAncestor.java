package com.allan.algorithm.taolu.exercises;

import com.allan.algorithm.taolu.tree.BinaryTreeNode;


public class LowestCommonAncestor {

    /**
     so the idea here, is to use recursion, but first we need to simpily the input, and define our base case.

     for example if you have:

     2
     / \
     3   4

     1) first we check if root is null or not, if it is null, return null.

     2) now, if the value we are matches one of the value, then we return that node.

     3) otherwise, we recurse the left and the right part of the tree.

     TreeNode left = lca(root.left, p, q)
     TreeNode right = lca(root.right, p, q)

     so our left = 3, and right = 4

     if left and right are not null, return the root, which in this example, it is 2.
     if left and right are both null, return null.

     now, if left == null, you return right, because the node you are looking for is in the right side otherwise return left.


     2
     / \
     6    4
     /
     1

     and you are looking for 1 and 4. and the recursive level of:

     6
     /
     1

     and you are looking for 1, the leftNode will not be null, because it has a value, but the right will be null
     now we check, if left is null, we return right, but since it is not null, we return left, going back one step higher:

     left = 1
     and right = 4

     and since both are not null, we return the root, which is 2.

     **/
    public static void main(String[] args) {
        BinaryTreeNode root = buildABinaryTree();

        BinaryTreeNode parent = lca(root, 87, 88);
        System.out.println(parent.value);

        BinaryTreeNode root2 = buildSmallerTree();

        BinaryTreeNode parent2 = lca(root2, 10, 120);
        System.out.println(parent2.value);


        BinaryTreeNode x = new BinaryTreeNode(2);
        x.right = new BinaryTreeNode(4);

        BinaryTreeNode y = new BinaryTreeNode(6);
        x.left = y;
        y.insertLeft(1);

        BinaryTreeNode parent3 = lca(x, 1, 4);
        System.out.println(parent3.value);

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
