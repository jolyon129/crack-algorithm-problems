package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC425WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if(words.length<words[0].length()) return ans;
        LittleTrie trie = new LittleTrie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> curr = new ArrayList<>();
        backtrack("", trie, ans, curr);
        return ans;
    }

    /**
     * Given a prefix, find the suitable words and try to move to the next state
     *
     * @param prefix
     * @param trie
     * @param ans
     * @param currentWordSquare
     */
    void backtrack(String prefix, LittleTrie trie,
                   List<List<String>> ans,
                   List<String> currentWordSquare) {
        List<String> words = trie.searchWithPrefix(prefix);
        if (words == null) return;
        for (String word : words) {
            currentWordSquare.add(word);
            if (!currentWordSquare.isEmpty() && (currentWordSquare.size() == currentWordSquare.get(0).length())) {
                // We create a new ArrayList
                ans.add(new ArrayList<>(currentWordSquare));
            }else{
                StringBuilder newPrefix = new StringBuilder();
                for (String s : currentWordSquare) {
                    int n = currentWordSquare.size();
                    newPrefix.append(s.charAt(n));
                }
                backtrack(newPrefix.toString(), trie, ans, currentWordSquare);
            }
            currentWordSquare.remove(currentWordSquare.size() - 1);
        }
    }
}

class LittleTrie {

    TrieNode root;

    LittleTrie() {
        this.root = new TrieNode(-1);
    }

    void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (node.branches[c] == null) {
                node.branches[c] = new TrieNode(c);
            }
            node.words.add(word);
            node = node.branches[c];
        }
        node.isAWord = true;
        node.words.add(word);
    }

    List<String> searchWithPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.branches[prefix.charAt(i) - 'a'] == null) {
                return null;
            }
            node = node.branches[prefix.charAt(i) - 'a'];
        }
        List<String> res = new ArrayList<>();
        res.addAll(node.words);
        return res;
    }
}

class TrieNode {
    TrieNode[] branches;
    int value;
    boolean isAWord;
    List<String> words;

    TrieNode(int value) {
        this.branches = new TrieNode[26];
        this.value = value;
        this.isAWord = false;
        this.words = new ArrayList<>();
    }
}