package com.leetcode.jolyon.amazon;

import java.util.Stack;

public class LC32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // Store the left boundary. Kind of like monotonous stack!
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.add(i);
            else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    int length = stack.isEmpty() ? i + 1 : i - stack.peek();
                    maxLen = Math.max(maxLen, length);
                } else {
                    stack.add(i);
                }
            }
        }
        return maxLen;
    }
}
