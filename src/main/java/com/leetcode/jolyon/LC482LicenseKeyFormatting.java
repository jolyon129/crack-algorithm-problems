package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = S.length()-1;i>=0;i--){
            char c = S.charAt(i);
            if(c=='-') continue;
            sb.append(Character.toUpperCase(c));
            count++;
            if(count%K==0){
                sb.append('-');
            }
        }
        if(sb.length()==0) return "";
        if(sb.charAt(sb.length()-1)=='-') sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();

    }
    public String solution(String S, int K) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();
        int count =0;
        for(int i=S.length()-1;i>=0;i--){
            char c = S.charAt(i);
            if(c=='-') continue;
            count++;
            if(Character.isLowerCase(c)) c=Character.toUpperCase(c);
            dq.offerFirst(c);
            if(count==K&&i!=0){
                dq.offerFirst('-');
                count = 0;
            }
        }
        for(Character c: dq){
            sb.append(c);
        }
        return sb.toString();
    }
}
