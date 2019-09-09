package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwitterMaxDiscount {
    public int finalPrice(int[] prices){
        if(prices.length==0) return 0;
        // Next Less Element
        Deque<Integer> NLE = new ArrayDeque<>();
        int res = 0;
        for(int i=prices.length-1;i>=0;i--){
            while (NLE.size()!=0&&NLE.peekFirst()>prices[i]){
                NLE.pollFirst();
            }

            res += NLE.isEmpty() ? prices[i] : prices[i] - NLE.peek();
            NLE.offerFirst(prices[i]);
        }
        return res;
    }
}
