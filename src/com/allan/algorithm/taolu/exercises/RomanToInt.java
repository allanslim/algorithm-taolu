package com.allan.algorithm.taolu.exercises;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    
/*
    
The idea here is to use a hash map, and put all the roman numerals to integer mapping.

I, 1
V, 5
X, 10
L, 50
etc.

then before you loop, the first element. for example if the input is:

XI

get the first element of XI, which is X, and use the map:


result = map.get("I") = 1

then loop from len - 2 to 0


if map.get(i) >= map.get(i + 1) then
   result += map.get(i);
else
   result -= map.get(i);



   CMXI


 */
    public static void main(String[] args) {
        int number = romanToInt("CMXI");
        System.out.println(number); // 911
    }

    private static int romanToInt(String input) {
        if( input == null || input.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put( 'V', 5);
        map.put('X', 10);
        map.put( 'L', 50);
        map.put( 'C', 100);
        map.put( 'D', 500);
        map.put( 'M', 1000);


        int len = input.length();
        int result = map.get(input.charAt(len - 1));

        for( int i = len - 2; i >= 0; i--) {
            if (map.get(input.charAt(i)) >= map.get(input.charAt(i + 1))) {
                result += map.get(input.charAt(i));
            } else {
                result -= map.get(input.charAt(i));
            }
        }

        return result;
    }
}
