package com.allan.algorithm.taolu.exercises;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

    /**


The idea here is to put a Hash map, and put all constant to then Hash map.

     1, I
     5, V
     10, X
     ..

     then loop thru the number, until it is equal to zero and subtract the amount.

     e.g.


     n = 51

     map.getFloorEntry(51) returns {50, L}

     result.append(L)
     num -= 50


     Use a tree map

     */

    public static TreeMap<Integer, String> map = new TreeMap<>();

    static {

        map.put(1,"I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static void main(String[] args) {
        String romanValue = intToRoman(1994);
        System.out.println(romanValue); // MCMXCIV

        System.out.println(intToRoman(2018)); // MMXVIII
    }

    private static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while( num != 0) {
            Map.Entry<Integer, String> entry = map.floorEntry(num);
            result.append(entry.getValue());
            num -= entry.getKey();
        }
        return result.toString();
    }
}
