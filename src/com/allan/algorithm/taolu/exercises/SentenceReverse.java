package com.allan.algorithm.taolu.exercises;

import java.util.Arrays;

public class SentenceReverse {


    static char[] reverseWords(char[] arr) {

        reverse(arr, 0, arr.length - 1);

        Integer wordStart = null;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                if(wordStart != null) {
                    reverse(arr, wordStart, i - 1);
                    wordStart = null;
                }
            }
            else if( i == arr.length - 1) {
                if(wordStart != null) {
                    reverse(arr, wordStart, i);
                }
            }else {
                if(wordStart == null) {
                    wordStart = i;
                }
            }
        }
        return arr;
    }

    static void reverse(char[] arr, int startIndex, int endIndex) {
        while( startIndex < endIndex) {
            char temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }



    public static void main(String[] args) {
        char[] arr = new char[]{ 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };

        System.out.println( Arrays.toString(reverseWords(arr)));
    }
}
