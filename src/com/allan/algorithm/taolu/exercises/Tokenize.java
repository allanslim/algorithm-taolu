package com.allan.algorithm.taolu.exercises;

public class Tokenize {

    public static void main(String[] args) {

        String provider = extractProvider("Showbiz_bucket/autobox/provider/archive");
        System.out.println(provider);
    }

    private static String extractProvider(String path) {
        String[] tokens = path.split("/");
        return tokens[2];
    }
}
