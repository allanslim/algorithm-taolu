package com.allan.algorithm.taolu.trie;


import java.util.HashMap;
import java.util.Map;


public class Trie {

    class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode(char value) {
            this.c = value;
        }

        public TrieNode() {}
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;

            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {

        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null) {
            return false;
        }
        return true;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;

        TrieNode t = null;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }
}
