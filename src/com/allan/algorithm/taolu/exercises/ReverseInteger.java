package com.allan.algorithm.taolu.exercises;

import java.math.BigInteger;

public class ReverseInteger {

    /**

     Reverse an Integer:

     given: 123 reverse to 321

     input: -123, -321

     ok, so the idea here is to use modulo to get the first digit, one by one,

     for example
     123 % 10  = 3

     then we use this digit adding it to the reverse number:

      0 x 10 + 3 = 3

     then we reduce input by dividing it to 10, and continue doing this unter num is 0, since we ar dividing it.



     *
     */
    public static void main(String[] args) {

        System.out.println(reverse(32));

        long x = reverse(1534236469);
        System.out.println(x);

        int y = reverse(-123);
        System.out.println(y);
    }

    public static int reverse(int x) {
        if(x >= Integer.MAX_VALUE) { return 0; }
        long reversedNumber = 0;
        while(x != 0) {
            int digit = x % 10; // getting the first digit
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }
        return (int) reversedNumber;
    }

    public static long reverse2(int x) {
        long reversedNumber = 0;
        while(x != 0) {
            int digit = x % 10; // getting the first digit
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }
        return reversedNumber;
    }
}
