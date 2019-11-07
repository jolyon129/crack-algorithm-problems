package com.leetcode.jolyon;

public class LC269AlienDictionary {
    boolean hasCycle = false;
    public String alienOrder(String[] words) {
        Boolean[][] adjMatrix = new Boolean[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                adjMatrix[i][j] = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                visited[c - 'a'] = -1; // haven't visited
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            int minLength = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < minLength; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    adjMatrix[words[i].charAt(j) - 'a'][words[i + 1].charAt(j) - 'a'] = true;
                    j = minLength;
                } else {
                    continue;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (visited[i] == -1) {
                dfs(adjMatrix, sb, i, visited);
                if(hasCycle) return "";
            }
        }
        return sb.reverse().toString();
    }

    private void dfs(Boolean[][] adjMatrix, StringBuilder sb, int x,
                     int[] visited) {

        visited[x] = 1;// Is visiting
        for (int i = 0; i < adjMatrix[x].length; i++) {
            if (adjMatrix[x][i]) {
                if(visited[i]==1){
                    hasCycle = true;
                }
                if (visited[i] == -1) {
                    dfs(adjMatrix, sb, i, visited);
                }
            }

        }

        visited[x] = 2; // Finish visiting
        sb.append((char) (x + 'a'));
    }
}
