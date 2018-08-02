package com.allan.algorithm.taolu.dp;

/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 */
public class PalindromeSubstring {

    public static void main(String[] args) {

        int test1 = countSubstrings("abc");
        System.out.println(test1);

        int test2 = countSubstrings("aaa");
        System.out.println(test2);

        int test3 = countSubstrings("agbdba");
        System.out.println(test3);
    }

    public static int countSubstrings(String input) {
        return 0;
    }
}
