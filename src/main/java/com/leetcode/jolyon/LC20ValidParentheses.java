package com.leetcode.jolyon;

import java.util.Stack;

public class LC20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.equals("")) {
            return false;
        }
        if (s.length() / 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                char b = stack.peek();
                char b_r = s.charAt(i);
                if ((b_r == ']' && b != '[') || (b_r == '}' && b != '{') || (b_r == ')' && b != '(')) {
                    return false;
                }else{
                    stack.pop();
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
}
