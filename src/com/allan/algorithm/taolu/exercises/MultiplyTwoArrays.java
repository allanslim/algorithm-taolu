package com.allan.algorithm.taolu.exercises;

import java.util.Arrays;

public class MultiplyTwoArrays {

/*


Given two arrays, multiply them and return array.

input:
    ar1 = [9,9,9]
    ar2 = [9,9,9]

output:
   [9,9,8,0,0,1]



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

        int[] product = multiplyArrays(new int[] {1,2,3}, new int[] {4,5,6});
        System.out.println(Arrays.toString(product));

        product = multiplyArrays(new int[] {9,9,9}, new int[] {9,9,9});
        System.out.println(Arrays.toString(product));
    }

    private static int[] multiplyArrays(int[] a, int[] b) {
        reverse(a);
        reverse(b);

        int[] product = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                product[i + j] += a[i] * b[j];
            }
        }

        int carry;
        int digit;
        int result[] = new int[a.length + b.length];
        int counter = 0;
        for( int k = 0; k < product.length; k++) {
            digit = product[k] % 10;
            carry = product[k] / 10;
            if( k + 1 < product.length) {
                product[k+1] += carry;
            }
            result[counter] = digit;
            counter++;
        }

        reverse(result);
        if(result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }

    private static void reverse(int[] input) {
        int left = 0;
        int right = input.length - 1;
        while( left < right) {
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }
    }

}
