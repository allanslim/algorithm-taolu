package com.allan.algorithm.taolu.exercises;


import java.util.Arrays;
import java.util.PriorityQueue;

/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.


Analysis:

Let say you are given this meeting:

     8  9   10   11  12  1  2  3  4  5  6  7  8   9  10
 m1                                        s-------e
 m2                   s---------e
 m3          s---------------------e
 m4               s----------------------e
 m5 s---e

s is the start time, and e is the end time. The first thing we need to do sort the intervals by start time.


     8  9   10   11  12  1  2  3  4  5  6  7  8   9  10
 m5  s--e
 m3          s---------------------e
 m4               s----------------------e
 m2                   s---------e
 m1                                        s-------e


after sorting the start time, we can check the end time of each event. If they overlap, then we need to use an extra room.

since we always need to know the earliest meeting to end, the best algorithm to use in min heap.



 */
public class MinimumMeetingRoom {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[5];
        intervals[0] = new Interval(19, 21);
        intervals[1] = new Interval(12, 15);
        intervals[2] = new Interval(10, 14);
        intervals[3] = new Interval(11, 18);
        intervals[4] = new Interval(8, 9);

        int meetingRooms = minMeetingRooms(intervals);
        System.out.println(meetingRooms);
    }

    private static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }
        return queue.size();
    }
}
