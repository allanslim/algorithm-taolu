package com.allan.algorithm.taolu.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {

   /*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".


The key to solving this problem is to use startsWith in string.

First we loop thru each wordDict, and check if the given string starts with dictionaryWord

   if yes, put it in the cache and return true.

   then continue with the next word.



    */

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("and");
        boolean isWordBreak = wordBreak("appleandapple", wordDict);
        System.out.println(isWordBreak);

        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("aaaa");
        wordDict2.add("aaa");

        boolean isWordBreak2 = wordBreak( "aaaaaaa", wordDict2);
        System.out.println(isWordBreak2);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakDfs(s, wordDict, new HashMap<>());
    }

    private static boolean wordBreakDfs(String s, List<String> wordDict, HashMap<String, Boolean> cache) {
        if(cache.containsKey(s)) {
            return cache.get(s);
        }
        for(String dictWord : wordDict) {
            if(s.startsWith(dictWord)) {
                String next = s.substring(dictWord.length());
                if(next.length() == 0) {
                    cache.put(s, true);
                    return true;
                }
                if (wordBreakDfs(next, wordDict, cache)) {
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}
