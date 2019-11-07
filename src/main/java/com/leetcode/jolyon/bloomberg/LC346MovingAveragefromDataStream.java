package com.leetcode.jolyon.bloomberg;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC346MovingAveragefromDataStream {
    class MovingAverage {
        private final Deque<Integer> window;
        private final int maxSize;
        private double sum = 0.0;

        public MovingAverage(int maxSize) {
            this.window = new ArrayDeque<Integer>(maxSize);
            this.maxSize = maxSize;
        }

        public double next(int val) {
            if (window.size() == maxSize) {
                sum -= window.poll();
            }
            window.offer(val);
            sum += val;
            return sum / window.size();
        }
    }
}
