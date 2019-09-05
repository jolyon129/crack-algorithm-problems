package com.leetcode.jolyon;

public class LC8StringtoInteger {
    public int myAtoi(String str) {
        int idx = 0;
        int sign = 1;
        int total = 0;
        int digit = 0;
        if(str.length()==0){
            return 0;
        }
        while (idx < str.length()&&str.charAt(idx) == ' ' ) {
            idx++;
        }
        if (idx<str.length()&&(str.charAt(idx) == '+' || str.charAt(idx) == '-')) {
            sign = str.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }
        while (idx < str.length()) {

            if (!Character.isDigit(str.charAt(idx))) {
                break;
            }
            digit = str.charAt(idx)-'0';
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            idx++;
        }
        return total*sign;
    }
}
