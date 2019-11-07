package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generate(ret, new char[n * 2], 0, 0, n, 0);
        return ret;
    }

    private void generate(List<String> ret, char[] str, int left, int right, int max, int i) {
        if (left == max && right == left) {
            ret.add(String.valueOf(str));
            return;
        }

        if (left < max) {
            str[i] = '(';
            generate(ret, str, left + 1, right, max, i + 1);
        }
        if (right < left) {
            str[i] = ')';
            generate(ret, str, left, right + 1, max, i + 1);
        }
    }
}
