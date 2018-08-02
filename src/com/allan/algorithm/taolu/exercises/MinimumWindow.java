package com.allan.algorithm.taolu.exercises;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * <p>
 * S = "ADOBECODEBANC"
 * <p>
 * <p>
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * <p>
 * {
 * A = 1
 * B = 1
 * C = 1
 * }
 */
public class MinimumWindow {


    public static void main(String[] args) {

        String s = "ACBBACA";
        String t = "ABA";

        System.out.println("minimum window is: " + minWindowWithRepeats(s, t)); // BACA

        s = "ADOBECODEBANC";
        t = "ABC";

        System.out.println("minimum window is: " + minWindowWithRepeats(s, t)); // BANC

        s = "this is a test string";
        t = "tist";


        System.out.println("minimum window is: " + minWindowWithRepeats(s, t)); // t stri

        s = "bbbabbbbbbbbbbcabbabbbbbcbbbbb";
        t = "aabc";
        System.out.println("minimum window is: " + minWindowWithRepeats(s, t)); // t stri
    }

    private static String minWindowWithRepeats(String s, String t) {
        Map<Character, Integer> lettersSeen = new HashMap<>();
        Map<Character, Integer> lettersNeeded = new HashMap<>();
        int lettersMissing = 0;

        for (char i : t.toCharArray()) {
            if (lettersNeeded.containsKey(i)) {
                lettersNeeded.put(i, lettersNeeded.get(i) + 1);
            } else {
                lettersNeeded.put(i, 1);
                lettersSeen.put(i, 0);
                lettersMissing += 1;
            }
        }

        int slow = 0;
        int[] window = {0, Integer.MAX_VALUE};

        for (int fast = 0; fast < s.length(); fast++) {
            Character letter = s.charAt(fast);

            if (lettersNeeded.containsKey(letter)) {
                lettersSeen.put(letter, lettersSeen.get(letter) + 1);
            }

            if (lettersSeen.get(letter) != null &&
                    lettersNeeded.get(letter) != null &&
                    lettersSeen.get(letter).equals(lettersNeeded.get(letter))) {
                lettersMissing -= 1;
            }

            while (lettersMissing == 0) {
                if (fast - slow < window[1] - window[0]) {
                    window[0] = slow;
                    window[1] = fast;
                }
                if (lettersNeeded.containsKey(s.charAt(slow))) {
                    lettersSeen.put(s.charAt(slow), lettersSeen.get(s.charAt(slow)) - 1);
                }
                if (lettersSeen.get(s.charAt(slow)) != null &&
                        lettersNeeded.get(s.charAt(slow)) != null &&
                        lettersSeen.get(s.charAt(slow)) < lettersNeeded.get(s.charAt(slow))) {
                    lettersMissing += 1;
                }
                slow += 1;
            }
        }
        return s.substring(window[0], window[1] + 1);
    }

    private static String findMinimumWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                //one of the characters in t does not exist in s! return empty string.
                return "";
            }
        }

        int begin = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int minBegin = 0;
        int numberOfTargets = t.length();

        while (end < s.length()) {
            char current = s.charAt(end);

            if (map.get(current) > 0) {
                numberOfTargets--;
            }

            map.put(current, map.get(current) - 1);

            while (numberOfTargets == 0) {
                if (minLength > end - begin + 1) {
                    minLength = end - begin + 1;
                    minBegin = begin;
                }
                char head = s.charAt(begin);
                if (map.get(head) >= 0) {
                    numberOfTargets++;
                }
                map.put(head, map.get(head) + 1);
                begin++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minBegin, minBegin + minLength);
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
