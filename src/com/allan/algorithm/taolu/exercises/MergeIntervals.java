package com.allan.algorithm.taolu.exercises;

import java.util.*;

public class MergeIntervals {


    static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**

     simple approach is to loop thru the array, and do brute force comparison. O(n^2)

     We can do better, by first:

     1) sort the list by start interval.
     2) push the first element in a stack
     3)

     1-3, 2-6, 8-10, 15-18

     stack = 1-3

     loop thru the list from 1 to n.

     pop the first element. check if it has overap.


     i = 2-6
     top = 1-3

            3        2
     if top.end < i.start  -- no overlapp, push the 2-6 to the stack.

                 3        6
     else if top.end < i.end -- overlap
         top.end = i.end
         stack.pop()
         stack.push()

     */

    public static void main(String[] args) {

     //   int[][] input = { {1,3}, {2,6}, {8, 10}, { 15,18} };


        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));



        List<Interval> merged = merge(intervals); // { {1,6}, {8, 10}, {15,18} }

        merged.forEach( interval -> System.out.println(interval.start + "-" + interval.end));


        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(4, 5));

        merged = merge(intervals); // {{1,5}}

        merged.forEach( interval -> System.out.println(interval.start + "-" + interval.end));
    }

    public static List<Interval> merge( List<Interval> intervals) {

        // always check for empty input.
        if(intervals.isEmpty()) {
            return intervals;
        }

        // sort by start time.
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if(interval1.start > interval2.start) {
                    return 1;
                }else if(interval1.start < interval2.start) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval top = stack.peek();

            Interval current = intervals.get(i);
            if(top.end < current.start) {
                stack.push(current);
            } else if( top.end < current.end) {
                top.end = current.end;
                stack.pop();
                stack.push(top);
            }
        }

        return new ArrayList(stack);

    }
}
