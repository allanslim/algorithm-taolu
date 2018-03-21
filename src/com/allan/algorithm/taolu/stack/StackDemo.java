package com.allan.algorithm.taolu.stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("peek: " + stack.peek());
        System.out.println("remove: " + stack.pop());
    }
}
