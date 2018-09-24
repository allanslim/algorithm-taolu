package com.allan.algorithm.taolu.exercises;

public class MultiplyTwoStrings {

/**

Given two strings of ints, multiply their values.

 input: "2", "50"
 output "100"


 input "123". "456"
 output "56088"

 The idea here is to loop thru the string, character by character and multiply them.
 but first it is easier to reverse them.

 123 reverse this number would give: 321
 456 reverse this number would give: 654

 create an array that will hold all the value you multiplied
 d[6]


 loop thru each array, and multiply then.

 321
 ^
 i

 654
 ^
 i

 since it is in character, to get the integer value, you have to subtract character zero.

 multiplicand = n1.charAt(i) - '0'
 multiplicator = n2.charAt(j) - '0'

d[i + j] += multiplicand * multiplicator

 it will then have an array with value:

 [18,27,28,13,4,0]

 you loop thru this array, and find the

 digit = 18 % 10 = 8
 carry = 18 / 10 = 1

 add teh carry to the next element (if the next element is less than the maximum)

*/
    public static void main(String[] args) {
        String output = multiply("2", "50");
        System.out.println(output);

        output = multiply("123", "456");
        System.out.println(output); // 56088

    }

    private static String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];

        for (int i = 0; i < n1.length(); i++) {
            for(int j = 0; j < n2.length(); j++) {
                int multiplicand = n1.charAt(i) - '0';
                int multiplicator = n2.charAt(j) - '0';
                d[i + j] += multiplicand * multiplicator;
            }
        }

        StringBuilder sb = new StringBuilder();

        // calculate each digit.
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;
            int carry = d[i] / 10;

            if (i+1 < d.length) {
                d[i+1] += carry;
            }
            sb.insert(0, digit);
        }

        // remove front 0's
        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}
