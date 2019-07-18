package edu.nyu.jolyon;

import javafx.util.Pair;

import java.util.*;

class LC127WordLadder {
    static class Solution{

        private int L;
        private HashMap<String, ArrayList<String>> allComboDict;

        Solution() {
            this.L = 0;

            // Dictionary to hold combination of words that can be formed,
            // from any given word. By changing one letter at a time.
            this.allComboDict = new HashMap<String, ArrayList<String>>();
        }

        private int visitWordNode(
                Queue<Pair<String, Integer>> Q,
                HashMap<String, Integer> visited,
                HashMap<String, Integer> othersVisited) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < this.L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (othersVisited.containsKey(adjacentWord)) {
                        return level + othersVisited.get(adjacentWord);
                    }

                    if (!visited.containsKey(adjacentWord)) {

                        // Save the level as the value of the dictionary, to save number of hops.
                        visited.put(adjacentWord, level + 1);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
            return -1;
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if (!wordList.contains(endWord)) {
                return 0;
            }

            // Since all words are of same length.
            this.L = beginWord.length();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < L; i++) {
                            // Key is the generic word
                            // Value is a list of words which have the same intermediate generic word.
                            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                            ArrayList<String> transformations =
                                    this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
                            transformations.add(word);
                            this.allComboDict.put(newWord, transformations);
                        }
                    });

            // Queues for birdirectional BFS
            // BFS starting from beginWord
            Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
            // BFS starting from endWord
            Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
            Q_begin.add(new Pair(beginWord, 1));
            Q_end.add(new Pair(endWord, 1));

            // Visited to make sure we don't repeat processing same word.
            HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
            HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
            visitedBegin.put(beginWord, 1);
            visitedEnd.put(endWord, 1);

            while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

                // One hop from begin word
                int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
                if (ans > -1) {
                    return ans;
                }

                // One hop from end word
                ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
                if (ans > -1) {
                    return ans;
                }
            }

            return 0;
        }

    }
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
                                    visited.add(next_word);
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
