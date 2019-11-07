package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.List;

public class LC212WordSearchII {
    static class Solution1 {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, root, res);

                }
            }
            return res;
        }

        public void dfs(char[][] board, int i, int j, TrieNode parent, List<String> res) {
            char c = board[i][j];

            if (parent.next[c - 'a'] == null) return;
            parent = parent.next[c - 'a'];
            if (parent.word != null) {   // found one
                res.add(parent.word);
                parent.word = null;     // de-duplicate
            }

            board[i][j] = '#';
            int[] dr = new int[]{0, 0, 1, -1};
            int[] dc = new int[]{1, -1, 0, 0};
            for (int t = 0; t < 4; t++) {
                int newR = i + dr[t];
                int newC = j + dc[t];
                // when c=='#', visited twice
                if (newR >= 0 && newC >= 0 && newC < board[0].length
                        && newR < board.length && board[newR][newC] != '#') {
                    dfs(board, newR, newC, parent, res);
                }
            }
            board[i][j] = c;
        }

        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode('0');
            for (String w : words) {
                TrieNode p = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (p.next[i] == null) p.next[i] = new TrieNode(c);
                    p = p.next[i];
                }
                p.word = w;
                p.isAWord = true;
            }
            return root;
        }

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
            char value;
            boolean isAWord;

            TrieNode(char c) {
                this.value = c;
            }
        }
    }

    static class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, root, res);
                }
            }
            return res;
        }

        public void dfs(char[][] board, int i, int j, TrieNode parent, List<String> res) {
            char c = board[i][j];
            // when c=='#', visited twice
            if (c == '#' || parent.next[c - 'a'] == null) return;
            parent = parent.next[c - 'a'];
            if (parent.word != null) {   // found one
                res.add(parent.word);
                parent.word = null;     // de-duplicate
            }

            board[i][j] = '#';
            if (i > 0) dfs(board, i - 1, j, parent, res);
            if (j > 0) dfs(board, i, j - 1, parent, res);
            if (i < board.length - 1) dfs(board, i + 1, j, parent, res);
            if (j < board[0].length - 1) dfs(board, i, j + 1, parent, res);
            // backtracking!
            board[i][j] = c;
        }

        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String w : words) {
                TrieNode p = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (p.next[i] == null) p.next[i] = new TrieNode();
                    p = p.next[i];
                }
                p.word = w;
            }
            return root;
        }

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }
    }

}



