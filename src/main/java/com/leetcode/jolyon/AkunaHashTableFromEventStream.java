package com.leetcode.jolyon;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AkunaHashTableFromEventStream {
    /**
     * A class which constructs a view of the Hash Table's state given the input
     * DML Events.
     */
    public static class HashTable {
        private Map<String, String> table;
        private long highWatermark = -1;

        public HashTable(ArrayList<String> rawEvents) {
            table = new HashMap<>();
            for (int i = 0; i < rawEvents.size(); i++) {
                String[] eInfo = rawEvents.get(i).split("\\|");
                String type = eInfo[1];
                String key = eInfo[2];
                highWatermark = Long.valueOf(eInfo[0]);
                if (type.equals("INSERT")) {
                    if (!table.containsKey(key)) {
                        table.put(key, eInfo[3]);
                    }
                } else if (type.equals("UPSERT")) {
                    table.put(key, eInfo[3]);
                } else if (type.equals("DELETE")) {
                    if (table.containsKey(key)) {
                        table.remove(key);
                    }
                }
            }
        }

        /**
         * Retrieve the state of the HashTable after applying all input events
         *
         * @return a Map representing the Keys and Values of the current state
         */
        public Map<String, String> getTable() {
            return table;
        }

        /**
         * Retrieve the high-watermark of the HashTable as the millisecond epoch
         * timestamp of the latest event read or Instant.EPOCH in the case where
         * no event occurred.
         *
         * @return an Instant representing the high watermark
         */
        public Instant getHighWatermark() {
            return highWatermark == -1 ? Instant.EPOCH : Instant.ofEpochMilli(highWatermark);
        }
    }
}
