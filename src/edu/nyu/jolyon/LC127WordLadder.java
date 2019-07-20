package edu.nyu.jolyon;

import javafx.util.Pair;

import java.util.*;

class LC127WordLadder {
    static class MySolution{
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordDict = new HashSet<>(wordList), frontQueue= new HashSet<>(),
            backQueue = new HashSet<>(), visited= new HashSet<>();
            if(!wordDict.contains(endWord)) return 0;
            frontQueue.add(beginWord);
            backQueue.add(endWord);
            visited.add(beginWord);
            visited.add(endWord);
            // Start from 1
            int level_depth = 1;
            // Do level traversal!
            while (!frontQueue.isEmpty()){
                HashSet<String> nextQueue = new HashSet<>();
                level_depth++;
                visited.addAll(frontQueue);
                for (String s:frontQueue){
                    char[] chr_arr = s.toCharArray();
                    for(int i=0;i<chr_arr.length;i++){
                        for(char c='a';c<='z';c++){
                            char old_char = chr_arr[i];
                            if(chr_arr[i]!=c){
                                chr_arr[i] = c;
                                String next_word = String.valueOf(chr_arr);
                                if(backQueue.contains(next_word)){
                                    return level_depth;
                                }
                                if(wordDict.contains(next_word)&&!visited.contains(next_word)){
                                    nextQueue.add(next_word);
//                                    visited.add(next_word);
                                }
                            }
                            chr_arr[i] = old_char;
                        }
                    }
                }
                // Drop the original Queue
                frontQueue = nextQueue;
                // If backQueue has less nodes, we prefer to travel over backQueue.
                // Hence, swap the front and the back.
                if(backQueue.size()<frontQueue.size()){
                    HashSet<String> tmp = frontQueue;
                    frontQueue = backQueue;
                    backQueue = tmp;
                }
            }
            return 0;

        }
    }
}
