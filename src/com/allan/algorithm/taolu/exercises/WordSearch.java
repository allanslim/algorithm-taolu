package com.allan.algorithm.taolu.exercises;

public class WordSearch {
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

This is like a Boggle game. The idea here is to use DFS, first you need to find if the first character of the string
exist in the board. If it exist, do a dfs


 */

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        boolean doesWordExist = exist(board, word);
        System.out.println(" does word exist: " + doesWordExist);
    }

    private static boolean exist(char[][] board, String word) {
        char[] wordInArray = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for( int j = 0; j < board[i].length; j++) {
                if (exist(board, wordInArray, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, char[] wordInArray, int i, int j, int position, boolean[][] visited) {

        if( position == wordInArray.length) {
            return true;
        }

        // check the boundary and if we've visited
        if(     i < 0 || j < 0
             || i == board.length || j == board[i].length
             || visited[i][j]
          ) {
            return false;
        }

        if(board[i][j] != wordInArray[position]) {
            return false;
        }

        visited[i][j] = true;

        boolean exist =    exist(board, wordInArray, i + 1, j    , position + 1, visited)
                        || exist(board, wordInArray, i - 1, j    , position + 1, visited)
                        || exist(board, wordInArray, i    , j + 1, position + 1, visited)
                        || exist(board, wordInArray, i    , j - 1, position + 1, visited);

        visited[i][j] = false;
        return exist;
    }

}
