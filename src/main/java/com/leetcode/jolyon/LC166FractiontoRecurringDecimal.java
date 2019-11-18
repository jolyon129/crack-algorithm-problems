package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC166FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // I don't consider overflow
        boolean isNegative = numerator * denominator < 0;
        long divided = Math.abs(Long.valueOf(numerator) );
        long divisor = Math.abs(Long.valueOf(denominator));
        StringBuilder fractions = new StringBuilder();
        Map<Long, Integer> remainders = new HashMap<>();
        fractions.append(divided / divisor);
        long re = divided % divisor;
        if (re == 0){
            return isNegative? "-"+fractions.toString(): fractions.toString();
        }
        fractions.append('.');
        long f = -1;
        while (re != 0) {
            remainders.put(re, fractions.length());
            f = re * 10 / divisor;
            re = re * 10 % divisor;
            fractions.append(f);
            if (remainders.containsKey(re)) {
                int idx = remainders.get(re);
                fractions.insert(idx, '(');
                fractions.append(')');
                break;
            }
        }

        return isNegative? "-"+fractions.toString(): fractions.toString();
    }
}
