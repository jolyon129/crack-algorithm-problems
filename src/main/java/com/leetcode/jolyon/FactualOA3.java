package com.leetcode.jolyon;

import java.util.*;

public class FactualOA3 {

    public static int solution(String[] modulesToBuild, String[][] dependencies) {
        Map<String, List<String>> deps = mapifyArgument(dependencies);
        Set<String> results = new HashSet<>();
        for (String target : modulesToBuild) {
            Deque<String> queue = new ArrayDeque<>();
            queue.add(target);
            while (!queue.isEmpty()) {
                String module = queue.pollFirst();
                results.add(module);
                if (!deps.containsKey(module)) {
                    continue;
                }
                for (String dep : deps.get(module)) {
                    if (!results.contains(dep)) {
                        queue.addLast(dep);
                    }
                }
            }
        }

        return results.size();
    }

    public static Map<String, List<String>> mapifyArgument(String[][] arg) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < arg.length; i++) {
            String module = arg[i][0];
            String dep = arg[i][1];
            if (!map.containsKey(module)) {
                map.put(module, new ArrayList<String>());
            }
            map.get(module).add(dep);
        }
        return map;
    }


}
