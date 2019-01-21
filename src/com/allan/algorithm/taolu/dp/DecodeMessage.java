package com.allan.algorithm.taolu.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeMessage {

/*

    Given the following:

    a -> 1
    b -> 2
    c -> 3
    ...
    z -> 26

So if you have "ab" then it maps to "12". But the input of the problem is the mapped number.

     e.g. "12".

     write a function that returns the number of ways the message can be decoded.

     numberOfWaysToDecodeMessage("12") -> 2

     "12" can be "ab" or "l" , so there are 2 ways.

      but note, that if you are given:

      numberOfWaysToDecodeMessage("01") it should return 0, because 0 is not in the mapping.

      You can assume that the given string only contains numbers. from 0 to 9.


Solution:

We can start by the simplifying our input. Let say if your input is:

"1", then your response is 1, since there is only 1 way to decode a single digit.

if your input is "12", the answer is 2. because "12" can be "ab" or "l". But we need to check that the two digit
number should be less than or equal to 26, to generate that value.

Let say you are given the following input "123", so the ways to decode this are as follows:

1 (a) + decodeMessage("23")
12 (l) + decodeMessage("3")

*/
    public static void main(String[] args) {
        int numways = decodeMessage("12345");
        System.out.println(numways);
        numways = decodeMessage2("12345");
        System.out.println(numways);
    }

    private static int decodeMessage(String input) {
        if(input == null || input.equals("")) {
            return 0;
        }

        if(input.length() == 2 && Integer.parseInt(input) <= 26 ) {
            return 2;
        }

        if(input.length() == 1) {
            return 1;
        }

        return decodeMessage(input.substring(1)) + decodeMessage(input.substring(2));

    }


    private static int decodeMessage2(String input) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(input, input.length(), memo);
    }

    private static int helper(String input, int k, Map<Integer, Integer> memo) {
        if (k == 0) {
            return 1;
        }
        int s = input.length() - k;
        if (input.charAt(s) == '0') {
            return 0;
        }
//        if (memo.containsKey(k)) {
//            return (Integer) memo.get(k);
//        }
        int result = helper(input, k - 1, memo);

        if (k >= 2 && Integer.parseInt(input.substring(s, s + 2)) <= 26) {
            result += helper(input, k - 2, memo);
        }
//        memo.put(k, result);
        return result;
    }
}
