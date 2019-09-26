package com.leetcode.jolyon;

public class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode(-1);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int child = word.charAt(i) - 'a';
            if (node.links[child] == null) {
                node.links[child] = new TrieNode(child);
            }
            node = node.links[child];
        }
        node.isAWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int child = word.charAt(i) - 'a';
            if (node.links[child] == null) {
                return false;
            }
            node = node.links[child];
            if (i == word.length() - 1 && node.isAWord) {
                return true;
            }
        }
        return false;

    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int child = prefix.charAt(i) - 'a';
            if (node.links[child] == null) return false;
            node = node.links[child];
        }
        return true;
    }

    class TrieNode {
        TrieNode[] links;
        int value;
        boolean isAWord;

        TrieNode(int value) {
            links = new TrieNode[26];
            this.value = value;
            this.isAWord = false;
        }

    }

}