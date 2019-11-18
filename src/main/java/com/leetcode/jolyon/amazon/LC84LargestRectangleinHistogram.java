package com.leetcode.jolyon.amazon;

import java.util.Stack;

public class LC84LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                // IMPORTANT! Use the position of next smaller element as the
                // left side!
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxarea = Math.max(maxarea, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length :
                    heights.length - stack.peek() - 1;
            maxarea = Math.max(maxarea, height * width);
        }
        return maxarea;
    }
}
