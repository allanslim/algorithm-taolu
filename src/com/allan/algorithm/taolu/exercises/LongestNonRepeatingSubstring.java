package com.allan.algorithm.taolu.exercises;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstring {

    /**
     *
     * seen = acde
     *
     * maxWindow = 2,7
     *
     *      s
     *         e
     * abbacadeabcdeea
     *
     */

    public static void main(String[] args) {
        String longest = longestNonRepeatingSubstring("abbacadeabcdeea");
        System.out.println(longest);
    }

    private static String longestNonRepeatingSubstring(String input) {
        int start = 0;
        int end;
        int[] maxWindow = {0, 0};
        Set<Character> seen = new HashSet<>();

        for(end = 0; end < input.length(); end++) {
            if( (end - start) > (maxWindow[1] - maxWindow[0])) {
                maxWindow = new int[]{start, end};
            }
            char currentChar = input.charAt(end);

            while (seen.contains(currentChar)) {
                seen.remove(input.charAt(start));
                start++;
            }
            seen.add(currentChar);
        }
        return input.substring(maxWindow[0], maxWindow[1]);
    }
}
