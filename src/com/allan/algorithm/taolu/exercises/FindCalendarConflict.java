package com.allan.algorithm.taolu.exercises;

import java.util.ArrayList;
import java.util.List;

public class FindCalendarConflict {
/*

    Given a list of Meetings, find the concflict.

If the interviewer doesn't provide the definition of a meeting, you can start by defining a meeting.
A meeting normally has a start time and end time. The simplest way to define time is to use epoch time in milliseconds.

class Meeting
   id
   long startTime
   long endTime

The second questions to ask is if the input is given as sorted or not. If it is not sorted, it is easier to sort the meetings by start time.

Once it is sorted, the first thing we need to do is to get the first meeting and use it for comparison.

if you have a lot of meeting. Let say:

   8 - 9 - 10  - 11 - 12 - 13 - 14 - 15 - 16 - 17 - 18
0  s--------e
1      s----------e
2                     s-----e
3                         s------e

In the example above, the first meeting's start time is at 8AM and ends at 10PM. The second meeting starts at 9AM and ends at 11AM.

The conflicts happends if the start time happens before the end time. The start time of second meeting starts at 9AM, and it is before
the the end time of the second meeting.

It is easier to check if the two meeting does not conflict than conflicting.

if secondMeeting.startTime <= firstMeeting.endTime   --> no conflict

*/
    public static class Meeting {
        String id;
        long startTime;
        long endTime;

        public Meeting(String id, long startTime, long endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }


    List<Meeting> findConflict(List<Meeting> meetings) {

        // if meetings is not sorted, we have to sort it first by earliest start time.
        // sortByStartTime(meetings)

        List<Meeting> results = new ArrayList<>();
        List<Meeting> conflicts = new ArrayList();

        long endTime = meetings.get(0).endTime;

        for (int i = 1; i < meetings.size(); i++) {

            Meeting currentMeeting = meetings.get(0);

            if ( currentMeeting.startTime >= endTime ) { // no conflict
                if(conflicts.size() > 1) {
                    results.addAll(conflicts);
                }
                conflicts.clear();
            }
            endTime = currentMeeting.endTime;
            conflicts.add(currentMeeting);

        }

        if(conflicts.size() > 1) {
            results.addAll(conflicts);
        }

        return results;
    }


}
