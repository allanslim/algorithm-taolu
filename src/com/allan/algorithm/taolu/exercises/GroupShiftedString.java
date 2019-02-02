package com.allan.algorithm.taolu.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**

 Group Shifted String
 Given an array of strings (all lowercase letters), the task is to group them in such a way that all strings in a group are shifted versions of each other. Two string S and T are called shifted if,

 S.length = T.length
 and
 S[i] = T[i] + K for
 1 <= i <= S.length  for a constant integer K
 For example strings {acd, dfg, wyz, yab, mop} are shifted versions of each other.

 Input  : str[] = {"acd", "dfg", "wyz", "yab", "mop",
 "bdfh", "a", "x", "moqs"};

 Output : a x
 acd dfg wyz yab mop
 bdfh moqs
 All shifted strings are grouped together.

 Solution:


 What is shifted string? A string that order has been shifted. For example:

 acd  - a has been shifted to the right once. instead of "abcd", "a" was moved to the right, making "bacd".

 Given these shifted string, you can check if the pattern has been moved, by using their int ascii value.

 acd = 21

 'c' - 'a' = 2
 'd' - 'c' = 1


 so:

 acd = 21
 dfg = 21
 wyz = 21

 When can then use a hash map, with key as the pattern and the value is the list of similar patterns.


 21 => [acd,dfg,wyz]

 */
public class GroupShiftedString {

    public static final int NUMBEROFALPHABETS = 26;

    public static void main(String[] args) {
        String[] inputs =  {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};

        List<List<String>> grouped = groupShiftedString(inputs);

        for(List<String> gr : grouped) {
            System.out.println(Arrays.toString(gr.toArray()));
        }
    }

    private static List<List<String>> groupShiftedString(String[] inputs) {

        Map<String, List<String>> groupMap = new HashMap<>();

        for (String input : inputs) {
            String pattern = getPattern(input);

            if(groupMap.containsKey(pattern)) {
                List<String> shiftedStrings = groupMap.get(pattern);
                shiftedStrings.add(input);
            } else {
                List<String> shiftedStrings = new ArrayList<>();
                shiftedStrings.add(input);
                groupMap.put(pattern, shiftedStrings);
            }
        }

        return groupMap.values().stream().collect(Collectors.toList());
    }

    private static String getPattern(String input) {
        String pattern = "";
        for(int i = 1; i < input.length(); i++) {
            int diff = input.charAt(i) - input.charAt(i - 1);

            if(diff < 0) {
                diff += NUMBEROFALPHABETS;
            }

            pattern += (char) (diff + 'a');
        }
        return pattern;
    }
}
