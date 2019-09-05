package com.leetcode.jolyon;

import java.util.*;

public class LC1156 {
    class Group {
        int startIdx;
        int count;
        int endIdx;

        public Group(int startIdx, int count) {
            this.startIdx = startIdx;
            this.count = count;
            this.endIdx = startIdx + count - 1;
        }
    }

    public int maxRepOpt1(String text) {
        Map<Character, List<Group>> map = new HashMap<>();
        int maxCount = 1;
        for (int i = 0; i < text.length(); i++) {
            char alpha = text.charAt(i);
            int l = i + 1;
            int count = 1;
            while (l < text.length() && text.charAt(l) == alpha) {
                count++;
                l++;
            }
            if (map.get(alpha) == null) map.put(alpha, new ArrayList<Group>());
            List<Group> list = map.get(alpha);
            list.add(new Group(i, count));
            if (l == text.length()) break;
            else i = l - 1;
        }
        for (Character c : map.keySet()) {
            List<Group> list = map.get((char) (c));
            if (list == null) continue;
            for (int k = 0; k < list.size(); k++) {
                if (k == 0) {
                    int totalCount;
                    if (list.size() == 1) totalCount = list.get(k).count;
                    else {
                        if (list.get(k + 1).startIdx == list.get(k).endIdx + 2) {
                            if (list.size() > 2)
                                totalCount =
                                        list.get(k+1).count + list.get(k).count + 1;
                            else{
                                totalCount =
                                        list.get(k+1).count + list.get(k).count;
                            }
                        }else{
                            totalCount = list.get(k).count+1;
                        }
                    }
                    if (totalCount > maxCount) maxCount = totalCount;
                } else {
                    int totalCount;
                    if (list.get(k - 1).endIdx + 2 == list.get(k).startIdx) {
                        if (list.size() > 2) {
                            totalCount =
                                    list.get(k - 1).count + list.get(k).count + 1;
                        } else {
                            totalCount = list.get(k - 1).count + list.get(k).count;
                        }

                    } else {
                        totalCount = list.get(k).count + 1;
                    }
                    if (totalCount > maxCount) maxCount = totalCount;
                }

            }
        }
        return maxCount;
    }
}
