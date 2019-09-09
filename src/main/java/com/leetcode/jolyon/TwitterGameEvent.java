package com.leetcode.jolyon;

import java.util.*;

public class TwitterGameEvent {
    public static List<String> getEventsOrder(String team1, String team2,
                                              List<String> events1, List<String> events2) {
        List<String> res = new ArrayList<>();
        for (String s : events1) {
            res.add(team1 + " " + s);
        }
        for (String s : events2) {
            res.add(team2 + " " + s);
        }
        Collections.sort(res, (c1, c2) -> {
            String[] arr1 = c1.split(" ");
            String[] arr2 = c2.split(" ");
            String[] t1 = null;
            String[] t2 = null;
            String teamName1 = arr1[0];
            String teamName2 = arr2[0];
            int i1 = 0;
            for (; i1 < arr1.length; i1++) {
                if (Character.isDigit(arr1[i1].charAt(0))) {
                    t1 = arr1[i1].split("\\+");
                    break;
                }
            }
            int i2 = 0;
            for (; i2 < arr2.length; i2++) {
                if (Character.isDigit(arr2[i2].charAt(0))) {
                    t2 = arr2[i2].split("\\+");
                    break;
                }
            }
            String playerName1 = arr1[1];
            for (int i = 2; i < i1; i++) {
                playerName1 += " " + arr1[i];
            }
            String playerName2 = arr2[1];
            for (int i = 2; i < i2; i++) {
                playerName2 += " " + arr2[i];
            }
            String event1 = arr1[i1 + 1];
            String event2 = arr2[i2 + 1];

            if (Integer.parseInt(t1[0]) != Integer.parseInt(t2[0])) {
                return Integer.parseInt(t1[0]) - Integer.parseInt(t2[0]);
            } else {
                int st1 = t1.length > 1 ? Integer.parseInt(t1[1]) : 0;
                int st2 = t2.length > 1 ? Integer.parseInt(t2[1]) : 0;
                if (st1 != st2) return st1 - st2;
                else {
                    Map<String, Integer> order = new HashMap<>();
                    order.put("G", 0);
                    order.put("Y", 1);
                    order.put("R", 2);
                    order.put("S", 3);
                    if (!order.get(event1).equals(order.get(event2)))
                        return order.get(event1) - order.get(event2);
                    else {
                        if (!teamName1.equals(teamName2)) {
                            return teamName1.compareTo(teamName2);
                        } else {
                            return playerName1.compareTo(playerName2);
                        }
                    }

                }
            }
        });
        return res;
    }
}
