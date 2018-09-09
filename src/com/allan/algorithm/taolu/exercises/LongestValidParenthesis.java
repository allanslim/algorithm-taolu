package com.allan.algorithm.taolu.exercises;

import java.util.Stack;

public class LongestValidParenthesis {

/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    Input: "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()"

    Input: ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()"


solution
1) create an empty stack and push -1 to it
2) create variable result, Initialize result as 0
3) Loop thru the character
4) If the character is `(`, push the index in the stack
5) else if character is `)`:
    a) pop an item from stack
    b) if stack is not empty,  find the length of the current valid substring by taking difference
    between current index and top of the stack. if current length is more than result, then update
    the result
    c) if stack is empty, push current index.

      v
 012345
")()())"

result = 4
 stack = [   5 ]



    loop thru the string:

    "(()"


*/
    public static void main(String[] args) {

        int value = findLongestValidParenthesis("(()");
        System.out.println(" the longest valid param for (() is " + value);

        value = findLongestValidParenthesis(")()())");
        System.out.println(" the longest valid param for )()()) is " + value);

        value = findLongestValidParenthesis("((((()))))");
        System.out.println(" the longest valid param for ((((())))) is " + value);
    }

    private static int findLongestValidParenthesis(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int result = 0;

        for(int i = 0; i < input.length(); i++) {
            if( input.charAt(i) == '(' ) {
                stack.push(i);
            }else if( input.charAt(i) == ')') {
                stack.pop();
                if(!stack.isEmpty()) {
                    result = Math.max(i - stack.peek(), result);
                }else {
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
