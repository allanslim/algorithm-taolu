package com.allan.algorithm.taolu.dp;

public class MaximumSubarrayProblem {

    public static void main(String[] args) {
//        int[] input = {1, -3, 2, 1, -1};
//        System.out.println(findMaxSubequence(input));
        System.out.println(reverse("this is a string"));
    }

    private static int findMaxSubequence(int[] input) {
        int maxCurrent = input[0];
        int maxGlobal = input[0];
        for (int i = 1; i < input.length; i++) {
            maxCurrent = Math.max(input[i], maxCurrent + input[i]);
            if(maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

    static String reverse(String str) {
        char[] strInChars = str.toCharArray();
        int startIndex = 0;
        int endIndex = strInChars.length - 1;
        while(startIndex < endIndex) {
            char temp = strInChars[startIndex];
            strInChars[startIndex] = strInChars[endIndex];
            strInChars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return new String(strInChars);
    }

}
