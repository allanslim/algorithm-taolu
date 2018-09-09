package com.allan.algorithm.taolu.exercises;

import com.allan.algorithm.taolu.trie.Trie;

/*

Given a dictionary and a character array, print all valid words that are possible using characters from the array.

Input : Dict - {"go","bat","me","eat","goal",
                                "boy", "run"}
        arr[] = {'e','o','b', 'a','m','g', 'l'}
Output : go, me, goal.

 */
public class FindWordInDictionary {

    public static final int NUMBER_OF_ALPHABETS = 26;

    public static void main(String[] args) {

        // Let the given dictionary be following
        String dictionary[] = {"go", "bat", "me", "eat", "goal", "boy", "run"} ;

        Trie trie = new Trie();
        for( int i = 0; i < dictionary.length; i++) {
            trie.insert(dictionary[i]);
        }

        char arr[] =  {'e','o','b', 'a','m','g', 'l'};

        printAllWords(arr, trie, arr.length);
    }

    private static void printAllWords(char[] arr, Trie root, int n) {

        boolean[] hash = new boolean[NUMBER_OF_ALPHABETS];

        for(int i = 0; i < n; i++) {
            hash[arr[i] - 'a'] = true;
        }

        Trie children = root;

        String word = "";

//        for(int i = 0; i < NUMBER_OF_ALPHABETS; i++) {
//            if(hash[i] == true && children.startsWith())
//        }
    }
}
