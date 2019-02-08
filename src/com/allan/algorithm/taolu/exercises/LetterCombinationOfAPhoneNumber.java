package com.allan.algorithm.taolu.exercises;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {

/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


   0   1    2      3      4      5      6      7       8      9
[ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" ]


The idea here is to be able to be able to find the permutation. In the example above:

 2 = abc
 3 = def

 so the combination would be:

 ad
 ae
 af
 bd
 be
 bf

 for every character in the first number, you match it with every character in the second element.

 Using recursion, you can find every letter combination.

 */
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };


    public static void main(String[] args) {
//        List<String> lettersCombination = lettersCombination("23");
//        lettersCombination.forEach( l -> System.out.print(l + ", "));
//        System.out.println("--");

        List<String> lettersCombination2 = lettersCombination("523");
        lettersCombination2.forEach( l -> System.out.print(l + ", "));
        System.out.println("");
    }

    private static List<String> lettersCombination(String input) {
        if(input == null || input.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        combination("", input, 0, result);
        return result;
    }

    private static void combination(String prefix, String digits, int offset, List<String> result) {
        if(offset >= digits.length()) {
            result.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for ( int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, result);
        }
    }
}
