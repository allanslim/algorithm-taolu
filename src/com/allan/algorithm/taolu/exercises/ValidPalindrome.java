package com.allan.algorithm.taolu.exercises;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {

    /**

The idea here, is to loop thru the characters in the string, and store the letter (or digit) the ascii value of the
     characters.

     e.g.  "aba"

     you create a list of [97,98,97]  where 97 is the ascii value of a.

     then a while loop using start and end variables, where start = 0, and end is the last element.
     if the value at

     list[start] != list[end]

     then return false.


     */
    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        if(input.length() == 0) {
            return true;
        }
        char[] cs = input.trim().toLowerCase().toCharArray();
        List<Integer> list = new ArrayList<>();

        for (char c : cs) {
            if (Character.isLetterOrDigit(c)) {
                list.add(c - 'a'); // this will return the ascii of the character.
            }
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
