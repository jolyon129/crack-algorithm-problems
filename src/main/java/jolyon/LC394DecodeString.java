package com.leetcode.jolyon;

public class LC394DecodeString {
    private int position=0;
    public String decodeString(String s) {
        return recursion(s,1);
    }
    private String recursion(String s, int factor){
        StringBuilder next_factor= new StringBuilder();
        StringBuilder letters = new StringBuilder();
        for(int i=position;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!='['&&s.charAt(i)!=']'){
                letters.append(s.charAt(i));
            }else if(Character.isDigit(s.charAt(i))){
                next_factor.append(s.charAt(i));
            }
            else if(s.charAt(i)=='['){
                position = i+1;
                letters.append(recursion(s, Integer.parseInt(next_factor.toString())));
                // Very Important!!
                // Re-count the factor!
                next_factor = new StringBuilder();
                i = position;
            }else if(s.charAt(i)==']'){
                StringBuilder new_sb = new StringBuilder();
                while(factor>0){
                    new_sb.append(letters.toString());
                    factor--;
                }
                // DO NOT ADD ONE!
//                position = i +1;
                position = i;
                return new_sb.toString();
            }
        }
        /**
         * The outmost recursion ends when it reach the end of the string
         */
        return letters.toString();
    }
}
