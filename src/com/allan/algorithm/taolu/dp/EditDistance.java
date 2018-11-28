package com.allan.algorithm.taolu.dp;


import java.util.HashMap;
import java.util.Map;

public class EditDistance {
/*

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

1) Insert a character
2) Delete a character
3) Replace a character


example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


The idea here is to do start comparing the last character.  Let's say your inputs are:

xb
yc

X and Y can represent more than one characters, but what matters here is the last character, b and c.

if b and c are the same, that means there is no change, you can compare the rest, (which is x and y), if they are different
then there's a chance.

 xb
  ^
 yc
  ^

since b and c are different, so you have 1 change. Your delta is 1.

if they are the same, your delta is 0.

xc
 ^
yc
 ^

But note that there are 3 possible ways to change. You can either remove the character to make them the same. Example to make
xb and yc the same, you remove the c.

xb
y  <-- remove the c

or you can also remove b, to make it.

x   <--- b is removed
yc



To summarize, you get the minumum of the following changes:


 1) x,y + delta(b,c)
 2) xb, y  + 1
 3) x, yc + 1


what about the base case? if word1 is empty, the number of changes you need to make is the number of characters that word2 has. and vice versa.

*/

    // recursive
    private static int editDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        } else {
            int delta = word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1) ? 0 : 1;
            int option1 = editDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1)) + delta;
            int option2 = editDistance(word1, word2.substring(0, word2.length() - 1)) + 1;
            int option3 = editDistance(word1.substring(0, word1.length() - 1), word2) + 1;
            return Math.min(option1, Math.min(option2, option3));
        }
    }

    //recursive + memoization
    private static int editDistance(String word1, String word2, Map<String,Integer> map) {
        String key = word1 + ":" + word2;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        } else {
            int delta = word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1) ? 0 : 1;
            int option1 = editDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1), map) + delta;
            int option2 = editDistance(word1, word2.substring(0, word2.length() - 1), map) + 1;
            int option3 = editDistance(word1.substring(0, word1.length() - 1), word2, map) + 1;
            int minimum = Math.min(option1, Math.min(option2, option3));
            map.put(key, minimum);
            return minimum;
        }
    }

    // bottom up approach
    private static int editDistance2(String word1, String word2) {

        int[][] table = new int[word1.length() + 1][word2.length() + 1];

        for (int col = 0; col < table[0].length; col++) {
            table[0][col] = col;
        }

        for (int row = 0; row < table.length; row++) {
            table[row][0] = row;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    table[i][j] = table[i - 1][j - 1];
                }
                else {
                    table[i][j] = 1 + Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1]));
                }
            }
        }
        return table[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        Map<String, Integer> memoize = new HashMap<>();
        long startTime = System.nanoTime();
        int distance = editDistance("horse", "ros");
        long endTime = System.nanoTime();
        System.out.println(distance);
        System.out.println("no memoize: " + (endTime - startTime));

        memoize.clear();
        startTime = System.nanoTime();
        distance = editDistance("horse", "ros", memoize);
        endTime = System.nanoTime();
        System.out.println(distance);
        System.out.println("memoize: " + (endTime - startTime));

        System.out.println(" editDistance 2:" + editDistance2("horse", "ros"));


        startTime = System.nanoTime();
        distance = editDistance("intention", "execution");
        endTime = System.nanoTime();
        System.out.println(distance);
        System.out.println("no memoize: " + (endTime - startTime));


        memoize.clear();
        startTime = System.nanoTime();
        distance = editDistance("intention", "execution", memoize);
        endTime = System.nanoTime();
        System.out.println(distance);
        System.out.println("memoize: " + (endTime - startTime));

        System.out.println(" editDistance 2:" + editDistance2("intention", "execution"));

        memoize.clear();
        startTime = System.nanoTime();
        distance = editDistance("this is my fight song", "I cant fight this feeling", memoize);
        endTime = System.nanoTime();
        System.out.println(distance);
        System.out.println("memoize: " + (endTime - startTime));

        startTime = System.nanoTime();
        System.out.println(" editDistance 2:" + editDistance2("this is my fight song", "I cant fight this feeling"));
        System.out.println("no memoize: " + (endTime - startTime));


    }


}
