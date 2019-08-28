package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC904FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        if(tree.length==1) return 1;
        int left =0;
        int right = 1;
        Map<Integer,Integer> count = new HashMap<>();
        count.put(tree[left],count.getOrDefault(tree[left],0)+1);
        count.put(tree[right],count.getOrDefault(tree[right],0)+1);
        int ans = 2;
        right++;
        while(right<tree.length){
            if((count.size()==2&&!count.containsKey(tree[right]))){
                count.put(tree[right],count.getOrDefault(tree[right],0)+1);
                while(left<tree.length&&count.size()>2){
                    count.put(tree[left], count.get(tree[left]) - 1);
                    if(count.get(tree[left])==0) count.remove(tree[left]);
                    left++;
                }

            }else{
                count.put(tree[right],count.getOrDefault(tree[right],0)+1);
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
