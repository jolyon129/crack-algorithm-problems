package com.leetcode.jolyon;

public class GoogleMaxFont {
    public int getWidth(char c, int fontSize) {
        return 0;
    }

    public int getHeight(int fontSize) {
        return 0;
    }

    public boolean isValid(String str, int W, int H, int fontSize) {
        int countWidth = 0;
        int countHeight = 0;
        int fontWidth;
        int fontHeight = getHeight(fontSize);
        int i = 0;
        if (fontHeight > H) return false;
        countHeight += fontHeight;
        while (i < str.length()) {
            // Add space!
            while (i < str.length() && str.charAt(i) == ' ') {
                fontWidth = getWidth(str.charAt(i), fontSize);
                if (fontWidth > W) return false;
                if (fontWidth + countWidth <= W) {
                    countWidth += fontWidth;
//                    i++;
                } else {
                    countHeight += fontHeight;
                    countWidth = fontWidth;
                    if (countHeight > H) return false;
                }
                i++;
            }
            // Add non-whitespace characters
            int wordLen = 0;
            while (i < str.length() && str.charAt(i) != ' ') {
                fontWidth = getWidth(str.charAt(i), fontSize);
                wordLen += fontWidth;
                i++;
            }
            // If current word exceed the width
            if ( wordLen > W) return false;
            if (countWidth + wordLen <= W) {
                countWidth += wordLen;
            } else {
                countHeight += fontHeight;
                if (countHeight > H) return false;
                countWidth = wordLen;
            }
        }
        return true;
    }

    public int search(String str, int W, int H, int MIN, int MAX) {
        if (str == null || str.length() == 0) {
            return MAX;
        }
        int left = MIN;
        int right = MAX;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (isValid(str, W, H, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isValid(str, W, H, right)) {
            return right;
        }
        if(isValid(str,W,H,left)){
            return left;
        }
        // If cannot fit any character
        return -1;
    }

}
