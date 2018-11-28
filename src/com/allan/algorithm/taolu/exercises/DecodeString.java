package com.allan.algorithm.taolu.exercises;

import java.util.Stack;

public class DecodeString {
/*

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".




*/

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
       // System.out.println(decodeString("3[a2[c]]"));
     //   System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        char[] strArr = s.toCharArray();
        int count = 0;
        String curResult = "";
        for (int i = 0; i < s.length(); i++) {
            //calculate repeat number
            if (Character.isDigit(strArr[i])) {
                count = count * 10 + (strArr[i] - '0');
            }
            //push previous decoded string into stack
            else if (strArr[i] == '[') {
                countStack.push(count);
                resultStack.push(curResult);
                count = 0;
                curResult = "";
            }
            //start to decode current string
            else if (strArr[i] == ']') {
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(resultStack.pop());
                for (int j = 0; j < repeat; j++) {
                    temp.append(curResult);
                }
                curResult = temp.toString();
            }
            //normal character, concat to current string, preparing for decoding
            else {
                curResult += strArr[i];
            }
        }
        return curResult;
    }
}
