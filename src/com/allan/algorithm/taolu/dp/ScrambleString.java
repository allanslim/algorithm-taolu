package com.allan.algorithm.taolu.dp;

/*

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Example 2:

Input: s1 = "abcde", s2 = "caebd"
Output: false

 */
public class ScrambleString {

    public static void main(String[] args) {

        boolean isScramble = isScramble("great", "rgeat");
        System.out.println(isScramble);

    }

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;

        // validate
        int[] letters = new int[26];
        int length = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) return false;
        }

        System.out.println(String.format("for input: %s, %s", s1, s2));
        for (int i = 1; i < length; i++) {
            System.out.println(String.format("\tfirst: %s, %s && %s, %s", s1.substring(0, i),s2.substring(0, i), s1.substring(i), s2.substring(i)) );
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            System.out.println(String.format("\tsecond: %s, %s && %s, %s", s1.substring(0, i), s2.substring(length - i), s1.substring(i), s2.substring(0, length - i)) );

            if (isScramble(s1.substring(0, i), s2.substring(length - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, length - i))) {
                return true;
            }
        }
        return false;
    }
}
