package com.allan.algorithm.taolu.exercises;


import java.util.LinkedList;

public class PalindromeNumber {

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


So the idea here is to be able to walk thru the number front and back and compare. if they are not equal
then return false. but first, we need to check for the edge cases.

1. if the number is a negative number return false.
2. if the number is a single digit, return true
3. extract the number digit by digit, and put them in a queue.
4. check if its palindrome by extracting the number from the front and last
 */
public static void main(String[] args) {
    boolean isPalidrome = isPalidrome(1221);
    System.out.println("is 1221 palidrome: " + isPalidrome);
}

    private static boolean isPalidrome(int x) {

        // if the number is a negative number return false.
        if(x < 0) {
            return false;
        }

        //  if the number is a single digit, return true
        if(x > 0 && x < 10) {
            return true;
        }

        // extract the number digit by digit, and put them in a queue.
        LinkedList<Integer> digits = new LinkedList<>();
        while( x > 0) {
            digits.add(x % 10);
            x = x / 10;
        }

        // check if its palindrome by extracting the number from the front and last
        while(digits.size() > 1) {
            if (!isPalindrome(digits.removeFirst(), digits.removeLast())) {
                return false;
            }
        }
        return true;

    }

    private static boolean isPalindrome(Integer x, Integer y) {
        return x.equals(y);
    }


}
