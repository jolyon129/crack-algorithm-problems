package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC792NumberofMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word : words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c : S.toCharArray()) {
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node : old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }
    class Node {
        String word;
        int index;
        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }


    public int numMatchingSubseq2(String S, String[] words) {
        int ans = 0;
        List<StringBuilder>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList();
        for (String w : words)
            waiting[w.charAt(0)].add(new StringBuilder(w));

        for (char c : S.toCharArray()) {
            List<StringBuilder> advance = waiting[c];

            waiting[c] = new ArrayList();

            for (StringBuilder it : advance){
                it.deleteCharAt(0);
                if(it.length() != 0)
                    waiting[it.charAt(0)].add(it);
                else
                    ans++;
            }
        }
        return ans;
    }

}
