package com.leetcode.jolyon.bloomberg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // calculate frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        // build the buckets
        TrieNode[] count = new TrieNode[words.length + 1];
        for (String word : freqMap.keySet()) {
            int freq = freqMap.get(word);
            if (count[freq] == null) {
                count[freq] = new TrieNode();
            }
            addWord(count[freq], word);
        }
        // get k frequent words
        List<String> list = new LinkedList<>();
        for (int f = count.length - 1; f >= 1 && list.size() < k; f--) {
            if (count[f] == null) continue;
            getWords(count[f], list, k);
        }
        return list;
    }

    private void getWords(TrieNode node, List<String> list, int k) {
        if (node == null) return;
        if (node.word != null) {
            list.add(node.word);
        }
        if (list.size() == k) return;
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                getWords(node.child[i], list, k);
            }
        }
    }

    private boolean addWord(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                curr.child[c - 'a'] = new TrieNode();
            }
            curr = curr.child[c - 'a'];
        }
        curr.word = word;
        return true;
    }

    class TrieNode {
        TrieNode[] child;
        String word;

        TrieNode() {
            this.child = new TrieNode[26];
            this.word = null;
        }
    }
}
