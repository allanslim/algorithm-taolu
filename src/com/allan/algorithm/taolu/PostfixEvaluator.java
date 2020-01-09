package com.allan.algorithm.taolu;

import java.util.Stack;

public class PostfixEvaluator {
    private String infixString;
    private Stack<Character> stack;

    public PostfixEvaluator(String infixString) {
        this.infixString = infixString;
        stack = new Stack<>();
    }

    public String convert() {
        StringBuilder outputString = new StringBuilder();
        boolean fI = false;
        for (int i = 0; i < infixString.length(); i++) {
            char currentChar = infixString.charAt(i);
            if (!isOperator(currentChar)) {
                outputString.append(currentChar);
                if (i == (infixString.length() - 1)) {
                    while (!stack.empty()) {
                        outputString.append(stack.pop());
                    }
                }
            } else {
                if(fI) {
                    if (pMin(currentChar) && pMin(stack.peek())) {
                        outputString.append(stack.pop());
                        stack.push(currentChar);
                        if (i == (infixString.length() - 1)) {
                            while (!stack.empty()) {
                                outputString.append(stack.pop());
                            }
                        }
                    } else if (pDiv(currentChar) && pDiv(stack.peek())) {
                        outputString.append(stack.pop());
                        stack.push(currentChar);
                        if (i == (infixString.length() - 1)) {
                            while (!stack.empty()) {
                                outputString.append(stack.pop());
                            }
                        }
                    } else if(pMin(currentChar) && pDiv(stack.peek())) {
                        outputString.append(stack.pop());
                        stack.push(currentChar);
                        if (i == (infixString.length() - 1)) {
                            while (!stack.empty()) {
                                outputString.append(stack.pop());
                            }
                        }
                    }  else if(pDiv(currentChar) && pMin(stack.peek())) {
                        stack.push(currentChar);
                        if (i == (infixString.length() - 1)) {
                            while (!stack.empty()) {
                                outputString.append(stack.pop());
                            }
                        }
                    } else {
                        outputString.append(currentChar);
                        if (i == (infixString.length() - 1)) {
                            while (!stack.empty()) {
                                outputString.append(stack.pop());
                            }
                        }
                    }
                } else {
                    stack.push(currentChar);
                    fI = true;
                }
            }
        }
        return outputString.toString();
    }

    public int evalPostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        int x = 0;
        int y = 0;
        for (char c : postfix.toCharArray()) {
            if (c >= '0' && c <= '9') {
                stack.push((int) (c - '0'));
            } else {
                y = stack.pop();
                x = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(x + y);
                        break;
                    case '-':
                        stack.push(x - y);
                        break;
                    case '*':
                        stack.push(x * y);
                        break;
                    case '/':
                        stack.push(x / y);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public boolean pMin(char input) {
        switch (input) {
            case '+':
            case '-':
                return true;
            default:
                return false;
        }
    }

    public boolean pDiv(char input) {
        switch (input) {
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    public boolean isOperator(char input) {
        switch (input) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator(("3-4/5-6"));
        String converted = postfixEvaluator.convert();
        System.out.println(converted + " =  " + postfixEvaluator.evalPostfix(converted));
    }

}
