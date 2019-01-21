package com.allan.algorithm.taolu.exercises;

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
// essentially it is the height of the left subtree + the height of the right subtree and the root node.
//
// diameter = height(left subtree) + height(right subtree) + 1
//
// Take note that there are cases where it does not passes to the root node.
//
//         1
//        / \
//       2   3
//      / \
//     4   5
//    /     \
//   6       7
//            \
//             9
//              \
//              10
//
// in this case, the diameter is [6,4,2,5,7,9,10], diameter = 7
//
//
//  if the root node is 2, then the fomula above will work. But in this case, it will not.
// so we have to find the diameter of the left subtree and the right subtree.
//
// diameter = Max( diameterOfRightSubtree, diameterOfLeftSubtree).
//
// diameter = Max( diameter(root.left), diameter(root.right) )
//
//
// In this case, we have two consideration.
// 1) diameter of a tree that passes thru the root node
// 2) diameter of a tree that does not pass thru the root node
//
// We need to find which one is the maximum.
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
