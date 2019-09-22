package com.leetcode.jolyon;

import java.util.Stack;

public class CitrixPrefixToPostfix {
    static class GFG {
        static boolean isOperator(char x) {
            if(x=='+'||x=='-'||x=='/'||x=='*'){
                return true;
            }else{
                return false;
            }
        }

        static String preToPost(String str) {

            Stack<String> s = new Stack<>();

            int N = str.length();

            for (int i = N - 1; i >= 0; i--) {
                if (isOperator(str.charAt(i))) {
                    String op1 = s.pop();
                    String op2 = s.pop();
                    String temp = op1 + op2 + str.charAt(i);
                    s.push(temp);
                }
                else {
                    s.push(str.charAt(i) + "");
                }
            }
            return s.peek();
        }

        public static void main(String args[]) {
            String pre_exp = "*-A/BC-/AKL";
            System.out.println("Postfix : " + preToPost(pre_exp));
        }
    }
}
