package com.allan.algorithm.taolu.exercises;

import java.util.LinkedList;
import java.util.Queue;

/**

 using the queue.
 1) enqueue root
 2) dequeue and print, then enqueue left and right child of the node. then repeat.

 3
 /\
 /  \
 9  20
 /\
 /  \
 15   7

 output:
 3 9 20 15 7

 to print level by level:

 3
 9, 20
 15, 7


 1) enqueue root
 2) enqueue null (use as a delimeter)
 3) p = dequeue and print
 4) enqueue left and right child
 5) if p == null:
     a) print newline
     b) enqueue null


**/
public class LevelOrderTraversal {

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

        printLevelOrderTraversal(root);
        System.out.println("\n");
        printLevelByLevel(root);
    }

    private static void printLevelByLevel(TreeNode root) {
        if(root == null) {
            return;
        }
        boolean isDone = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current != null) {
                System.out.print(current.val + " ");
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            } else {
                System.out.println("");
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
    }

    private static void printLevelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + ", ");
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
