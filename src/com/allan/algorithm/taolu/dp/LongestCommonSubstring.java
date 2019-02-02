package com.allan.algorithm.taolu.dp;


/*

Given two strings, find the longest common substring.

e.g.

input1 = "wabcdkolp"
input2 = "koldeabcd"

the common substrings are:

kol
abcd

so the longest common substring is "abcd", which has a length of 4.


Analysis:

This is a dynamic programming questions, and be solved by using a matrix.


let's simplify the input:

 input1 = "abcx"
 input2 = "xabc"


     "" | a | b | c | x
  ""| 0 | 0 | 0 | 0 | 0
  x | 0 | 0 | 0 | 0 | 0
  a | 0 | 1 | 0 | 0 | 0
  b | 0 | 0 | 2 | 0 | 0
  c | 0 | 0 | 0 | 3 | 0

  let's start if your inputs are:

  input1 = ""
  input1 = ""

  there are zero common substring.

the same thing if you have the following inputs:

 input1 = "a"
 input2 = ""

now what if you have the following inputs:

input1 = "a"
input2 = "x"

then you have zero common substring, and the same thing goes for all the characters in input1.


Now what if you have the following inputs:

input1 = "a"
input2 = "xa"

then the common substring is "a", which is 1.


 */
public class LongestCommonSubstring {

    public static void main(String[] args) {

        int commonSubstring = longestCommonSubstring("abcx", "xabc");
        System.out.println("Common substring is: " + commonSubstring);
    }

    private static int longestCommonSubstring(String input1, String input2) {
        char[] input1Array = input1.toCharArray();
        char[] input2Array = input2.toCharArray();
        int row = input1.length();
        int col = input2.length();

        int[][] matrix = new int[row + 1][col + 1];

        int max = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (input1Array[i - 1] == input2Array[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (max < matrix[i][j]) {
                        max = matrix[i][j];
                    }
                }
            }
        }
        return max;

    }

}
