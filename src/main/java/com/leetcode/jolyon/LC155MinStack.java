package com.leetcode.jolyon;

import java.util.Stack;

public class LC155MinStack {
    public class MinStack {

        int min = Integer.MAX_VALUE;
        Stack<int[]> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            min = Math.min(x, min);
            stack.push(new int[]{x, min});
        }

        public void pop() {
            stack.pop();
            if(stack.isEmpty()){
                min = Integer.MAX_VALUE;
            }else{
                min = stack.peek()[1];
            }

        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

}
