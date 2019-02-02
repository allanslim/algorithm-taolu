package com.allan.algorithm.taolu.exercises;


import java.util.HashSet;
import java.util.Set;

/*

Given a list of Sessions, filter out the sessions that are within a given time frame.



Session {
  userId: 342342,
  timeStart: 1587639876,
  timeEnd: 1592398478
}


 Set<Session> findUsersWithinWindow(Set<Session> sessions, long startTime, long endTime)


Analysis:

let say the given time frame is: startTime: 10:00AM and endTime: 12:00PM PST


And you have 4 user sessions:



            <--------->
  8 - 9  - 10 - 11 - 12 - 13 - 14 - 15 - 16 - 17 - 18
0 s------e
1    s-----------e
2             s-------e
3                s------->e
4                         s-------->e


The formula would be:

StartTime <= session.timeEnd &&  endTime >= session.timeEnd <-- within window
StartTime <= session.startTime <= endTime <-- within window



Solution:

loop thru the session:

  if startTime <= user.timeEnd   &&  endTime >= session.timeEnd ||
     starTime <= user.starTime <= endTime
         users.add(user)

*/

public class WindowTime {

    static class Session {
        String userId;
        long timeStart;
        long timeEnd;

        Session(String userId, long timeStart, long timeEnd) {
            this.userId = userId;
            this.timeStart = timeStart;
            this.timeEnd = timeEnd;
        }
    }

    public static void main(String[] args) {
        Set<Session> sessions = new HashSet<>();
        sessions.add(new Session("abc", 7, 9));
        sessions.add(new Session("bcd", 7, 11));
        sessions.add(new Session("xyz", 10, 12));
        sessions.add(new Session("def", 13, 15));

        Set<Session> userSessions = findUsersWithinWindow(sessions, 10L, 12L);
        for( Session session: userSessions) {
            System.out.println(session.userId);
        }
    }

    public static Set<Session> findUsersWithinWindow(Set<Session> sessions, long startTime, long endTime) {
        Set<Session> results = new HashSet<>();
        for(Session session: sessions) {
            if((startTime <= session.timeEnd && endTime >= session.timeEnd)  ||
                    (startTime <= session.timeStart && session.timeStart <= endTime )) {
                results.add(session);
            }
        }
        return results;
    }
}






