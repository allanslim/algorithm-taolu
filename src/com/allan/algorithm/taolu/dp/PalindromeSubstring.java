package com.allan.algorithm.taolu.dp;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

okay, the idea here is to first identify what is a palidrome.

A palindrome is a word or phrase, that reads the same backward as forward.

for example:

racecar

Now you can derive a rule based from this. the first and the last character is the same.

racecar
^     ^

and not only that. The inner word should follow the same rule.

r   aceca  r
    ^   ^

now, if you only have a single character, for example, "a", it is by itself a palindrome.

So you can derive this criteria:

1) the first and the last character should be equal
2) the inner word should follow rule 1
3) if there's zero or one character, it is a palidrome


We need a variable to keep track of the data. The simpliest way, since we need to keep track of 2 variables at a time,
is to use a 2-dimensional boolean array.


loop 1:

        0 1 2
        b o b
          j
        i

isPalidrome(0,1) = false
first = 0
last = 0

loop 2:

        0 1 2
        b o b
            j
        i

isPalidrome(0,2) = true
 first = 0
 last = 2


        0 1 2
        b o b
            j
          i

isPalidrome(1,2) = false


return substring 0, 2
 */
public class PalindromeSubstring {

    public static void main(String[] args) {

        String test1 = findPalindromicSubstring("ac");
        System.out.println(test1);

        test1 = findPalindromicSubstring("bb");
        System.out.println(test1);

        test1 = findPalindromicSubstring("racecar");
        System.out.println(test1);

        test1 = findPalindromicSubstring("boracecarkras");
        System.out.println(test1);

    }

    public static String findPalindromicSubstring(String input) {

        boolean[][] matrix = new boolean[input.length()][input.length()];
        int length = input.length();
        int first = 0;
        int last = 0;

        //substring of length 1
        for(int i = 0; i < length; i++) {
            matrix[i][i] = true;
        }

        for(int lengthOfStr = 2; lengthOfStr <= length; lengthOfStr++) {
            for(int i = 0; i < length - lengthOfStr + 1; i++) {
                int j = i + lengthOfStr - 1;

                if(input.charAt(i) == input.charAt(j) && matrix[i+1][j-1] == true) {
                    matrix[i][j] = true;
                    if(j - i > last - first) {
                        first = i;
                        last = j;
                    }
                }
            }
        }
        return input.substring(first, last + 1);
    }

    public static String findPalindromicSubstring2(String input) {
        int length = input.length();

        // edge case
        if (input == null ||input.equals("")) {
            return input;
        }

        boolean[][] isPalindrome = new boolean[length][length];

        int first = 0;
        int last = 0;

        for (int j = 1; j < length; j++) { // start with 1 because j - 1
            for (int i = 0; i < j; i++) { // loop only up to j
                // 2nd and 3rd criteria.
                boolean isInnerWordPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;

                // 1st criteria
                char leftCharacter = input.charAt(i);
                char rightCharacter = input.charAt(j);
                if (leftCharacter == rightCharacter && isInnerWordPalindrome) {
                    isPalindrome[i][j] = true;

                    if (j - i > last - first) {
                        first = i;
                        last = j;
                    }
                }
            }
        }
        return input.substring(first, last + 1);
    }
    // time complexity O(n ^ 2)
    // space O( n ^ 2)
}
