package com.leetcode.jolyon;

public class LC246StrobogrammaticNumber {
    class Solution {
        public boolean isStrobogrammatic(String num) {
            if(num.length()==0){
                return false;
            }
            return validate(0, num.length() - 1, num);
        }

        private boolean validate(int l, int r, String num) {
            if (l > r) {
                return true;
            }
            else if (l == r) {
                int left = num.charAt(l) - '0';
                int right = num.charAt(r) - '0';
                if (left == 8 || left == 1 || left == 0) return true;
                else return false;
            } else {
                int left = num.charAt(l) - '0';
                int right = num.charAt(r) - '0';
                if ((left == 9 && right == 6) || (left == 6 && right == 9)) {
                    return validate(l + 1, r -1, num);
                } else if (left == right && (left == 8 || left == 1 || left == 0)) {
                    return validate(l + 1, r -1, num);
                } else {
                    return false;
                }
            }
        }

    }
}
