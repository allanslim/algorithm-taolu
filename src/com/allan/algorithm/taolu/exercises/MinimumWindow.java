package com.allan.algorithm.taolu.exercises;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 *
 *     S = "ADOBECODEBANC"
 *
 *
 *       T = "ABC"
 *  Minimum window is "BANC".
 *
 *
 *  {
 *      A = 1
 *      B = 1
 *      C = 1
 *  }
 *
 */
public class MinimumWindow {
    static final int no_of_chars = 256;

    public static void main(String[] args) {

        String s = "ACBBACA";
        String t = "ABA";

        System.out.println("minimum window is: " + findMinWin(s,t)); // BACA

        s = "ADOBECODEBANC";
        t = "ABC";

        System.out.println("minimum window is: " + findMinWin(s,t)); // BANC

        s = "this is a test string";
        t = "tist";


        System.out.println("minimum window is: " + findMinWin(s,t)); // t stri
    }

    private static String findMinWin(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int end = 0;
        int beginning = 0;
        int length = Integer.MAX_VALUE;
        int count = t.length();
        int h = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }
            end++;

            while (count == 0) {
                if (length > end - beginning) {
                    h = beginning;
                    length = end - beginning;
                }
                char bc = s.charAt(beginning);
                if (map.containsKey(bc)) {
                    map.put(bc, map.get(bc) + 1);
                    if (map.get(bc) > 0) count++;
                }
                beginning++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(h, h + length);
    }

}
