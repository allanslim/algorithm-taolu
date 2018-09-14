package com.allan.algorithm.taolu.list;


public class DeleteNodeInALinkedList {

    /**

     given a linked list, delete a node.

     e.g.
     head = [4,5,1,9] node = 5
     output [4,5,1,9]


     what is given is the node that you are going to delete.

                  *
     head -> 4 -> 5 -> 1 -> 9 -> null

     since you don't have pointer to the previous, what you can do is to copy the value of the next.

     node.value = node.next.value;

     head -> 4 -> 1 -> 1 -> 9 -> null

     then, you copy the next's next to the current's next.

     head -> 4 -> 1 -> 9 -> null
                  1 ->

     And since no one is pointing to that node, it will be garbage collected.

     */

    public static class LinkedNode {
        public int value;
        public LinkedNode next;
        public LinkedNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        LinkedNode first = new LinkedNode(4);
        LinkedNode head = first;
        LinkedNode second = new LinkedNode(5);
        first.next = second;
        LinkedNode third = new LinkedNode(1);
        second.next = third;
        LinkedNode fourth = new LinkedNode(9);
        third.next = fourth;
        fourth.next = null;

        printList(head);
        deleteNode(second);
        printList(head);

    }

    private static void deleteNode(LinkedNode node) {
        if(node == null) {
            return;
        }
        node.value = node.next.value;
        node.next = node.next.next;
    }

    private static void printList(LinkedNode head) {
        if (head != null) {
           LinkedNode ptr = head;
            while( ptr != null) {
                System.out.print(ptr.value + " ");
                ptr = ptr.next;
            }
        }
        System.out.println("");
    }
}
