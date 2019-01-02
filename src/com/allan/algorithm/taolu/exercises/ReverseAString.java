package com.allan.algorithm.taolu.exercises;

public class ReverseAString {

    public static void main(String[] args) {
        System.out.println(reverse("this is a string"));
    }

    static String reverse(String str) {
        char[] strInChars = str.toCharArray();
        int startIndex = 0;
        int endIndex = strInChars.length - 1;
        while (startIndex < endIndex) {
            char temp = strInChars[startIndex];
            strInChars[startIndex] = strInChars[endIndex];
            strInChars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return new String(strInChars);
    }

}
