package com.leetcode.jolyon;

import java.util.*;

public class LC301RemoveInvalidParentheses {

    static class MyBadSolution {
        // The if clauses are messed up.
        public List<String> removeInvalidParentheses(String s) {
            int lR = 0;
            int rR = 0;
            // Caculate invalid parentheses.
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    lR++;
                } else if (s.charAt(i) == ')') {
                    if (lR > 0) {
                        lR--;
                    } else {
                        rR++;
                    }
                }
            }
            Set<String> res = new HashSet<String>();
            StringBuilder path = new StringBuilder();
            recur(s, 0, 0, 0, lR, rR, res, path);

            return new ArrayList<String>(res);
        }

        private void recur(String s, int index, int right, int left, int lR,
                           int rR
                , Set<String> res, StringBuilder path) {
            if (lR == 0 && rR == 0 && left == right && index == s.length()) {
                res.add(path.toString());
            } else if (lR < 0 || rR < 0) {
                return;
            } else if (index == s.length()) {
                return;
            } else if (s.charAt(index) != '(' && s.charAt(index) != ')') {
                path.append(s.charAt(index));
                recur(s, index + 1, right, left, lR, rR, res, path);
                path.deleteCharAt(path.length() - 1);
            } else if (s.charAt(index) == ')' && left <= right) {
                recur(s, index + 1, right, left, lR, rR - 1, res, path);
            } else {
                int len = path.length();
                path.append(s.charAt(index));
                if (s.charAt(index) == '(') {
                    recur(s, index + 1, right, left + 1, lR, rR, res, path);
                } else {
                    recur(s, index + 1, right + 1, left, lR, rR, res, path);
                }
                path.deleteCharAt(path.length() - 1);
                if (s.charAt(index) == '(') {
                    recur(s, index + 1, right, left, lR - 1, rR, res, path);
                } else {
                    recur(s, index + 1, right, left, lR, rR - 1, res, path);
                }
            }
        }
    }

    static class Solution {
        private Set<String> validExpressions = new HashSet<String>();

        private void recurse(
                String s,
                int index,
                int leftCount,
                int rightCount,
                int leftRem,
                int rightRem,
                StringBuilder expression) {

            // If we reached the end of the string, just check if the resulting expression is
            // valid or not and also if we have removed the total number of left and right
            // parentheses that we should have removed.
            if (index == s.length()) {
                if (leftRem == 0 && rightRem == 0) {
                    this.validExpressions.add(expression.toString());
                }

            } else {
                char character = s.charAt(index);
                int length = expression.length();

                // The discard case. Note that here we have our pruning condition.
                // We don't recurse if the remaining count for that parenthesis is == 0.
                if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                    this.recurse(
                            s,
                            index + 1,
                            leftCount,
                            rightCount,
                            leftRem - (character == '(' ? 1 : 0),
                            rightRem - (character == ')' ? 1 : 0),
                            expression);
                }

                expression.append(character);

                // Simply recurse one step further if the current character is not a parenthesis.
                if (character != '(' && character != ')') {

                    this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);

                } else if (character == '(') {

                    // Consider an opening bracket.
                    this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);

                } else if (character == ')') {
                    // Consider a closing bracket.
                    if (leftCount > rightCount) {
                        this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
                    }
//                this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
                }

                // Delete for backtracking.
                expression.deleteCharAt(length);
            }
        }

        public List<String> removeInvalidParentheses(String s) {

            int left = 0, right = 0;

            // First, we find out the number of misplaced left and right parentheses.
            for (int i = 0; i < s.length(); i++) {

                // Simply record the left one.
                if (s.charAt(i) == '(') {
                    left++;
                } else if (s.charAt(i) == ')') {
                    // If we don't have a matching left, then this is a misplaced right, record it.
                    right = left == 0 ? right + 1 : right;

                    // Decrement count of left parentheses because we have found a right
                    // which CAN be a matching one for a left.
                    left = left > 0 ? left - 1 : left;
                }
            }

            this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
            return new ArrayList<String>(this.validExpressions);
        }
    }
}