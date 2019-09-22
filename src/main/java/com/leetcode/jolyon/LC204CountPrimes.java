package com.leetcode.jolyon;

public class LC204CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        notPrime[1] = true;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
