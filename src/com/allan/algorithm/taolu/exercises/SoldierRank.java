package com.allan.algorithm.taolu.exercises;

import java.util.HashSet;
import java.util.Set;

public class SoldierRank {
/*

A soldier with rank X reports to any soldier with rank X + 1.
Given an array of ranks, return the number of soldiers who reports to another soldier.
ex) [4, 2, 0] -> 0
ex) [3, 4, 3, 3, 0, 2, 2, 0] -> 5


the idea here is loop thru the input and put them in a Set (for fast lookup).

input:  [3, 4, 3, 3, 0, 2, 2, 0]

set = [3, 4, 3, 3, 0, 2, 2, 0]


loop thru the array:

 [3, 4, 3, 3, 0, 2, 2, 0]
  i

rankCounter = 0

for i to input.length

   if set.get(input[i] + 1)
      rankCounter++

 */

    public static void main(String[] args) {
        int[] input1 = {3, 4, 3, 3, 0, 2, 2, 0};

        int report = countRank(input1);
        System.out.println("report " + report);
    }

    private static int countRank(int[] input) {
        Set<Integer> ranks = new HashSet<>();
        for( int i = 0; i < input.length; i++) {
            ranks.add(input[i]);
        }

        int reportCounter = 0;

        for( int i = 0; i < input.length; i++) {
            if(ranks.contains(input[i] + 1)) {
                reportCounter++;
            }
        }

        return reportCounter;
    }
}
