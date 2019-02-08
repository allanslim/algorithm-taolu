package com.allan.algorithm.taolu.stack;


import java.util.Stack;
/**
 *

 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.


 Analysis:

 The idea here is to use two stack. One for storing the regular values,
 and the second stack is for storing the minimum.


 */

public class MinStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int value) {
        stack1.push(value);
        if(stack2.isEmpty()) {
            stack2.push(value);
        } else {
            stack2.push(Math.min(stack2.peek(), value));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
