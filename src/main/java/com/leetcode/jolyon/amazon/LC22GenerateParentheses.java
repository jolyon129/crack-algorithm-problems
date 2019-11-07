package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
    static class  Solution{
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            StringBuilder curPath = new StringBuilder();
            recur(curPath, n, n, res);
            return res;
        }

        private void recur(StringBuilder curPath, int open, int close,
                           List<String> ans) {
            if (open == 0 & close == 0) {
                ans.add(curPath.toString());
                return;
            }
            if (open == 0 && close>0) {
                recur(curPath.append(')'), open, close - 1, ans);
                curPath.setLength(curPath.length() - 1);
                return;
            }
            if (open == close) {
                recur(curPath.append('('), open - 1, close, ans);
                curPath.setLength(curPath.length() - 1);
                return;
            }
            if (open < close && open > 0) {
                recur(curPath.append('('), open - 1, close, ans);
                curPath.setLength(curPath.length() - 1);
                recur(curPath.append(')'), open, close - 1, ans);
                curPath.setLength(curPath.length() - 1);
                return;
            }

        }
    }
    static class IterativeSolution{
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            StringBuilder curPath = new StringBuilder();

            return res;
        }
    }

}
