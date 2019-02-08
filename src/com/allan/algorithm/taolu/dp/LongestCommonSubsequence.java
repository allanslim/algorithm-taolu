package com.allan.algorithm.taolu.dp;

public class LongestCommonSubsequence {


    public static void main(String[] args) {
        int n = longestCommonSubsequence("fish", "fosh");
        System.out.println("the longest common subsequence of fish and fosh is: " + n);

        longestCommonSubsequence("abcdaf", "acbcf");
        System.out.println("the longest common subsequence of abcdaf and acbcf is: " + n);

    }

    private static int longestCommonSubsequence(String input1, String input2) {

        int row = input1.length();
        int column = input2.length();
        char[] input1Array = input1.toCharArray();
        char[] input2Array = input2.toCharArray();

        int[][] matrix = new int[row + 1][column + 1];

        int total = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if( input1Array[i - 1] == input2Array[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if(matrix[i][j] > total) {
                        total = matrix[i][j];
                    }
                }
                else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return total;
    }

}
