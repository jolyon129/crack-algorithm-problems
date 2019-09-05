package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC937ReorderLogFiles {
    /**
     * Custom sort
     */
    static class Solution {
        public String[] reorderLogFiles(String[] logs) {
            if (logs.length <= 1) return logs;
            Arrays.sort(logs, (w1, w2) -> {
                String[] s1 = w1.split(" ", 2);
                String[] s2 = w2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
                if (isDigit1 && isDigit2) {
                    return 0;
                } else if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    int cmp = s1[1].compareTo(s2[1]);
                    if (cmp == 0) {
                        return s1[0].compareTo(s2[0]);
                    } else {
                        return cmp;
                    }
                }
            });
            return logs;
        }
    }

    static class Solution1 {
        public String[] reorderLogFiles(String[] logs) {
            if (logs.length <= 1) return logs;
            List<String> res = new ArrayList<>();
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < logs.length; i++) {
                int l = logs[i].length();
                if (Character.isLetter(logs[i].charAt(l - 1))) {
                    res.add(logs[i]);
                } else {
                    tmp.add(logs[i]);
                }
            }
            res.sort((w1, w2) -> {
                String[] split1 = w1.split(" ", 2);
                String[] split2 = w2.split(" ", 2);
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp == 0) {
                    return split1[0].compareTo(split2[0]);
                } else {
                    return cmp;
                }
            });
            res.addAll(tmp);
            return res.toArray(new String[1]);
        }
    }

    static class MySolution {
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (String s1, String s2) -> {
                String[] split1 = s1.split("\\s+", 2);
                String[] split2 = s2.split("\\s+", 2);
                String s1Id = split1[0];
                String s2Id = split2[0];
                String s1Log = split1[1];
                String s2Log = split2[1];
                Character head1 = s1Log.charAt(0);
                Character head2 = s2Log.charAt(0);
                if (!Character.isDigit(head1) && Character.isDigit(head2)) {
                    return -1;
                } else if (Character.isDigit(head1) && !Character.isDigit(head2)) {
                    return 1;
                } else if (!Character.isDigit(head1) && !Character.isDigit(head2)) {

                    int res = s1Log.compareTo(s2Log);
                    if (res != 0) {
                        return res;
                    } else {
                        return s1Id.compareTo(s2Id);
                    }
                } else {
                    return 0;
                }
            });
            return logs;
        }

    }
}
