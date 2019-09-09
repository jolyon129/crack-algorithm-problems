package com.leetcode.jolyon;

public class LC43MultiplyStrings {
    public String multiply(String num1, String num2) {
        int M = num1.length();
        int N = num2.length();
        int[] val = new int[M + N];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + val[i + j + 1];
                val[i + j + 1] = tmp % 10;
                val[i + j] += tmp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : val) {
            if (sb.length() != 0 || v != 0) {
                sb.append(v);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
