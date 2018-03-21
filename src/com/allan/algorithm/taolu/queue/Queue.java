package com.allan.algorithm.taolu.queue;



public class Queue {

    private static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head; // remove from head
    private Node tail;  // add in tail

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void add(int value) {
        Node newEntry = new Node(value);
        if(tail != null) {
            tail.next = newEntry;
        }
        tail = newEntry;
        if(head == null) {
            head = newEntry;
        }
    }

    public int remove() {
        int data = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return data;
    }
}
