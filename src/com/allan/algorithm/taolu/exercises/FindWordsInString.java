package com.allan.algorithm.taolu.exercises;

public class FindWordsInString {

    public static void main(String[] args) {
        String input = "asdk sfdsf s$53, ds";
        int n = findNumberOfWords(input);
        System.out.println(n);

        System.out.println(findNumberOfWords2(input));
    }

    private static int findNumberOfWords(String input) {

        int wordCount = 0;
        boolean word = false;
        int endOfLine = input.length() - 1;

        for (int i = 0; i < input.length(); i++) {
            if(Character.isLetter(input.charAt(i)) && i != endOfLine ) {
                word = true;
            }
            else if(!Character.isLetter(input.charAt(i)) && word) {
                wordCount++;
                word = false;
            }else if(Character.isLetter(input.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

    private static int findNumberOfWords2(String input) {
        String trimmedInput = input.trim();
        if(trimmedInput.isEmpty()) {
            return 0;
        }
        return trimmedInput.split("\\s+").length;
    }
}
