package com.allan.algorithm.taolu.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Check for balanced parentheses in an expression
Given an expression string exp , write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.

For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”

 */
public class BalanceParenthesis {


    public static void main(String[] args) {
        boolean isBalance = isBalanceParenthesis("(())");
        System.out.println(isBalance);
        isBalance = isBalanceParenthesis(")(())");
        System.out.println(isBalance);
        isBalance = isBalanceParenthesis("()(())");
        System.out.println(isBalance);

    }

    private static boolean isBalanceParenthesis(String input) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }

            if( c == '}' || c == ')' || c == '}'){

                // If we see an ending parenthesis without a pair then return false
                if(stack.isEmpty()) {
                    return false;
                }

                Character openParens = stack.pop();
                if(map.get(c) != openParens) {
                    return false;
                }

            }
        }

        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
