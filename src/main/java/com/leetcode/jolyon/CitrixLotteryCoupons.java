package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class CitrixLotteryCoupons {
    int lotteryCoupons(int[] coupons, int[] couponSums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxFre = 0;
        for (int i = 0; i < coupons.length; i++) {
            frequency.put(couponSums[i],
                    frequency.getOrDefault(couponSums[i], 0) + 1);
            maxFre = Math.max(frequency.get(couponSums[i]), maxFre);
        }
        int ans = 0;
        for (Integer key : frequency.keySet()) {
            if (frequency.get(key) == maxFre) {
                ans++;
            }
        }
        return ans;
    }
}
