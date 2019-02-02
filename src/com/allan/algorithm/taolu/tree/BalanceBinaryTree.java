package com.allan.algorithm.taolu.tree;

/**
 *

 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example 1:

 Given the following tree [3,9,20,null,null,15,7]:

 3
 / \
 9  20
 /  \
 15   7
 Return true.

 Example 2:

 Given the following tree [1,2,2,3,3,null,null,4,4]:

 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 Return false.



So what does it mean to have height-balanced tree? A height-balanced tree is when the:

 aboslute( left subtree height - right subtree height ) <= 1


 consider this example:


     4
    / \
   1   3

 The height of the left subtree (1) and the height of the right subtree (1).

 | 1 - 1| = 0 <= 1

 therefore this tree is height-balance.


 if you have a single node.

     5
    /\
   x  x

 The height of the left subtree is 0, and the height of the right subtree is 0.

  | 0 - 0 | = 0 <= 1

 therefor this tree is height-balance.


 if the input is null?

 it is considered a height-balance tree. because it does not have a subtree. it does not even have a chance to be
 unbalance.


 in this example:

     6
    / \
   2   9
      / \
     8   11

 the left subtree is 1, and the right subtree is 2.

 | 2 - 1 \ = 1 <= 1

 so this is balance.


 how about this example?

      6
     / \
    2   9
   / \
  8  11
      \
      12

 The left subtree is 3, and the right is 1.

   | 3 - 1 | = 2 <= 1

 therefore, this tree is not balance.



 */

public class BalanceBinaryTree {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class Tuple {
        boolean isBalance;
        int height;

        public Tuple(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        TreeNode rightSubtree = new TreeNode(9);
        root.right = rightSubtree;
        rightSubtree.left = new TreeNode(8);
        rightSubtree.right = new TreeNode(11);

        System.out.println("tree is balance? : " + isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        Tuple response = helper(root);
        return response.isBalance;

    }

    private static Tuple helper(TreeNode root) {

        if (root == null) {
            return new Tuple(-1, true);
        }

        Tuple leftSubtree = helper(root.left);

        if (!leftSubtree.isBalance) {
            return leftSubtree;
        }

        Tuple rightSubtree = helper(root.right);

        if (!rightSubtree.isBalance) {
            return rightSubtree;
        }

        int height = Math.max(leftSubtree.height, rightSubtree.height) + 1;
        boolean isSubtreeBalance = Math.abs(leftSubtree.height - rightSubtree.height) <= 1;

        return new Tuple(height, isSubtreeBalance);

    }
}
