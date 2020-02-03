package com.leetcode.jolyon.amazon;

import java.util.LinkedList;
import java.util.List;

public class LC636ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        LinkedList<Log> stack = new LinkedList<>();
        int[] result = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.timestamp - top.timestamp + 1);
                if (!stack.isEmpty()) {
                    // subtract in advance. it becomes negative.
                    result[stack.peek().id] -= (log.timestamp - top.timestamp + 1);
                }
            }
        }

        return result;
    }

    public static class Log {
        public int id;
        public boolean isStart;
        public int timestamp;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            timestamp = Integer.valueOf(strs[2]);
        }
    }
}
