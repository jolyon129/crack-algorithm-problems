package com.leetcode.jolyon;

public class LC394DecodeString {
    private int position = 0;
    StringBuilder next_factor = new StringBuilder();
    public String decodeString(String s) {
        return recur(s, 1);
    }

    private String recur(String s, int factor) {
        StringBuilder letters = new StringBuilder();
        for (int i = position; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '[' && s.charAt(i) != ']') {
                letters.append(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                next_factor.append(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                position = i + 1;
                letters.append(recur(s, Integer.parseInt(next_factor.toString())));
                // Very Important!!
                // Re-count the factor!
                next_factor = new StringBuilder();
                i = position; // break the for loop.
            } else if (s.charAt(i) == ']') {
                StringBuilder new_sb = new StringBuilder();
                while (factor > 0) {
                    new_sb.append(letters.toString());
                    factor--;
                }
                position = i;
                return new_sb.toString();
            }
        }
        /**
         * The outmost recur ends when it reach the end of the string
         */
        return letters.toString();
    }
    static class solve{
        private int position = 0;
        StringBuilder next_factor = new StringBuilder();
        public String decodeString(String s) {
            return recur(s, 1).toString();

        }

        private StringBuilder recur(String s, int factor) {
            StringBuilder letters = new StringBuilder();
            while (position<s.length()){
                char c = s.charAt(position);
                if(c=='['){
                    position++;
                    letters.append(recur(s, Integer.parseInt(next_factor.toString())));
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
}
