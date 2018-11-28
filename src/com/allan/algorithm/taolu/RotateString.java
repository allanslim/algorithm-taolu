package com.allan.algorithm.taolu;

import java.util.HashMap;
import java.util.Map;

public class RotateString {

    public static void main(String[] args) {
        String output = rotateOpt("-l", "3", "Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next  semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!");
        System.out.println(output);

        System.out.println("----------");
        String output2 = rotateOpt("-l", "3", "Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next  semester.\r\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!");
        System.out.println(output2);
    }

    private static String rotateOpt(String direction, String index, String input) {

        Map<Integer, String> delimiterMap = extractDelimiter(input);

        String[] inputs = input.split("\\r?\\n");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < inputs.length; i++) {
            String rotatedInput = rotateBy(inputs[i], index, direction);
            builder.append(rotatedInput).append(delimiterMap.get(i));
        }

        String finalString = builder.toString();
        return finalString.substring(0, finalString.length() - 1);
    }

    private static Map<Integer, String> extractDelimiter(String input) {
        Map<Integer, String> delimiterMap = new HashMap<>();
        int counter = 0;
        for (char c : input.toCharArray()) {
            if (c == '\n' || c == '\r') {
                delimiterMap.put(counter, String.valueOf(c));
                counter++;
            }
        }
        return delimiterMap;
    }

    private static String rotateBy(String token, String index, String direction) {
        int n = Integer.parseInt(index);
        if ("-l".equals(direction)) {
            String left = token.substring(0, n);
            String right = token.substring(n);
            return right + left;
        } else {
            String right = token.substring(0, n);
            String left = token.substring(n);
            return left + right;
        }
    }
}
