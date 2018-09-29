package com.allan.algorithm.taolu.list;

public class DoublyLinkedListExample {

    static class Node {
        int data;
        Node next, previous;

        public Node(int data) {
            this.data = data;
        }
    }

    static class DoublyLinkedList {
        Node head, tail;


        public void add(int newData) {
            Node newNode = new Node(newData);
            newNode.next = head;
            newNode.previous = null;

            if (head != null) {
                head.previous = newNode;
            }

            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        }

        public void append(int newData) {
            Node newNode = new Node(newData);

            if (tail != null) {
                newNode.next = null;
                newNode.previous = tail;
                tail.next = newNode;
                tail = newNode;
            } else {
                tail = newNode;

            }

            if (head == null) {
                head = newNode;
            }
        }

        public void removeFromTail() {
            if (tail != null) {
                tail = tail.previous;
                if(tail != null) {
                    tail.next = null;
                }
            }
        }

        public void print() {
            Node current = head;
            while (current != null) {
                System.out.print("[" + current.data + "]->");
                current = current.next;
            }
            System.out.println("");
            System.out.println("head -> " + head.data + " and tail ->" + tail.data);
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(3);
        doublyLinkedList.print();
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        doublyLinkedList.add(6);
        doublyLinkedList.print();
        doublyLinkedList.append(7);
        doublyLinkedList.print();
        doublyLinkedList.append(8);
        doublyLinkedList.append(9);
        doublyLinkedList.print();
        doublyLinkedList.add(1);
        doublyLinkedList.print();
        doublyLinkedList.removeFromTail();
        doublyLinkedList.print();
        doublyLinkedList.removeFromTail();
        doublyLinkedList.print();
        doublyLinkedList.removeFromTail();
        doublyLinkedList.print();
    }
}
