package com.leetcode.jolyon;

import java.util.*;

public class LC399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> maps = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            maps.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            maps.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            maps.get(equations.get(i).get(0)).put(equations.get(i).get(1),
                    values[i]);
            // reverse
            maps.get(equations.get(i).get(1)).put(equations.get(i).get(0),
                    1 / values[i]);
        }
        double[] r = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++)
            r[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, maps,
                    new HashSet<>());
        return r;
    }

    double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
        // backtrack
        if (!m.containsKey(s) || !seen.add(s)) return -1;
        if (s.equals(t)) return r;
        Map<String, Double> next = m.get(s);
        for (String c : next.keySet()) {
            double result = dfs(c, t, r * next.get(c), m, seen);
            // If any one the result is not -1, return it.
            if (result != -1) return result;
        }
        return -1;
    }
}
