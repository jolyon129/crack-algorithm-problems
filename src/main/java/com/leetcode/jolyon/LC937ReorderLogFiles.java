package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC937ReorderLogFiles {
    /**
     * Custom sort
     */
    static class Solution{
        public String[] reorderLogFiles(String[] logs){
            if(logs.length<=1) return logs;
            Arrays.sort(logs,(w1, w2)->{
                String[] s1 = w1.split(" ", 2);
                String[] s2 = w2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
                if(isDigit1&&isDigit2){
                    return 0;
                }else if(!isDigit1&&isDigit2){
                    return -1;
                }else if(isDigit1&&!isDigit2){
                    return 1;
                }else{
                    int cmp = s1[1].compareTo(s2[1]);
                    if(cmp==0){
                        return s1[0].compareTo(s2[0]);
                    }else{
                        return cmp;
                    }
                }
            });
            return logs;
        }
    }
    static class Solution1{
        public String[] reorderLogFiles(String[] logs) {
            if(logs.length<=1) return logs;
            List<String> res = new ArrayList<>();
            List<String> tmp = new ArrayList<>();
            for(int i=0; i<logs.length;i++){
                int l = logs[i].length();
                if(Character.isLetter(logs[i].charAt(l-1))){
                    res.add(logs[i]);
                }else{
                    tmp.add(logs[i]);
                }
            }
            res.sort((w1,w2)->{
                String[] split1 = w1.split(" ", 2);
                String[] split2 = w2.split(" ", 2);
                int cmp = split1[1].compareTo(split2[1]);
                if(cmp==0){
                    return split1[0].compareTo(split2[0]);
                }else{
                    return cmp;
                }
            });
            res.addAll(tmp);
            return res.toArray(new String[1]);
        }
    }
}
