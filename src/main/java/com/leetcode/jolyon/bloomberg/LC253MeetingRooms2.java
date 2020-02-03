package com.leetcode.jolyon.bloomberg;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (c1, c2) -> Integer.compare(c1[0], c2[0]));
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((c1, c2) -> Integer.compare(c1[1], c2[1]));
        for(int i=0;i<intervals.length;i++){
            if(pq.size()==0){
                pq.offer(intervals[i]);
            }else{
                if(intervals[i][0]<pq.peek()[1]){
                    // assign a new room to this meeting.
                    pq.offer(intervals[i]);
                }else{
                    // If we can reuse this room, we need to extend the timestamp
                    // we used it.
                    int[] head = pq.poll();
                    head[1] = intervals[i][1];
                    // extend the timestamp of using the current room.
                    pq.offer(head);
                }
            }

        }
        return pq.size();
    }

}
