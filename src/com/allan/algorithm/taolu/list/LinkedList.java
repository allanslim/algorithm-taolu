package com.allan.algorithm.taolu.list;

public class LinkedList {
    private Node head;

    public LinkedList() { }

    public LinkedList(int value) {
        this.head = new Node(value);
    }

    public void append(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    public void preprend(int value) {
        if(head == null) {
            head = new Node(value);
            return;
        }
        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int value) {
        if(head == null) {
            return;
        }
        if(head.getValue() == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null) {
            if(current.next.getValue() == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        System.out.print("head ->");
        while(current != null) {
            System.out.print("[" + current.getValue() + "] ->");
            current = current.next;
        }
        System.out.print("null");
    }
}
