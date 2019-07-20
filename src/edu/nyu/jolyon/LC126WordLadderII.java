package edu.nyu.jolyon;

import java.util.*;

public class LC126WordLadderII {
    private HashSet<String> wordDict;
    private HashSet<String> visited;
    private HashMap<String, ArrayList<String>> graph = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> frontset = new HashSet<>(), backset = new HashSet<>();
        wordDict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        frontset.add(beginWord);
        backset.add(endWord);
        while (!frontset.isEmpty() && !backset.isEmpty()) {
            if (frontset.size() <= backset.size()) {
                frontset = travel1level(frontset, backset, false);
            } else {
                backset = travel1level(backset, frontset, true);
            }
        }
        ArrayList<String> test = new ArrayList<>();
        test.add(beginWord);
        DFS(beginWord, endWord,test , result);
        return result;
    }

    private HashSet<String> travel1level(HashSet<String> bfs_set, Set another_set, boolean flip) {
        boolean done = false;
        HashSet<String> next_set = new HashSet<>();
        /**
         * Must check visited items here!!!!!!!
         * I DONT KNOW WHY !!!
         * Add all the items in our queue to visted!
         * */
        visited.addAll(bfs_set);
        visited.addAll(another_set);
//        wordDict.removeAll(bfs_set);
//        wordDict.removeAll(another_set);
        for (String s : bfs_set) {
//            visited.add(s);
            char[] char_arr = s.toCharArray();
            for (int i = 0; i < char_arr.length; i++) {
                char old_c = char_arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (char_arr[i] != c) {
                        char_arr[i] = c;
                        String new_word = String.valueOf(char_arr);
                        /**
                         * There are two cases we need to draw an edge
                         * 1. If two BFS tree meet
                         * 2. If two BS tree don't meet, but keep growing
                         */
                        String key = flip ? new_word : s;
                        String value = flip ? s : new_word;
                        if (another_set.contains(new_word)) {
                            done = true;
                            if (!graph.containsKey(key)) {
                                graph.put(key, new ArrayList<String>());
                            }
                            graph.get(key).add(value);
                        }
                        if (!done && (wordDict.contains(new_word) && !visited.contains(new_word))) {
                            if (!graph.containsKey(key)) {
                                graph.put(key, new ArrayList<String>());
                            }
                            graph.get(key).add(value);
//                            visited.add(new_word);
                            next_set.add(new_word);
                        }
                        // Restore the char_arr
                        char_arr[i] = old_c;
                    }
                }
            }
        }
        if (done) {
            return new HashSet<>();
        }
//        visited.addAll(next_set);
        return next_set;
    }

    private void DFS(String beginWord, String endWord, ArrayList<String> currentArr, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(currentArr));
            return;
        }
        if (!graph.containsKey(beginWord)) {
            return;
        }
        for (String nei : graph.get(beginWord)) {
             currentArr.add(nei);
            DFS(nei, endWord, currentArr, result);
            currentArr.remove(currentArr.size() - 1);
        }

    }
}
