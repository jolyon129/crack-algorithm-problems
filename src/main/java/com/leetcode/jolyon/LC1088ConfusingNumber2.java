package com.leetcode.jolyon;

public class LC1088ConfusingNumber2 {
    static char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public int confusingNumberII(int N) {
        String num = Integer.toString(N);
        int res = findTotal(num);
        for (int len = 1; len <= num.length(); len++) {
            char[] curr = new char[len];
            res -= dfs(curr, num, 0, len - 1);
        }
        return res;
    }
    // countDigitSmaller the # of numbers from "01689" that is less than N
    public int findTotal(String s) {
        // Inclusive, we need add itself
        if (s.length() == 0) return 1;
        char first = s.charAt(0);
        int res = countDigitSmaller(first) * (int) (Math.pow(5, s.length() - 1));
        // if the first digit is a one of the `0,1,6,9,8`, then we try to
        // find the numbers with that as first digit.
        if (first == '0' || first == '1' || first == '6' || first == '8' || first == '9') {
            res += findTotal(s.substring(1));
        }
        return res;
    }
    // countDigitSmaller the # of Strobogrammatic numbers
    public int dfs(char[] curr, String num, int left, int right) {
        int res = 0;
        if (left > right) {
            String s = new String(curr);
            if (s.length() < num.length() || s.compareTo(num) < 0) {
                res += 1;
            }
        } else {
            for (char[] p : pairs) {
                curr[left] = p[0];
                curr[right] = p[1];
                if ((curr[0] == '0' && curr.length > 1) || (left == right && p[0] != p[1])) continue;
                res += dfs(curr, num, left + 1, right - 1);
            }
        }
        return res;
    }
    // a helper function that counts the # of chars in "01689" less than given 'c'
    private int countDigitSmaller(Character c) {
        int res = 0;
        for (char[] p : pairs) {
            if (p[0] < c) res += 1;
        }
        return res;
    }
}