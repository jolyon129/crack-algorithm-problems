package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1190ReverseSubstringsBetweenEachPairofParentheses {
    static class recursiveSolution{
        char[] arr;
        int idx;

        public String reverseParentheses(String s) {
            arr = s.toCharArray();
            idx = 0;
            if (arr.length == 0) return "";
            recur();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(' || arr[i] == ')') {
                    continue;
                } else {
                    sb.append(arr[i]);
                }
            }
            return sb.toString();
        }

        private void recur() {
            if (idx >= arr.length) return;
            int start = idx;
            while (idx < arr.length) {
                if (arr[idx] == '(') {
                    idx = idx + 1;
                    recur();
                    if (idx >= arr.length) return;
                } else if (arr[idx] == ')') {
                    int s = start;
                    int e = idx - 1;
                    while (s < e) {
                        swap(s, e);
                        s++;
                        e--;
                    }
                    idx = idx + 1;
                    return;
                } else {
                    idx++;
                }

            }
        }

        private void swap(int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    static class iterativeSolution{
        public String reverseParentheses(String s) {
            Stack<Character> st = new Stack<>();
            for (char c: s.toCharArray()) {
                if (c == ')') {
                    List<Character> list = new ArrayList<>();
                    while (!st.isEmpty() && st.peek() != '(') list.add(st.pop());
                    if (!st.isEmpty()) st.pop();
                    for (char ch: list) st.push(ch);
                } else {
                    st.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) sb.append(st.pop());
            return sb.reverse().toString();
        }
    }
}
