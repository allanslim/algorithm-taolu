package com.allan.algorithm.taolu.exercises;

/*

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.


The idea here is to label the each character of the string. If they differ, then return false.

egg = add
122   122

foo = bar
122   123

 paper = title
 12134 = 12134


 */
public class IsomorphicString {
    public static void main(String[] args) {

        System.out.println(" egg and add: " + isIsomorphic("egg", "add"));
        System.out.println(" paper and title: " + isIsomorphic("paper", "title"));
        System.out.println(" foo and bar: " + isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] markerForS = new int[256];
        int[] markerForT = new int[256];
        int label = 1;
        for (int i = 0; i < s.length(); i++) {
            int charS = s.charAt(i);
            int charT = t.charAt(i);
            if (markerForS[charS] != markerForT[charT]) {
                return false;
            }

            if (markerForS[charS] == 0) {
                markerForS[charS] = label;
                markerForT[charT] = label;
                label++;
            }
        }
        return true;
    }
}
