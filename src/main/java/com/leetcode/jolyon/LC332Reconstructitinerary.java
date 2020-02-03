package com.leetcode.jolyon;

import java.util.*;

public class LC332Reconstructitinerary {

    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            // map.putIfAbsent() is to put value if key does not exist, here we setup a pq if we meet the key the first timestamp.
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            // add the "destination" to pq for recur search, in lexical order by default
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        helper("JFK");
        return res;
    }

    public void helper(String departure) {
        // If destination exists. When arriving the last departure, add it to res directly
        while (map.containsKey(departure) && !map.get(departure).isEmpty()) {
            // get the next destination, departure and iterate
            helper(map.get(departure).poll());
        }
        res.add(0, departure);
    }
}
