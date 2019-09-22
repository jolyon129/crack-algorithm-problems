package com.leetcode.jolyon;

public class LC443StringCompression {
    public int compress(char[] chars) {
        int idx=0;
        int i =0;
        while(i<chars.length){
            chars[idx] = chars[i];
            idx++;
            int j = i;
            while(j<chars.length&&chars[j]==chars[i]){
                j++;
            }
            if(j-i!=1){
                char[] tmp =String.valueOf(j-i).toCharArray();
                for(char c: tmp){
                    chars[idx] =c;
                    idx++;
                }
            }
            i = j;
        }
        return idx;
    }
}
