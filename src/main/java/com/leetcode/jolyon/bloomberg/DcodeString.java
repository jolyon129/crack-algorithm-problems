package com.leetcode.jolyon.bloomberg;

public class DcodeString {
    private int position = 0;
    public String decodeString(String s) {
        return recur(s, 1).toString();

    }

    private StringBuilder recur(String s, int factor) {
        StringBuilder letters = new StringBuilder();
        StringBuilder next_factor = new StringBuilder();
        while (position<s.length()){
            char c = s.charAt(position);
            if(c=='['){
                position++;
                letters.append(recur(s, Integer.parseInt(next_factor.toString())));
                // IMPORTANT! RESET THE VALUE!
                next_factor = new StringBuilder();
            }else if(c==']'){
                StringBuilder sb = new StringBuilder();
                while (factor>0){
                    sb.append(letters);
                    factor--;
                }
                position++;
                return sb;
            }else if(Character.isDigit(c)){
                next_factor.append(c);
                position++;
            }else{
                letters.append(c);
                position++;
            }

        }
        /**
         * The outmost recur ends when it reach the end of the string
         */
        return letters;
    }
}
