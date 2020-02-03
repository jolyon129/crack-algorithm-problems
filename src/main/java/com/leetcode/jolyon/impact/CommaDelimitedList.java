package com.leetcode.jolyon.impact;

import java.util.Arrays;
import java.util.List;

public class CommaDelimitedList {
    /**
     * Assuming the input is a list of integer. The solution is to iterate along
     * the list and try to form the range at each index. The time complexity is
     * O(n) and the space complexity is O(n) for building the result.
     *
     * @param list a list of integer that need to be group. eg: [1,3,4,5,7,9]
     * @return A string of a comma delimited list of grouped numbers. eg,
     * "1,[3,5],7,9"
     */
    static String groupListToString(List<Integer> list) {
        if (list.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        int i = 0, startIdx;
        while (i < list.size()) {
            startIdx = i;
            while (i + 1 < list.size() && list.get(i + 1) == list.get(i) + 1) {
                i++;
            }
            int endIDx = i;
            if (startIdx != endIDx) {
                if (endIDx == list.size() - 1) {
                    res.append("[").append(list.get(startIdx)).append(",")
                            .append(list.get(endIDx)).append("]");
                } else {
                    res.append("[").append(list.get(startIdx)).append(",")
                            .append(list.get(endIDx)).append("]").append(",");
                }
            } else {
                if (endIDx == list.size() - 1) {
                    res.append(list.get(startIdx));
                } else {
                    res.append(list.get(startIdx)).append(",");
                }
            }
            i++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String ans2 = groupListToString(Arrays.asList(new Integer[]{1}));
        String ans = groupListToString(Arrays.asList(new Integer[]{1, 3, 4, 5, 8,
                9, 10}));
        String ans1 = groupListToString(Arrays.asList(new Integer[]{-1, 0, 1, 1, 3, 5
                , 8, 9, 10}));
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);

    }
}
