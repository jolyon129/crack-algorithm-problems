package com.leetcode.jolyon;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class AkunaEventStreamFromBinaryWAL {
    /**
     * A class which wraps a raw binary WAL and reconstructs DML Events.
     */
    public static class WAL {

        ArrayList<String> events = new ArrayList<>();

        /**
         * Construct the WAL
         *
         * @param input the raw binary WAL
         */
        public WAL(byte[] input) {
            int idx = 0;
            while (idx < input.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(bytesToLong(input, idx, idx + 8));
                sb.append("|");
                idx = idx + 8;
                String type = parseType(input, idx);
                idx = idx + 1;
                sb.append(type);
                sb.append("|");
                int lenOfKey = (int) bytesToLong(input, idx, idx + 2);
                idx = idx + 2;
                sb.append(bytesToStrOfASC(input, idx, idx + lenOfKey));
                idx = idx + lenOfKey;
                if (!type.equals("DELETE")) {
                    sb.append("|");
                    int lenOfVal = (int) bytesToLong(input, idx, idx + 2);
                    idx = idx + 2;
                    sb.append(bytesToStrOfASC(input, idx, idx + lenOfVal));
                    idx = idx + lenOfVal;
                }
                events.add(sb.toString());
            }

        }


        private long bytesToLong(byte[] input, int start, int end) {
            long timestamp = 0;
            for (int i = start; i < end; i++) {
                timestamp = (timestamp << 8) + (input[i] & 0xff);
            }
            return timestamp;
        }

        private String parseType(byte[] input, int start) {
            int type = (int) input[start];
            String res = "";
            if (type == 0) {
                res = "INSERT";
            } else if (type == 1) {
                res = "UPSERT";
            } else if (type == 2) {
                res = "DELETE";
            }
            return res;
        }

        private String bytesToStrOfASC(byte[] input, int start, int end) {
            String str = new String(Arrays.copyOfRange(input, start, end), StandardCharsets.US_ASCII);
            return str;
        }


        /**
         * Retrieve all events contained within the WAL as their string values
         * in timestamp order DML Event String Format: "<epoch_milli>|<message_name>|<key>|<value>"
         *
         * @return a timestamp-ordered sequence of DML Event strings
         */
        public ArrayList<String> getEvents() {
            return events;
        }
    }
}
