package com.allan.algorithm.taolu.exercises;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.



So the idea here is to to first simplify the input. Let's just say if you have this input.

  R1      R2
  2       2
 / \     / \
3   4   3   4

The tree is symmetric  if

1) if the roots are equal
2) the R1.left = R2.right and R1.right = R2.left


Now if you have this example:

   R1       R2
   null      null

if R1 and R2 are null, then they are symmetric.

    R1    R2
     2    null

and if one of the nodes are null, then you return false.


 */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.right = new TreeNode(4);
        left.left = new TreeNode(3);
        right.right = new TreeNode(3);
        right.left = new TreeNode(4);

        boolean isSymmetric = isSymmetric(root);
        System.out.println(isSymmetric);

        boolean isSemmytric2 = isSymmetricNonRecursive(root);
        System.out.println(isSemmytric2);
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null) { return false; }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            if (isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSymmetricNonRecursive(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            // if both are null, continue
            if (leftNode == null && rightNode == null) {
                continue;
            }

            // if one is null, return false, they are not equal
            if ( (leftNode == null && rightNode != null) ||
                 ( leftNode != null && rightNode == null)) {
                return false;
            }

            // if the values are not the same, return false
            if(leftNode.val != rightNode.val) {
                return false;
            }

            // please note of the order
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }
}
