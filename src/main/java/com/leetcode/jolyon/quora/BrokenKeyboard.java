package com.leetcode.jolyon.quora;

import java.util.HashSet;
import java.util.Set;

public class BrokenKeyboard {
    int solve(String input, char[] letters){
        String[] words = input.split("\\W+");
        Set<Character> set = new HashSet<>();
        for(char c:letters) set.add(c);
        int count =0;
        for(String word:words){
            word = word.toLowerCase();
            boolean canBePrinted = true;
            for(char c: word.toCharArray()){
                if(!set.contains(c)){
                    canBePrinted = false;
                    break;
                }
            }
            if(canBePrinted) count++;
        }
        return count;
    }
}
