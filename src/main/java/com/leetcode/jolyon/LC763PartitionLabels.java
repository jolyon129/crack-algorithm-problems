package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] letterToRightmost = new int[26];
        for (int i = 0; i < S.length(); ++i)
            letterToRightmost[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, letterToRightmost[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public List<Integer> partitionLabels1(String S) {
        Map<Character, Integer> last = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            last.put(S.charAt(i), i);
        }
        for (int i = 0; i < S.length(); i++) {
            int l = last.get(S.charAt(i));
            int j = i;
            while (j < l) {
                l = last.get(S.charAt(j)) > l ? last.get(S.charAt(j)) : l;
                j++;
            }
            res.add(j - i + 1);
            i = j;
        }
        return res;
    }
}
