package com.allan.algorithm.taolu.exercises;

/*

Given a String aaabcc write a program that will compress the input string into a3b1c2



 */
public class StringCompressionProblem {

    public static void main(String[] args) {
        String compressedValue = compress("aaabcc");
        System.out.println(compressedValue);

        compressedValue = compress("aaa");
        System.out.println(compressedValue);

        compressedValue = compress("a");
        System.out.println(compressedValue);
    }

    private static String compress(String input) {
        StringBuilder result = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                counter++;
            } else {
                result.append("" + input.charAt(i) + counter);
                counter = 1;
            }
        }
        result.append("" + input.charAt(input.length() - 1) + counter);
        return result.toString();
    }
}
