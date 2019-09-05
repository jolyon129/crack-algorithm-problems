package com.leetcode.jolyon;

import java.util.*;

public class LC248StrobogrammaticNumber2 {
    static class TediousSolution {
        public List<String> findStrobogrammatic(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                res.add("");
                return res;
            }
            int lo, hi;
            // Deque<Character> middle = new ArrayDeque<>();
            List<Deque<Character>> intermediate = new ArrayList<>();
            if (n % 2 == 0) {
                lo = n / 2 - 1;
                hi = n / 2;
                intermediate.add(new ArrayDeque<>());
            } else {
                lo = n / 2 - 1;
                hi = n / 2 + 1;
                char[] numbers = new char[]{'0', '8', '1'};
                for (int i = 0; i < 3; i++) {
                    Deque<Character> mid = new ArrayDeque<>();
                    mid.add(numbers[i]);
                    intermediate.add(mid);
                }
            }
            while (lo >= 0) {
                List<Deque<Character>> path = new ArrayList<>();
                for (Deque<Character> middle : intermediate) {
                    path.addAll(generate(middle, lo));
                }
                lo = lo - 1;
                intermediate = path;
            }
            for (Deque<Character> k : intermediate) {
                StringBuilder sb = new StringBuilder();
                for (Character c : k) {
                    sb.append(c);
                }
                res.add(sb.toString());
            }
            return res;
        }

        private List<Deque<Character>> generate(Deque<Character> middle, int lo) {
            char[] numbers = new char[]{
                    '0', '6', '8', '9', '1'
            };
            List<Deque<Character>> res = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == '0') {
                    if (lo == 0) {
                        continue;
                    } else {
                        Deque<Character> tmp = new ArrayDeque<>(middle);
                        tmp.addFirst('0');
                        tmp.addLast('0');
                        res.add(tmp);
                    }
                } else if (numbers[i] == '6' || numbers[i] == '9') {
                    Deque<Character> tmp = new ArrayDeque<>(middle);
                    tmp.addFirst(numbers[i]);
                    tmp.addLast(numbers[i] == '6' ? '9' : '6');
                    res.add(tmp);
                } else {
                    Deque<Character> tmp = new ArrayDeque<>(middle);
                    tmp.addFirst(numbers[i]);
                    tmp.addLast(numbers[i]);
                    res.add(tmp);
                }

            }
            return res;
        }
    }

    static class Solution {
        public List<String> findStrobogrammatic(int n) {
            List<String> cur, ans;
            ans = new ArrayList<String>((n & 1) == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
            if (n < 2) return ans;

            for (; n > 1; n -= 2) {
                cur = ans;
                ans = new ArrayList<String>();
                for (String i : cur) {
                    if (n > 3) ans.add('0' + i + '0');
                    ans.add('1' + i + '1');
                    ans.add('8' + i + '8');
                    ans.add('6' + i + '9');
                    ans.add('9' + i + '6');
                }
            }

            return ans;
        }
    }
}
