package com.allan.algorithm.taolu.stack;

public class Stack {
    private static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node top;

    public boolean isEmpty() { return top == null; }

    public int peek() {
        if(top == null) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int pop() {
        if(top == null) {
            throw new RuntimeException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        return data;
    }
}
