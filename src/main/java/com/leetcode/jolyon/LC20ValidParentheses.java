package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC20ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        if (s.equals("")) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            // If the char is a closing brackets
            if (!brackets.containsKey(s.charAt(i))) {
                if (stack.size() == 0) return false;
                char ele = stack.pollLast();
                if (s.charAt(i) != brackets.get(ele)) return false;
            } else {
                stack.add(s.charAt(i));
            }
        }
        // In the end, if the stack is not empty
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
