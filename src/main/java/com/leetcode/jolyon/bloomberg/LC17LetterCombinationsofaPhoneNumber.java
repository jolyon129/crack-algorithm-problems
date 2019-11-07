package com.leetcode.jolyon.bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        Map<Integer,char[]> map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        List<String> res = new ArrayList<String>();
        StringBuilder curPath = new StringBuilder();
        recur(map,curPath, 0,digits,res);
        return res;
    }
    private void recur(Map<Integer, char[]> map, StringBuilder curPath, int idx, String digits, List<String> res){
        if(idx==digits.length()){
            res.add(curPath.toString());
            return;
        }
        char d = digits.charAt(idx);
        char[] candidates = map.get(d-'0');
        for(char c: candidates){
            idx++;
            curPath.append(c);
            recur(map,curPath,idx,digits,res);
            idx--;
            curPath.setLength(curPath.length()-1);
        }
    }
}
