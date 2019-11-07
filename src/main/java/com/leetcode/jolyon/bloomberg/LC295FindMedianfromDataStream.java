package com.leetcode.jolyon.bloomberg;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC295FindMedianfromDataStream {
    class MedianFinder {

        private Queue<Long> minHeap = new PriorityQueue();
        private Queue<Long> maxHeap =
                new PriorityQueue<>((w1, w2) -> Long.compare(w2, w1));

        public void addNum(int num) {
            maxHeap.add((long) num);
            minHeap.add(maxHeap.poll());
            // Make sure the head of MaxHeap is smaller than the head of
            // MinHeap
            // Make sure the size of MaxHeap always greater or equal to MinHeap
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }
    }

    ;
}
