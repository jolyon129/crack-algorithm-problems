package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClutterBeforeandAfterPuzzle {
    public List<String> generatePhrases(List<String> phrases){
        List<String> res = new ArrayList<>();
        List<String[]> inputList = new ArrayList<>();
        Map<String, List<Integer>> tailMap = new HashMap<>();
        for(int i=0;i<phrases.size();i++){
            String str = phrases.get(i);
            String[] strArr = str.split(" ");
            String end = strArr[strArr.length - 1];
            List<Integer> list = tailMap.getOrDefault(end, new ArrayList<>());
            list.add(i);
            tailMap.put(end, list);
            inputList.add(strArr);
        }
        for(int i =0; i<phrases.size();i++){
            String head = inputList.get(i)[0];
            if (tailMap.containsKey(head)) {
                List<Integer> indices = tailMap.get(head);
                for (int i2 : indices) {
                    if(i2==i) continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(phrases.get(i2));
                    for(int j=1;j<inputList.get(i).length;j++){
                        sb.append(" ");
                        sb.append(inputList.get(i)[j]);
                    }
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}
