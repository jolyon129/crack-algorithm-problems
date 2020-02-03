package com.leetcode.jolyon.impact;

import java.util.Stack;

/**
 * I'm assuming we need to remove all consecutive duplicate characters and
 * we should remove in the order from left to right. eg. For
 * an input, "acaabbacdeedd", we should return "acac" instead of "a" because
 * the order of removing is from left to right.
 * <p>
 * There are two ways to solve this. I personally prefer the iterative solution
 * because I don't need extra space for the recursion, and the iterative one
 * should be faster because I don't use String.substr()
 */
public class GoodString {

    /**
     * Use stack to store the characters without consecutive duplicates. At each
     * index, compare the current idx with the head of stack, if they are same,
     * stack.peek() and do not add the current char into our stack. This
     * solution takes O(N) time and space, and I prefer this one because I don't
     * need extra space for the recursion, and this should be faster because I
     * don't use String.substr()
     *
     * @param str input
     * @return return a good string
     */
    static String iterativelyConvert(String str) {
        if (str.length() == 0 || str.length() == 1) return str;
        Stack<Character> stack = new Stack<>();
        char[] strChars = str.toCharArray();
        int i = 0, starIdx;
        while (i < strChars.length) {
            starIdx = i;
            // Find the rightmost index of the same character.
            while (i + 1 < str.length() && strChars[i + 1] == strChars[starIdx]) {
                i++;
            }
            if (!stack.isEmpty() && stack.peek() == strChars[i]) {
                stack.pop();
            } else if (i == starIdx) {
                stack.add(strChars[i]);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }

    /**
     * The idea is to recursively remove consecutive duplicate characters. The
     * time complexity is O(N) if we ignore the time of String.substr(). The
     * substr() itself will take O(N) time. The space complexity is O(N).
     *
     * @param str input
     * @return return a good string
     */
    static String recursivelyConvert(String str) {
        if (str.length() == 0 || str.length() == 1) return str;
        int i = 0, startIdx;
        while (i < str.length()) {
            startIdx = i;
            while (i + 1 < str.length() && str.charAt(i + 1) == str.charAt(startIdx)) {
                i++;
            }
            if (startIdx < i) {
                return recursivelyConvert(str.substring(0, startIdx) + str.substring(i + 1));
            }
            i++;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(recursivelyConvert("aa"));
        System.out.println(recursivelyConvert("aabcddce"));
        System.out.println(iterativelyConvert("acaabbacdeedd"));
        System.out.println(recursivelyConvert("acaabbacdeedd"));
        System.out.println(iterativelyConvert("aabcddce"));
        System.out.println(recursivelyConvert("adddd"));
        System.out.println(iterativelyConvert("aa"));
    }
}
