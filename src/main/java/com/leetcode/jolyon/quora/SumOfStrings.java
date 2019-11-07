package com.leetcode.jolyon.quora;

public class SumOfStrings {
    String solve(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int t = n1 + n2;
            if (t > 9) {
                sb.insert(0, t % 10);
                sb.insert(0, t / 10);
            } else {
                sb.insert(0, t);
            }
            i--;
            j--;
        }
        if (i > 0) {
            sb.insert(0, num1.substring(0, i + 1));
        }
        if (j > 0) {
            sb.insert(0, num2.substring(0, j + 1));
        }
        return sb.toString();
    }
}
