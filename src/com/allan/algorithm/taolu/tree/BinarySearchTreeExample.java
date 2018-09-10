package com.allan.algorithm.taolu.tree;

public class BinarySearchTreeExample {

    static class TreeNode {
        TreeNode left, right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }

        public void insert(int value) {
            if (value <= data) {
                if (left == null) {
                    left = new TreeNode(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (value == data) {
                return true;
            } else if (value < data) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }

        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.print(data + " ");
            if (right != null) {
                right.printInOrder();
            }
        }

        public void printPreOrder() {
            System.out.print(data + " ");
            if (left != null) {
                left.printInOrder();
            }
            if (right != null) {
                right.printInOrder();
            }
        }

        public void printPostOrder() {
            if (left != null) {
                left.printInOrder();
            }
            if (right != null) {
                right.printInOrder();
            }
            System.out.print(data + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0);
        tree.insert(60);
        tree.insert(22);
        tree.insert(3);
        tree.insert(34);
        tree.insert(5);
        tree.insert(62);

        boolean contains = tree.contains(4);
        System.out.println(contains);

        System.out.println("Printing Inorder");
        tree.printInOrder();
        System.out.println("\nPrinting Preorder");
        tree.printPreOrder();
        System.out.println("\nPrinting Postorder");
        tree.printPostOrder();
    }
}
