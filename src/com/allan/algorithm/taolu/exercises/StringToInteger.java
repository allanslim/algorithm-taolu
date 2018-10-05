package com.allan.algorithm.taolu.exercises;

public class StringToInteger {

/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42

Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.


so the idea here is to first convert the string to character array.

"-123" => ['-','1','2','3']

then you need variable to hold the following variables:

head = 0
tail = str.length
sign = 1
output = 0

start by checking the sign.

       ['-','1','2','3']
         ^           ^
      head          tail

if( str[head] == '-')
  sign = -1
  head++

  while ( head < tail )

    output = output * 10 + str[head] - '0';
    head++

return output

 */

    public static void main(String[] args) {
        int number = stringToInteger("  -123");

        System.out.println(number);
    }

    private static int stringToInteger(String s) {

        char[] str = s.toCharArray();

        int head = 0;
        int tail = str.length;
        int sign = 1;

        long output = 0;

        // if empty string - return 0
        if(tail < 1) return 0;

        // skip space.
        while( head < tail && str[head] == ' ') head++;

        // if after skipping space, it becomes empty - return 0
        if(head == tail) return 0;

        // check for sign
        if ( str[head] == '+') {
            head++;
        } else if ( str[head] == '-') {
            sign = -1;
            head++;
        }

        while ( head < tail ) {
            // if the character is not a number.
            if( !(str[head] >= '0' && str[head] <= '9')) {
                return (int) output * sign;
            }

            output = output * 10 + str[head] - '0';

            // if its output of bounce return the max
            if ( output > Integer.MAX_VALUE ) {
                return ( sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            head++;
        }
        return (int) output * sign;
    }
}
