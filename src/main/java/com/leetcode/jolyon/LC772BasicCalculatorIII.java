package com.leetcode.jolyon;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-iii/discuss/?currentPage=1&orderBy=most_votes&query=

public class LC772BasicCalculatorIII {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>(); // the stack that stores numbers
        Stack<Character> ops = new Stack<>(); // the stack that stores operators (including parentheses)
        boolean firstChar = true; // deal with -2+1 where first is a negative
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (firstChar) {
                if (c == '-') {
                    nums.push(0);
                }
                firstChar = false;
            }
            if (Character.isDigit(c)) {
                num = c - '0';
                // iteratively calculate each number
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0; // reset the number to 0 before next calculation
            } else if (c == '(') {
                firstChar = true;
                ops.push(c);
            } else if (c == ')') {
                // do the math when we encounter a ')' until '('
                while (ops.peek() != '(')
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                ops.pop(); // get rid of '(' in the ops stack
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // If the top of ops stack have higher higherPrecedence over the
                // current one, evaluate the top first.
                while (!ops.isEmpty() && higherPrecedence(c, ops.peek()))
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            // Evaluate in reversing order
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b; // assume b is not 0
        }
        return 0;
    }

    // helper function to check higherPrecedence of current operator and the uppermost operator in the ops stack
    // Returns true if 'op2' has higher or same higherPrecedence as 'op1',
    // otherwise returns false.
    private static boolean higherPrecedence(char op1, char op2) {
        if (op2 == '(' ) return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }
}
