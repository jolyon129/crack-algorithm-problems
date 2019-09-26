package com.leetcode.jolyon;

public class LC211AddandSearchWord {
    static class WordDictionary {
        Trie trie;
        /** Initialize your data structure here. */
        public WordDictionary() {
            trie = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            trie.insert(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            Trie.TrieNode node = trie.root;
            if(word.charAt(0)!='.'){
                return recur(word,0,node.links[word.charAt(0)-'a']);
            }else{
                for(int i=0;i<26;i++){
                    if(recur(word, 0,node.links[i])){
                        return true;
                    }
                }
                return false;
            }
        }

        private boolean recur(String word, int idx, Trie.TrieNode node){
            if(node==null) return false;
            if(idx==word.length()-1&&node.isAWord){
                return true;
            }
            if(idx==word.length()-1&&!node.isAWord){
                return false;
            }
            if(word.charAt(idx+1)!='.'){
                node= node.links[word.charAt(idx+1)-'a'];
                return recur(word,idx+1,node);
            }else{
                for(int i=0;i<26;i++){
//                    int startIdx = idx;
                    if(recur(word, idx+1,node.links[i])){
                        return true;
                    }
//                    idx = startIdx;
                }
                return false;
            }
        }
    }
}
