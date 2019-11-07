package com.leetcode.jolyon;

import java.util.Stack;

public class LC227BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        // This is important!  Handle the edge case!!
        s += '+';
        // previous operator
        char op = '+';
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                n = n * 10 + c - '0';
            } else {
                if (c == ' ') continue;
                if (op == '+') stack.push(n);
                else if (op == '-') stack.push(-n);
                else if (op == '*') stack.push(stack.pop() * n);
                else if (op == '/') stack.push(stack.pop() / n);
                op = c;
                n = 0;
            }
        }

        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }
}
