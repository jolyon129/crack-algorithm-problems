package com.leetcode.jolyon;

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
                    pq.offer(intervals[i]);
                }else{
                    int[] head = pq.poll();
                    head[1] = intervals[i][1];
                    pq.offer(head);
                }
            }

        }
        return pq.size();
    };

}
