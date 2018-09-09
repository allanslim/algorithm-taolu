package com.allan.algorithm.taolu.exercises;

import java.util.HashMap;
import java.util.Map;

public class FindSentence {

    static String findSentence(Map<String,String> dictionary, String input) {
        if(input == null || input.length() == 0 ) {
            return "";
        }
        int begin = 0;
        for( int end = 1; end <= input.length(); end++) {
            if( dictionary.containsKey(input.substring(begin, end))) {
                return dictionary.get(input.substring(begin, end)) + " " + findSentence(dictionary, input.substring(end, input.length()));
            }
        }
        return "";
    }

    public static void main (String[] args) {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("home", "home");
        dictionary.put("depot", "depot");
        String input = "homedepot";
        System.out.println(findSentence(dictionary, input));
    }
}
