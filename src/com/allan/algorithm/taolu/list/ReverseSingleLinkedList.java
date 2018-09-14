package com.allan.algorithm.taolu.list;

/**
 *
 * https://medium.com/outco/reversing-a-linked-list-easy-as-1-2-3-560fbffe2088
 *
 * Reverse a singly linked list.
 *
 * input:
 *  head -> [ 1 ] -> [ 2 ] -> [ 3] -> null
 *
 *  output:
 *  null <- [ 1 ] <- [ 2 ] <- [ 3 ] <- head
 *
 *
 *  Analysis:
 *  singly linked list only have one pointer. To reverse the list,
 *  we need to keep track of the previous, the current and the following.
 *
 * to start:
 *
 * pervious = null
 * currrent  = head
 * following = head
 *
 * previous is assigned to null, because an empty list can have head = null
 *
 *
 *
 *    head -> [ 1 ] -> [ 2 ]
 *     ^        ^ ^
 *     |        | |
 *    previous current,following
 *
 *
 * 1) following = following.next
 *
 *    head -> [ 1 ] -> [ 2 ] -> [ 3]
 *     ^        ^        ^
 *     |        |        |
 *    previous current following
 *
 * 2) current.next = previous
 *
 *    head -> <- [ 1 ]  [ 2 ] -> [ 3]
 *     ^          ^       ^
 *     |          |       |
 *    previous current  following
 *
 * 3) previous = current
 *
 *    head -> <- [ 1 ]  [ 2 ] -> [ 3]
 *               ^ ^      ^
 *               | |      |
 *    previous current  following
 *
 * 4) current = following
*
 *    head -> <- [ 1 ]  [ 2 ] -> [ 3]
 *               ^        ^ ^
 *               |        | |
 *           previous    current,following
 *
 */
public class ReverseSingleLinkedList {

    public static class LinkedListNode {
        int value;
        LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static class LinkedList {
        LinkedListNode head;

        public LinkedList(int value) {
            this.head = new LinkedListNode(value);
        }

        public void append(int value) {
            if(this.head == null) {
                this.head = new LinkedListNode(value);
                return;
            }
            LinkedListNode current = this.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new LinkedListNode(value);
        }

        public void print() {
            LinkedListNode current = this.head;
            while(current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }

        public void reverse() {
            LinkedListNode previous = null;
            LinkedListNode current = head;
            LinkedListNode following = head;

            while(current != null) {
                following = following.next;
                current.next = previous;
                previous = current;
                current = following;
            }

            this.head = previous;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.print();
        list.reverse();
        list.print();

    }
}
