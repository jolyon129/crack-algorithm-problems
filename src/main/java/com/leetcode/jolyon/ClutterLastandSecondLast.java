package com.leetcode.jolyon;

public class ClutterLastandSecondLast {
    public String lastLetters(String word){
        StringBuilder sb = new StringBuilder();
        int N = word.length();
        if(N>2){
            sb.append(word.charAt(N - 1));
            sb.append(" ");
            sb.append(word.charAt(N - 2));
        }else{
            sb.append(word.charAt(N));
        }
        return sb.toString();
    }
}
