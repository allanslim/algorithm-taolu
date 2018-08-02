package com.allan.algorithm.taolu.dp;

/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".


Analysis:

----------------
example: babcbab

babcbab
i
j

assuming the length of your string is only 1, then each character would be a palidrome.

|1|0|0|0|0|0|0
|0|1|0|0|0|0|0
|0|0|1|0|0|0|0
|0|0|0|1|0|0|0
|0|0|0|0|1|0|0
|0|0|0|0|0|1|0
|0|0|0|0|0|0|1


if length = 2

babcbab
i
 j

|1|1|0|0|0|0|0
|0|1|0|0|0|0|0
|0|0|1|0|0|0|0
|0|0|0|1|0|0|0
|0|0|0|0|1|0|0
|0|0|0|0|0|1|0
|0|0|0|0|0|0|1

abd so on:

|1|1|3|3|3|5|7
|0|1|1|1|3|5|5
|0|0|1|1|3|3|3
|0|0|0|1|1|1|3
|0|0|0|0|1|1|3
|0|0|0|0|0|1|1
|0|0|0|0|0|0|1

value = 7


----------------
example: aaa

if length = 1, initialize all single character.

|1|0|0
|0|1|0
|0|0|1


if length = 2.

aaa
i
 j

i = 0, j = 1

input[i] == input[j] and cl = 2,

|1|2|0
|0|1|0
|0|0|1

aaa
 i
  j

i = 1, j = 2

input[i] == input[j] and cl = 2,

|1|2|0
|0|1|2
|0|0|1


aaa
i
  j

i = 0, j = 2

input[i] == input[j]

|1|2|3
|0|1|2
|0|0|1


 */
public class PalindromeSubsequence {

    public static void main(String[] args) {

//        System.out.println(countSubstrings("bbbab"));
//
//        System.out.println(countSubstrings("cbbd"));

//        System.out.println(countSubstrings("aaa"));

        System.out.println(countSubstrings("babcbab"));


    }

    public static int countSubstrings(String input) {
        int n = input.length();

        int[][] table = new int[n][n];

        // if the length of the string is only 1, they are all palindome with length 1.
        for(int i  = 0; i < n; i++) {
            table[i][i] = 1;
        }
        // printMatrix(table);

        for(int cl = 2; cl <= n; cl++) {
            for(int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if(input.charAt(i) == input.charAt(j) && cl == 2) {
                    table[i][j] = 2;
                    //printMatrix(table);
                }
                else if(input.charAt(i) == input.charAt(j)) {
                    table[i][j] = table[i + 1][j -1] + 2;
                    //printMatrix(table);
                }
                else {
                    table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
                    //printMatrix(table);
                }
            }
        }
        // printMatrix(table);
        return table[0][n - 1];
    }


    private static void printMatrix(int[][] matrix ) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                System.out.print("|");
                System.out.print(matrix[row][col]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
