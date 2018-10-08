package com.allan.algorithm.taolu.exercises;


/*

//
// Find conflicts in a calendar
//


Requirements:
- 2 or more meetings overlapping - conflict
- single meeting calendar

- pre-populated calendar. Accepted a meetings that has conflict.

Finding conflicts in a calendar for a given day.

Friday              FirstMeeting                       current
9:00 -  10:00 ( 9:00-10:00 meeting with Person A)  ( 9:30 to 10:30 with Person B)
10:00 - 11:00  (10:00-11:30 meeting with Person C) ( 10:30 - 11:00 with Person D)
11:00 - 12:00
12:00 - 1:00 (break)
1:00 -  2:00
2:00 -  3:00
4:00 -  5:00

// 8-------------------------------------4
//         11---------------------------------6
//              1-----------------3:30

// if you keep track of meeting with highest end time
// just need you to return a list of meetings in conflict


// if next meeting in list starts before current meeting ends => conflict
// because it is ordered
// and to handle multiple overlapping meetings, you need to check the highest end time

sort the meeting by earliest start time
get the first meeting (firstMeeting)
loop thru meetings (2nd meeting), and get the start time.
   if the  firstmeeting.end time > current star time > firstMeeting.start time  **works**
    conflict exist

    firstMeeting.startTime = 9:00
    firstMeeting.endTime = 10:00

    current.startTime = 9:30*
    current.endTime = 10:30


class Meeting {
    long startTime;
    long endTime;
    public Meeting(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    // getters / setters.
}

    List<Meeting> meetings = new ArrayList<>();


9:00 - 10:30
        9:30 - 11:00
        10:30 - 11:00 i

        endTime = 10:00

        if endTime < i.endTime
        conflict
        else if startTime < i.startTime
        confict

        if its less than the starttime of the previous meeting.

public List<Meeting> findConflict(List<Meeting> meetings) {

        List<Meeting> conflictedMeetings = new ArrayList<>();

        List<Meeting> sortedMeetings = sortByEerliestStartTime(meetings);


        long endTime = soretedMeetings.get(0).endTime;
        for( int i = 0; i < sortedMeetings.size(); i++ ) {

        if(the srotedMeetings.get(i)  )

        endTime = max( endTime, current.endTime)


        }




        }







        */

public class CalendarConflict {
}
