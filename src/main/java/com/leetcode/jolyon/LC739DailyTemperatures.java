package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] ans = new int[T.length];
        for(int i= T.length-1;i>=0;i--){
            if(i==T.length-1){
                ans[i]=0;
                stack.offerFirst(new int[]{T[i], i});
            }else{
                while(!stack.isEmpty()&&T[i]>=stack.peekFirst()[0]){
                    stack.pollFirst();
                }
                if(stack.size()==0){
                    ans[i] = 0;
                }else{
                    ans[i] = stack.peek()[1] - i;
                }
                stack.offerFirst(new int[]{T[i], i});
            }
        }
        return ans;
    }
}
