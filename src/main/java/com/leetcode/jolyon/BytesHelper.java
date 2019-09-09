package com.leetcode.jolyon;

import java.io.UnsupportedEncodingException;

public class BytesHelper {
    public static byte[] sint32ToBytes(final int data) {
        byte[] res = new byte[4];
        int t = 0;
        for (int i = 3; i >= 0; i--) {
            res[i] = (byte) ((data >> t) & 0xff);
            t += 8;
        }
        return res;
    }

    public static byte[] uint16ToBytes(final int data) {
        return new byte[]{
                (byte) ((data >> 8) & (0xff)),
                (byte) ((data >> 0) & (0xff)),
        };
    }

    public static byte[] longToBytes(final long data) {
        byte[] res = new byte[8];
        int t = 0;
        for (int i = 7; i >= 0; i--) {
            res[i] = (byte) ((data >> t) & 0xff);
            t += 8;
        }
        return res;
    }

    public static long L8bytesToLong(final byte[] data) {
        long res = 0;
        int d = 0;
        for (int i = 7; i >= 0; i--) {
            // Have to multiple 0xffL!!
            // Have to cast data[i] and 0xff to long!!!
            res += (((long) data[i] & 0xffL) << d);
            d += 8;
        }
        return res;
    }

    public static long bytesToLong(final byte[] by) {
        long value = 0;
        for (int i = 0; i < by.length; i++) {

            value = (value << 8) + (by[i] & 0xff);
        }
        return value;
    }

    public static String bytesToStrOfASC(final byte[] by) {
        String str = "";
        try {
            str = new String(by, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
