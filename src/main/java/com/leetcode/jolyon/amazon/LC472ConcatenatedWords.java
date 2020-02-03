package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC472ConcatenatedWords {
    class Solution1 {

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> list = new ArrayList<>();
            Set<String> dictionary = new HashSet<>();
            for (String string : words) dictionary.add(string);
            for (String word : words) {
                dictionary.remove(word);
                if (check(word, dictionary)) list.add(word);
                dictionary.add(word);
            }
            return list;
        }

        // word break
        private boolean check(String word, Set<String> dictionary) {
            boolean[] dp = new boolean[word.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    String temp = word.substring(j, i);
                    if (dp[j] && dictionary.contains(temp)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[word.length()];

        }

    }

    class Solution2 {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res = new ArrayList<String>();
            if (words == null || words.length == 0) {
                return res;
            }
            TrieNode root = new TrieNode();
            for (String word : words) { // construct Trie tree
                if (word.length() == 0) {
                    continue;
                }
                addWord(word, root);
            }
            for (String word : words) { // test word is a concatenated word or not
                if (word.length() == 0) {
                    continue;
                }
                if (testWord(word.toCharArray(), 0, root, 0)) {
                    res.add(word);
                }
            }
            return res;
        }

        public boolean testWord(char[] chars, int index, TrieNode root, int count) { // count means how many words during the search path
            TrieNode cur = root;
            int n = chars.length;
            for (int i = index; i < n; i++) {
                if (cur.sons[chars[i] - 'a'] == null) {
                    return false;
                }
                if (cur.sons[chars[i] - 'a'].isEnd) {
                    if (i == n - 1) { // no next word, so test count to get result.
                        return count >= 1;
                    }
                    if (testWord(chars, i + 1, root, count + 1)) {
                        return true;
                    }
                }
                cur = cur.sons[chars[i] - 'a'];
            }
            return false;
        }

        public void addWord(String str, TrieNode root) {
            char[] chars = str.toCharArray();
            TrieNode cur = root;
            for (char c : chars) {
                if (cur.sons[c - 'a'] == null) {
                    cur.sons[c - 'a'] = new TrieNode();
                }
                cur = cur.sons[c - 'a'];
            }
            cur.isEnd = true;
        }
    }

    class TrieNode {
        TrieNode[] sons;
        boolean isEnd;

        public TrieNode() {
            sons = new TrieNode[26];
        }
    }
}
