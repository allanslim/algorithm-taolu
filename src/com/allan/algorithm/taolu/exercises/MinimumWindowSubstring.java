package com.allan.algorithm.taolu.exercises;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * <p>
 * S = "ADOBECODEBANC"
 * <p>
 * <p>
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * <p>
 * {
 * A = 1
 * B = 1
 * C = 1
 * }
 *
 * This is a kind of a sliding window problem. We can use a Fast/Slow. You want to grow your window until you have a window
 * that contains all the characters you're looking for.
 *
 * It will also have a slow pointer that shrinks the window. Once you find a valid window with a fast pointer, you want to
 * starting sliding the slow pointer up until you no longer have a valid window.
 *
 * Once you have a substring that contains all the characters that you are looking for then you want to start shrinking
 * it by moving the slow pointer up until you no longer have a valid substring.
 *
 * so what we need:
 *
 * 1) A result tuple (or two-element array) that represents the start and end index of the shortest substring that
 * contains all the characters. Initialized to the largest possible range. [-Infinity,Infinity]
 *
 * 2) A hashMap to keep track of how letters in the set you've seen in the current window intitialized with all the characters
 * in the set as keys, and all the values as 0.
 *
 * 3) A counter to keep track of any time we see a new letter from the set when we grow the window, or lose a letter from
 * the set when we shrink the window. Initialized to the number of characters we are looking for
 *
 * 4) A fast and slow pointer both initalized to 0.
 *
 * Then we loop where the fast pointer increments every round. Within that for loop, if we see a character from the hashMap,
 * we increment its value in the map.
 *
 * if its value was a 0 in the hashMap before, then we decrement the number of characters missing, but we have repeats of the
 * character we're searching for we don't decrement the counter
 *
 * Once you've seen all the characters you're looking for, that counter will reach 0 and then we hae a while loop within the
 * for loop that only runs while the number of the counter is 0.
 *
 * within that while loop, if the difference between our fast and slow pointer is less than the difference between what is stored
 * in our result tuple, then we can replace that tuple with a new smallest window. By default, the first time we find a valid
 * window, it will update.
 *
 */
public class MinimumWindowSubstring {


    public static void main(String[] args) {

        String s = "ACBBACA";
        String t = "ABA";

        System.out.println("minWindowWithRepeats: " + minWindowWithRepeats(s, t)); // BACA
        System.out.println("minimumWindowSubstring: " + minimumWindowSubstring(s, t)); //

        s = "ADOBECODEBANC";
        t = "ABC";

        System.out.println("minWindowWithRepeats: " + minWindowWithRepeats(s, t)); // BANC
        System.out.println("minimumWindowSubstring: " + minimumWindowSubstring(s, t)); // BANC

        s = "this is a test string";
        t = "tist";


        System.out.println("minWindowWithRepeats: " + minWindowWithRepeats(s, t)); // t stri
        System.out.println("minimumWindowSubstring: " + minimumWindowSubstring(s, t)); // t stri

        s = "bbbabbbbbbbbbbcabbabbbbbcbbbbb";
        t = "aabc";
        System.out.println("minWindowWithRepeats: " + minWindowWithRepeats(s, t)); // cabba
        System.out.println("minimumWindowSubstring: " + minimumWindowSubstring(s, t)); // cabba
    }

    private static String minimumWindowSubstring(String s, String t) {
        int[] result = {0, Integer.MAX_VALUE};
        Map<Character, Integer> counts = new HashMap<>();
        int missingCharacters = t.length();

        // create the counts hash map
        for (int i = 0; i < t.length(); i++) {
            counts.put(t.charAt(i), 0);
        }

        int slow = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            char fastLetter = s.charAt(fast);

            // check if the character at fast index is in counts hashmap
            if (counts.containsKey(fastLetter)) {
                // if you haven't seen that character before
                if(counts.get(fastLetter) == 0) {
                    missingCharacters -= 1;
                }
                counts.put(fastLetter, counts.get(fastLetter) + 1);
            }

            // if there's no more missing character, store the indices (slow and fast)
            while (missingCharacters == 0) {
                // update result range if small than pervious range
                if ((fast - slow) < (result[1] - result[0])) {
                    result[0] = slow;
                    result[1] = fast;
                }

                // shrink window until you have an incomplete set
                if( counts.containsKey(s.charAt(slow)) ) {
                    counts.put(s.charAt(slow), counts.get(s.charAt(slow)) - 1);

                    // if the character in the map has a value of zero, increase the missing character.
                    if(counts.get(s.charAt(slow)) == 0) {
                        missingCharacters += 1;
                    }
                }
                slow += 1;
            }


        }
        return result[1] == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }

    private static String minWindowWithRepeats(String s, String t) {
        Map<Character, Integer> lettersSeen = new HashMap<>();
        Map<Character, Integer> lettersNeeded = new HashMap<>();
        int lettersMissing = 0;

        for (char i : t.toCharArray()) {
            if (lettersNeeded.containsKey(i)) {
                lettersNeeded.put(i, lettersNeeded.get(i) + 1);
            } else {
                lettersNeeded.put(i, 1);
                lettersSeen.put(i, 0);
                lettersMissing += 1;
            }
        }

        int slow = 0;
        int[] window = {0, Integer.MAX_VALUE};

        for (int fast = 0; fast < s.length(); fast++) {
            Character letterAtFastIndex = s.charAt(fast);

            if (lettersNeeded.containsKey(letterAtFastIndex)) {
                lettersSeen.put(letterAtFastIndex, lettersSeen.get(letterAtFastIndex) + 1);
            }

            if (lettersSeen.get(letterAtFastIndex) != null &&
                    lettersNeeded.get(letterAtFastIndex) != null &&
                    lettersSeen.get(letterAtFastIndex).equals(lettersNeeded.get(letterAtFastIndex))) {
                lettersMissing -= 1;
            }

            // if there's no more missing letter
            while (lettersMissing == 0) {
                if (fast - slow < window[1] - window[0]) {
                    window[0] = slow;
                    window[1] = fast;
                }
                char letterAtSlowIndex = s.charAt(slow);
                if (lettersNeeded.containsKey(letterAtSlowIndex)) {
                    lettersSeen.put(letterAtSlowIndex, lettersSeen.get(letterAtSlowIndex) - 1);
                }
                if (lettersSeen.get(letterAtSlowIndex) != null &&
                        lettersNeeded.get(letterAtSlowIndex) != null &&
                        lettersSeen.get(letterAtSlowIndex) < lettersNeeded.get(letterAtSlowIndex)) {
                    lettersMissing += 1;
                }
                slow += 1;
            }
        }
        return s.substring(window[0], window[1] + 1);
    }

}
