package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generate(ret, new char[n * 2], 0, 0, n, 0);
        return ret;
    }

    private void generate(List<String> result, char[] curPath, int left, int right,
                          int max, int idx) {
        if (left == max && right == left) {
            result.add(String.valueOf(curPath));
            return;
        }
        
        if (left < max) {
            curPath[idx] = '(';
            generate(result, curPath, left + 1, right, max, idx + 1);
        }
        if (right < left) {
            curPath[idx] = ')';
            generate(result, curPath, left, right + 1, max, idx + 1);
        }
    }
}
