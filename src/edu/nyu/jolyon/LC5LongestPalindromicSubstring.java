package edu.nyu.jolyon;

public class LC5LongestPalindromicSubstring {
    private int lo=0, maxLen=1;
    private void expand(String s, int left, int right) {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(maxLen<right-left-1){
            lo = left+1;
            maxLen = right-left-1;
        }
    }
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        for(int i=0;i<s.length()-1;i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(lo,lo+maxLen);
    }

}
