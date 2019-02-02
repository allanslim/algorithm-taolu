package com.allan.algorithm.taolu.trie;

public class SearchDictionaryArray {


    public static final int LETTERS_IN_ALPHABET = 26;

    public static class TrieNode {

        TrieNode[] child = new TrieNode[LETTERS_IN_ALPHABET];
        boolean isLeaf;

        public TrieNode() {
            isLeaf = false;
            for (int i = 0; i < child.length; i++) {
                child[i] = null;
            }
        }
    }

    public static void insert(TrieNode root, String key) {

        TrieNode nodePointer = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (nodePointer.child[index] == null) {
                nodePointer.child[index] = new TrieNode();
            }
            nodePointer = nodePointer.child[index];
        }
        nodePointer.isLeaf = true;
    }

    public static void searchWord(TrieNode root, boolean[] characters, String output) {

        if (root.isLeaf) {
            System.out.println(output);
        }

        for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
            if (characters[i] == true && root.child[i] != null) {
                char c = (char) (i + 'a');
                searchWord(root.child[i], characters, output + c);
            }
        }
    }

    static void printAllWords(char[] input, TrieNode root ) {

        boolean[] characters = new boolean[LETTERS_IN_ALPHABET];

        for(int i = 0; i < input.length; i++) {
            characters[input[i] - 'a'] = true;
        }

        TrieNode nodePointer = root;

        String output = "";

        for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {

            if( characters[i] == true && root.child[i] != null) {
                output = output + (char)(i + 'a');
                searchWord(nodePointer.child[i], characters, output);
                output = "";
            }
        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"go", "bat", "me", "eat", "goal", "boy", "run"};

        char[] charArrays = {'e', 'o', 'b', 'a', 'm', 'g', 'l'};

        TrieNode root = new TrieNode();

        for( String word : dictionary) {
            insert(root, word);
        }

        printAllWords(charArrays, root);
    }
}
