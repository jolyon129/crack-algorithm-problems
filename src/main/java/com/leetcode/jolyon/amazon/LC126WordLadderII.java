package com.leetcode.jolyon.amazon;

import java.util.*;

public class LC126WordLadderII {

    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<String> path = new ArrayList<>();
            List<List<String>> result = new ArrayList<List<String>>();
            HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
            HashSet<String> dict = new HashSet<>(wordList);
            buildGraph(beginWord, endWord, graph, dict);
            dfs(beginWord, endWord, graph, path, result);
            return result;
        }

        private void buildGraph(String beginWord, String endWord, HashMap<String, List<String>> graph, HashSet<String> dict) {
            HashSet<String> visited = new HashSet<>();
            HashSet<String> toVisit = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            toVisit.add(beginWord);
            boolean foundEnd = false;

            while (!queue.isEmpty()) {
                // Add all front elements into visited
                visited.addAll(toVisit);
                // Reset toVisit!
                toVisit.clear();
                int count = queue.size();

                for (int i = 0; i < count; i++) {
                    String word = queue.poll();
                    List<String> children = getNextLevel(word, dict);
                    for (String child : children) {
                        if (child.equals(endWord)) foundEnd = true;
                        if (!graph.containsKey(word)) {
                            graph.put(word, new ArrayList<String>());
                        }
                        /**
                         *  We need to print all possible shortest paths,
                         *  that's to say, if two words in the same level
                         *  ending up generating the same word, we need to
                         *  make sure the edges include those two edge!
                         */
                        if (!visited.contains(child)) {
                            graph.get(word).add(child);
                        }
                        /**
                         *  But we don't want our queue have duplicates words!
                         */
                        if (!visited.contains(child) && !toVisit.contains(child)) {
                            queue.offer(child);
                            toVisit.add(child);
                        }
                    }
                }
                // If we found the target at the end of the current level, we
                // finish building out graph
                if (foundEnd) break;
            }
        }

        private List<String> getNextLevel(String word, HashSet<String> dict) {
            List<String> result = new ArrayList<>();
            char[] chs = word.toCharArray();

            for (int i = 0; i < chs.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chs[i] == c) continue;
                    char t = chs[i];
                    chs[i] = c;
                    String target = String.valueOf(chs);
                    if (dict.contains(target)) result.add(target);
                    chs[i] = t;
                }
            }

            return result;
        }

        private void dfs(String curWord, String endWord, HashMap<String, List<String>> graph, List<String> path, List<List<String>> result) {
            path.add(curWord);

            if (curWord.equals(endWord))
                result.add(new ArrayList<String>(path));
            else {
                if(graph.containsKey(curWord)){
                    for (String nextWord : graph.get(curWord)) {
                        dfs(nextWord, endWord, graph, path, result);
                    }
                }
            }
            // backtracking!
            path.remove(path.size() - 1);
        }
    }
}
