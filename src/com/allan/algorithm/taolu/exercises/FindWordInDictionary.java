package com.allan.algorithm.taolu.exercises;

/*

Given a dictionary and a character array, print all valid words that are possible using characters from the array.

Input : Dict - {"go","bat","me","eat","goal",
                                "boy", "run"}
        arr[] = {'e','o','b', 'a','m','g', 'l'}
Output : go, me, goal.

The idea here, is to put the dictionary into a Trie.

search for that word recurisvely in the trie.
let say we start with 'e', is there a word in try that starts with 'e'? Yes, it's eat.

 */
public class FindWordInDictionary {

    public static final int NUMBER_OF_ALPHABETS = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[NUMBER_OF_ALPHABETS];
        boolean isLeaf = false;

        public TrieNode() {}

        public void insert(String input) {
            TrieNode pointer = this;

            for(int i = 0; i < input.length(); i++) {
                int index = input.charAt(i) - 'a';

                if(pointer.children[index] == null) {
                    pointer.children[index] = new TrieNode();
                }
                pointer = pointer.children[index];
            }
            pointer.isLeaf = true;
        }

        public boolean search(String word) {
            TrieNode trieNode = searchNode(word);
            if (trieNode != null && trieNode.isLeaf) {
                return true;
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            if(searchNode(prefix) == null) {
                return false;
            }
            return true;
        }

        private TrieNode searchNode(String word) {
            TrieNode pointer = this;

            for ( int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if ( pointer.children[index] != null) {
                    pointer = pointer.children[index];
                }
                else {
                    return null;
                }
            }
            return pointer;
        }


    }

    public static void main(String[] args) {

        // Let the given dictionary be following
        String dictionary[] = {"go", "bat", "me", "eat", "goal", "boy", "run"} ;

        TrieNode trie = new TrieNode();
        for( int i = 0; i < dictionary.length; i++) {
            trie.insert(dictionary[i]);
        }

        char arr[] =  {'e','o','b', 'a','m','g', 'l'};

        printAllWords(arr, trie);
    }


    public static void printAllWords(char[] arr, TrieNode root) {
        for(int i  = 0; i < arr.length; i++) {
            if (root.startsWith(arr[i] + "")) {
                printHelper(arr, root.children[arr[i] - 'a'], arr[i] + "");
            }
        }
    }

    private static void printHelper(char[] arr, TrieNode root, String str) {
        if(root.isLeaf) {
            System.out.println(str);
        }
        for(int i = 0; i < arr.length; i++) {
            if(root.startsWith(arr[i] + "")) {
                printHelper(arr, root.children[arr[i] - 'a'], str + arr[i]);
            }
        }
    }
}
