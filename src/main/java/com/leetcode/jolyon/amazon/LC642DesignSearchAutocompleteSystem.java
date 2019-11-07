package com.leetcode.jolyon.amazon;

import java.util.*;

public class LC642DesignSearchAutocompleteSystem {
    class AutocompleteSystem {
        TrieNode root;
        Map<String, Integer> hotMap;
        TrieNode cur;
        StringBuilder sb = new StringBuilder();

        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            cur = root;
            hotMap = new HashMap<>();
            for (int i = 0; i < sentences.length; i++) {
                String s = sentences[i];
                char[] arr = s.toCharArray();
                TrieNode node = root;
                for (char c : arr) {
                    node.next.putIfAbsent(c, new TrieNode());
                    node = node.next.get(c);
                }
                node.sentence = s;
                node.hot = times[i];
            }
        }

        public List<String> input(char c) {
            List<String> res = new ArrayList<>();
            if (c == '#') {
                cur.hot += 1;
                cur.sentence = sb.toString();
                sb = new StringBuilder();
                cur = root;
            } else {
                sb.append(c);
                cur.next.putIfAbsent(c, new TrieNode());
                cur = cur.next.get(c);
                res = lookup(cur);
            }
            return res;
        }

        List<String> lookup(TrieNode node) {
            Queue<TrieNode> q = new LinkedList<>();
            List<String> res = new ArrayList<>();
            PriorityQueue<TrieNode> pq = new PriorityQueue<>((TrieNode w1,
                                                              TrieNode w2) -> {
                if (w1.hot == w2.hot) {
                    return w1.sentence.compareTo(w2.sentence);
                } else {
                    return w2.hot - w1.hot;
                }
            });
            q.add(node);
            while (!q.isEmpty()) {
                TrieNode tmp = q.poll();
                if (tmp.hot > 0) {
                    pq.add(tmp);
                }
                for (TrieNode nei : tmp.next.values()) {
                    q.add(nei);
                }
            }
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(pq.poll().sentence);
            }
            return res;
        }

        class TrieNode {
            Map<Character, TrieNode> next;
            String sentence;
            int hot;
            List<String> prefixSetences;

            public TrieNode() {
                this.hot = 0;
                this.sentence = null;
                this.next = new HashMap<>();
                this.prefixSetences = new ArrayList<>();
            }
        }
    }
}
