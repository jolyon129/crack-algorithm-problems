package com.leetcode.jolyon;

import java.util.*;

public class LC721AccountsMerge {
    static class MySolution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            DSU dsu = new DSU(accounts);
            Map<String, String> emailToName = new HashMap<>();
            Map<String, List<String>> parentToUnions = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                List<String> account = accounts.get(i);
                for (int j = 0; j < account.size(); j++) {
                    if(j==0) continue;
                    if (!emailToName.containsKey(account.get(j))) {
                        emailToName.put(account.get(j), account.get(0));
                    }
                    if (j > 1) {
                        dsu.union(account.get(j), account.get(j - 1));
                    }
                }
            }
            for (String email : dsu.parents.keySet()) {
                String parent = dsu.find(email);
                List<String> union = parentToUnions.getOrDefault(parent,
                        new ArrayList<>());
                union.add(email);
                parentToUnions.put(parent, union);
            }
            List<List<String>> res = new ArrayList<>();
            for(List<String> union: parentToUnions.values()){
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(emailToName.get(union.get(0)));
                Collections.sort(union);
                tmp.addAll(union);
                res.add(tmp);
            }
            return res;
        }

        class DSU {
            Map<String, String> parents;
            Map<String, Integer> ranks;

            public DSU(List<List<String>> accounts) {
                parents = new HashMap<String, String>();
                ranks = new HashMap<String, Integer>();
                for (List<String> account : accounts) {
                    for (int i = 1; i < account.size(); i++) {
                        if (!ranks.containsKey(account.get(i))) {
                            ranks.put(account.get(i), 0);
                        }
                        if (!parents.containsKey(account.get(i))) {
                            parents.put(account.get(i), account.get(i));
                        }
                    }
                }
            }

            public String find(String email) {
                if (parents.get(email) != email) {
                    parents.put(email, find(parents.get(email)));
                }
                return parents.get(email);
            }

            public void union(String e1, String e2) {
                if (find(e1) == find(e2)) {
                    return;
                }
                String parent1 = find(e1);
                String parent2 = find(e2);
                if (ranks.get(parent1) < ranks.get(parent2)) {
                    parents.put(parent1, parent2);
                } else if (ranks.get(parent1) > ranks.get(parent2)) {
                    parents.put(parent2, parent1);
                } else {
                    parents.put(parent2, parent1);
                    ranks.put(parent1, ranks.get(parent1) + 1);
                }
            }

        }
    }
}
